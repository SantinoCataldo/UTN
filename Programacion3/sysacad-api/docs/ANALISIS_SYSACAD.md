# Análisis del SYSACAD Actual

## Información técnica obtenida

- **URL analizada:** `https://autogestion.mdp.utn.edu.ar`
- **Fecha de análisis:** 25 de abril de 2026
- **Método:** Inspección del HTML fuente (`view-source`)

## Hallazgos técnicos

### 1. Stack tecnológico obsoleto
- **Frontend:** HTML 4.01 Transitional (estándar de 1999).
- **Backend:** ASP Clásico (`.asp`), tecnología de hace más de 20 años.
- **Encoding:** ISO-8859-1 en vez de UTF-8.
- **Layout:** Tablas HTML (`<table>`) usadas para maquetar toda la página.
- **Estilos:** CSS embebido e inline, sin hojas de estilo externas ni frameworks modernos.

### 2. Problemas de UI/UX
- **Diseño no responsive:** Aunque existe una etiqueta `<meta viewport>`, el layout basado en tablas de ancho fijo impide una correcta visualización en móviles.
- **Sin feedback visual moderno:** No hay loaders, animaciones de carga ni validaciones en tiempo real.
- **Formularios primitivos:** Campos sin estilos consistentes, sin íconos ni estados de error claros.
- **Texto corrupto:** Por el encoding ISO-8859-1, se observan caracteres rotos (ej: `Ingenier�a`, `autogesti�n`).

### 3. Problemas de arquitectura
- **Sin separación de capas:** Lógica de negocio, presentación y acceso a datos están mezclados en archivos `.asp`.
- **Sin API REST:** Cada interacción genera un postback completo de página (`METHOD="POST" ACTION="menuAlumno.asp"`).
- **Sin documentación:** No existe Swagger, OpenAPI, ni ninguna forma de integrar el sistema con otras aplicaciones.
- **Código spaghetti:** Comentarios del propio código indican que ciertos archivos "no se pisan nunca en las actualizaciones", evidenciando fragilidad.

### 4. Problemas de performance
- **Postbacks completos:** Cada click recarga toda la página en lugar de consumir una API y actualizar solo lo necesario.
- **Sin caché frontend:** No se observan estrategias de caché de recursos estáticos.
- **Sin asincronía:** Todo es síncrono, bloqueando la interfaz en cada operación.

### 5. Problemas de seguridad
- **Sin JWT / OAuth:** La autenticación es un formulario POST clásico a un `.asp`.
- **Validación de contraseña en frontend:** El campo password tiene `maxlength="12"` y `pattern` restrictivo, lo cual es una mala práctica de seguridad (limitar longitud de contraseñas).
- **Sin HTTPS visible:** Aunque la URL usa HTTPS, no hay headers de seguridad observables ni CSP.

## Conclusión

El SYSACAD actual es un sistema legado atrapado en tecnologías de principios de los 2000. Cumple funcionalmente, pero es lento, frágil, difícil de mantener y con una experiencia de usuario muy pobre.

**La solución que proponemos (y que cumple con el TP):**
- API RESTful con **Spring Boot**.
- Persistencia con **Spring Data JPA + MySQL**.
- Autenticación stateless con **JWT + Spring Security**.
- Separación estricta de capas: **Controller → Service → Repository**.
- Uso de **DTOs** para no exponer entidades JPA.
- **Documentación Swagger/OpenAPI** para facilitar integraciones futuras.
- Frontend moderno (opcional para la demo) que consuma la API de forma asíncrona.
