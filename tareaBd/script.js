// ==========================================================================
// BIG DATA PRESENTATION & INTERACTIVE EXERCISE CENTRAL SCRIPT
// ==========================================================================

// ─────── 1. PRESENTATION SLIDE NAVIGATION (presentation-body) ───────
if (document.body.classList.contains('presentation-body')) {
    const slides = document.querySelectorAll('.slide');
    const totalSlides = slides.length;
    let currentSlide = 1;

    const counter = document.getElementById('slideCounter');
    const progress = document.getElementById('progressFill');
    const prevBtn = document.getElementById('prevBtn');
    const nextBtn = document.getElementById('nextBtn');

    function padNum(n) {
        return n.toString().padStart(2, '0');
    }

    function updateUI() {
        if (counter) counter.textContent = `${padNum(currentSlide)} / ${padNum(totalSlides)}`;
        if (progress) progress.style.width = `${(currentSlide / totalSlides) * 100}%`;
    }

    function goToSlide(n) {
        if (n < 1 || n > totalSlides || n === currentSlide) return;

        const direction = n > currentSlide ? 1 : -1;
        const currentEl = slides[currentSlide - 1];
        const nextEl = slides[n - 1];

        // Exit current
        currentEl.classList.remove('active');
        currentEl.style.transform = direction === 1 ? 'translateX(-60px)' : 'translateX(60px)';

        // Enter next
        nextEl.style.transform = direction === 1 ? 'translateX(60px)' : 'translateX(-60px)';
        
        // Force reflow
        void nextEl.offsetWidth;

        nextEl.classList.add('active');
        nextEl.style.transform = '';

        // Reset scroll
        nextEl.scrollTop = 0;

        currentSlide = n;
        updateUI();
    }

    function nextSlide() {
        goToSlide(currentSlide + 1);
    }

    function prevSlide() {
        goToSlide(currentSlide - 1);
    }

    // Button clicks
    if (nextBtn) nextBtn.addEventListener('click', nextSlide);
    if (prevBtn) prevBtn.addEventListener('click', prevSlide);

    // Keyboard navigation
    document.addEventListener('keydown', (e) => {
        if (e.key === 'ArrowRight' || e.key === ' ') {
            e.preventDefault();
            nextSlide();
        } else if (e.key === 'ArrowLeft') {
            e.preventDefault();
            prevSlide();
        } else if (e.key === 'Home') {
            e.preventDefault();
            goToSlide(1);
        } else if (e.key === 'End') {
            e.preventDefault();
            goToSlide(totalSlides);
        }
    });

    // Touch swipe support
    let touchStartX = 0;
    let touchEndX = 0;

    document.addEventListener('touchstart', (e) => {
        touchStartX = e.changedTouches[0].screenX;
    }, { passive: true });

    document.addEventListener('touchend', (e) => {
        touchEndX = e.changedTouches[0].screenX;
        const diff = touchStartX - touchEndX;
        if (Math.abs(diff) > 60) {
            if (diff > 0) nextSlide();
            else prevSlide();
        }
    }, { passive: true });

    // Initialize
    updateUI();
}

// ─────── 2. INTERACTIVE EXERCISE WIZARD LOGIC (exercise-body) ───────
if (document.body.classList.contains('exercise-body')) {
    let keypadBuffer = "";
    let matchScore = 0;

    // Helper for shake animations
    function shakeElement(el) {
        if (!el) return;
        el.classList.add('shake-animation');
        el.addEventListener('animationend', () => {
            el.classList.remove('shake-animation');
        }, { once: true });
    }

    // Room Switcher
    window.goToRoom = function(roomNum) {
        if (roomNum < 1 || roomNum > 4) return;

        // Hide all containers
        document.querySelectorAll('.escape-room-container').forEach(c => c.classList.remove('active-room'));

        // Success screen transition
        if (roomNum === 4) {
            const successCard = document.getElementById('roomSuccess');
            if (successCard) successCard.classList.add('active-room');

            // Mark Step 3 as completed in tracker
            const step3 = document.getElementById('step3');
            if (step3) {
                step3.className = 'escape-step completed';
            }

            const progressCount = document.getElementById('progressCompletedCount');
            if (progressCount) progressCount.textContent = "3";

            const progressPanel = document.getElementById('progressPanelSm');
            if (progressPanel) progressPanel.style.display = 'none';

            const headerAlert = document.querySelector('.escape-alert-badge');
            if (headerAlert) {
                headerAlert.innerHTML = '<i class="fa-solid fa-circle-check"></i> CLÚSTER ESTABILIZADO';
                headerAlert.style.background = 'var(--lime)';
                headerAlert.style.color = 'var(--dark)';
            }
            window.scrollTo({ top: 0, behavior: 'smooth' });
            return;
        }

        // Show target container
        const targetRoom = document.getElementById(`room${roomNum}Container`);
        if (targetRoom) targetRoom.classList.add('active-room');

        // Update tracker classes
        document.querySelectorAll('.escape-step').forEach((step, index) => {
            const stepNum = index + 1;
            step.className = 'escape-step';
            if (stepNum === roomNum) {
                step.classList.add('active');
            } else if (stepNum < roomNum) {
                step.classList.add('completed');
            }
        });

        const progressCount = document.getElementById('progressCompletedCount');
        if (progressCount) progressCount.textContent = roomNum - 1;

        window.scrollTo({ top: 0, behavior: 'smooth' });
    };

    // ─── LEVEL 1: KEYPAD TERMINAL ───
    window.pressKey = function(key) {
        if (keypadBuffer.length >= 8) return;
        keypadBuffer += key;
        updateKeypadDisplay();
    };

    window.clearKeypad = function() {
        keypadBuffer = "";
        updateKeypadDisplay();
    };

    window.backspaceKeypad = function() {
        keypadBuffer = keypadBuffer.slice(0, -1);
        updateKeypadDisplay();
    };

    function updateKeypadDisplay() {
        const monitor = document.getElementById('keypadMonitor');
        if (monitor) monitor.textContent = keypadBuffer;
    }

    window.checkRoom1 = function() {
        const feedback = document.getElementById('room1Feedback');
        const keypadWrapper = document.querySelector('.keypad-wrapper');

        if (keypadBuffer === "8") {
            // Correct (8.192 TB = 8 PB, using binary 1.024 multiplier)
            if (feedback) {
                feedback.className = 'room-feedback show correct';
                feedback.innerHTML = '<i class="fa-solid fa-circle-check"></i> ¡CÓDIGO DE ACCESO CORRECTO! NameNode estabilizado. Inicializando buffer de Kafka...';
            }
            
            // Disable keypad buttons
            document.querySelectorAll('.keypad-btn').forEach(btn => btn.disabled = true);

            setTimeout(() => {
                goToRoom(2);
            }, 1800);
        } else {
            // Incorrect
            if (feedback) {
                feedback.className = 'room-feedback show incorrect';
                feedback.innerHTML = '<i class="fa-solid fa-circle-xmark"></i> ERROR: CÓDIGO INCORRECTO. Relación de escala desbalanceada.';
            }
            shakeElement(keypadWrapper);
            keypadBuffer = "";
            updateKeypadDisplay();
        }
    };

    // ─── LEVEL 2: SEQUENCER CARD MOVEMENT ───
    window.moveCardUp = function(cardId) {
        const card = document.getElementById(cardId);
        if (!card) return;
        const prev = card.previousElementSibling;
        if (prev && prev.classList.contains('sequencer-card')) {
            card.parentNode.insertBefore(card, prev);
        }
    };

    window.moveCardDown = function(cardId) {
        const card = document.getElementById(cardId);
        if (!card) return;
        const next = card.nextElementSibling;
        if (next && next.classList.contains('sequencer-card')) {
            card.parentNode.insertBefore(next, card);
        }
    };

    window.checkRoom2 = function() {
        const list = document.getElementById('sequencerList');
        const feedback = document.getElementById('room2Feedback');
        
        if (!list) return;

        const cards = list.querySelectorAll('.sequencer-card');
        const order = Array.from(cards).map(card => card.dataset.stage);
        
        // Correct order: 1. Split, 2. Map, 3. Shuffle, 4. Reduce
        const correctOrder = ["split", "map", "shuffle", "reduce"];
        const isCorrect = order.every((val, index) => val === correctOrder[index]);

        if (isCorrect) {
            if (feedback) {
                feedback.className = 'room-feedback show correct';
                feedback.innerHTML = '<i class="fa-solid fa-circle-check"></i> ¡TUBERÍA ESTABILIZADA! MapReduce funcionando al 100%. Abriendo consola de desanonimización...';
            }
            document.getElementById('sequencerCheckBtn').disabled = true;
            document.querySelectorAll('.sc-move-btn').forEach(btn => btn.disabled = true);

            setTimeout(() => {
                goToRoom(3);
            }, 1800);
        } else {
            if (feedback) {
                feedback.className = 'room-feedback show incorrect';
                feedback.innerHTML = '<i class="fa-solid fa-circle-xmark"></i> ERROR: SECUENCIA INCORRECTA. Tubería desbordada. Verifiquen el flujo lógico.';
            }
            shakeElement(list);
        }
    };
    // ─── LEVEL 3: CLINICAL DECRYPTION DASHBOARD ───
    let currentSelectedProfile = null;

    window.selectProfile = function(profileNum) {
        currentSelectedProfile = profileNum;

        // Reset feedback
        const feedback = document.getElementById('room3Feedback');
        if (feedback) {
            feedback.className = 'room-feedback';
            feedback.innerHTML = '';
        }

        // Highlight active sidebar card
        document.querySelectorAll('.profile-card').forEach(card => card.classList.remove('selected'));
        const activeCard = document.getElementById(`prof${profileNum}`);
        if (activeCard) activeCard.classList.add('selected');

        // Hide placeholder and show content
        const placeholder = document.getElementById('pdpPlaceholder');
        const content = document.getElementById('pdpContent');
        if (placeholder) placeholder.style.display = 'none';
        if (content) content.style.display = 'block';

        // Details bindings
        const title = document.getElementById('pdpTitle');
        const gps = document.getElementById('pdpGPS');
        const hr = document.getElementById('pdpHR');
        const history = document.getElementById('pdpHistory');
        const type = document.getElementById('pdpType');
        
        // Reset UI components
        const alertBox = document.getElementById('pdpAlertBox');
        if (alertBox) alertBox.style.display = 'none';

        const deanonBtn = document.getElementById('deanonBtn');
        if (deanonBtn) deanonBtn.style.display = 'block';

        const deanonLoading = document.getElementById('deanonLoading');
        if (deanonLoading) deanonLoading.style.display = 'none';

        if (profileNum === 1) {
            title.textContent = "Perfil #819 ( Wearable IoT )";
            gps.textContent = "12:00 PM — Puerto Madero (-34.6095, -58.3629)";
            hr.textContent = "90 BPM ( Estable )";
            history.textContent = "Hipertensión leve bajo tratamiento farmacológico";
            type.textContent = "Métricas de Actividad Diaria";
        } else if (profileNum === 2) {
            // Correct Profile!
            title.textContent = "Perfil #221 ( Clínica Médica )";
            gps.textContent = "10:00 AM — Hospital Central (-34.6037, -58.3816)";
            hr.textContent = "130 BPM ( Taquicardia severa detectada )";
            history.textContent = "Fibrilación auricular con internación transitoria";
            type.textContent = "Historial Clínico de Emergencia";
        } else if (profileNum === 3) {
            title.textContent = "Perfil #402 ( Auditoría GPS )";
            gps.textContent = "08:00 AM — Aeropuerto Ezeiza (-34.8150, -58.5348)";
            hr.textContent = "85 BPM ( Reposo )";
            history.textContent = "Control médico de rutina y aptitud de vuelo";
            type.textContent = "Telemetría del Sensor Cardíaco";
        }
    };

    window.deanonProfile = function() {
        if (!currentSelectedProfile) return;

        const deanonBtn = document.getElementById('deanonBtn');
        const deanonLoading = document.getElementById('deanonLoading');
        const alertBox = document.getElementById('pdpAlertBox');
        const feedback = document.getElementById('room3Feedback');
        const detailsPanel = document.querySelector('.profile-details-panel');

        if (deanonBtn) deanonBtn.style.display = 'none';
        if (deanonLoading) deanonLoading.style.display = 'block';
        if (feedback) {
            feedback.className = 'room-feedback';
            feedback.innerHTML = '';
        }

        setTimeout(() => {
            if (deanonLoading) deanonLoading.style.display = 'none';

            if (currentSelectedProfile === 2) {
                // Correct match!
                if (alertBox) {
                    alertBox.style.display = 'block';
                    alertBox.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
                }
                if (feedback) {
                    feedback.className = 'room-feedback show correct';
                    feedback.innerHTML = '<i class="fa-solid fa-circle-check"></i> COINCIDENCIA ENCONTRADA. Cruzando registros del hospital con telemetría IoT... Carlos Menem desanonimizado con éxito.';
                }
            } else {
                // Incorrect match!
                if (deanonBtn) deanonBtn.style.display = 'block';
                if (feedback) {
                    feedback.className = 'room-feedback show incorrect';
                    feedback.innerHTML = '<i class="fa-solid fa-circle-xmark"></i> ERROR DE COINCIDENCIA: Las coordenadas y el ritmo cardíaco no coinciden con las del reloj inteligente de la víctima.';
                }
                shakeElement(detailsPanel);
            }
        }, 1500);
    };

    window.checkRoom3 = function() {
        const input = document.getElementById('masterEscapeKeyInput');
        const feedback = document.getElementById('room3Feedback');
        const consoleWrapper = document.querySelector('.ethics-console-wrapper');
        
        if (!input) return;

        const key = input.value.trim().toUpperCase();

        if (key === "DBA_ETICA_2026") {
            if (feedback) {
                feedback.className = 'room-feedback show correct';
                feedback.innerHTML = '<i class="fa-solid fa-circle-check"></i> ¡LLAVE CRIPTOGRÁFICA ACEPTADA! Parando protocolo de bloqueo...';
            }
            input.disabled = true;
            document.querySelector('.ethics-console-wrapper button').disabled = true;

            setTimeout(() => {
                goToRoom(4);
            }, 1500);
        } else {
            if (feedback) {
                feedback.className = 'room-feedback show incorrect';
                feedback.innerHTML = '<i class="fa-solid fa-circle-xmark"></i> ERROR: LLAVE INVÁLIDA. Clúster desprotegido.';
            }
            shakeElement(consoleWrapper);
            input.value = "";
        }
    };
}

