int factorial(int n) {
    if (n <= 1)
        return 1;
    return n * factorial(n - 1);
}

int potencia(int base, int exponente) {
    if (exponente == 0)
        return 1;
    return base * potencia(base, exponente - 1);
}

void mostrarArreglo(int arr[], int n, int i) {
    if (i >= n)
        return;
    printf("%d ", arr[i]);
    mostrarArreglo(arr, n, i + 1);
}

void mostrarInverso(int arr[], int n, int i) {
    if (i >= n)
        return;
    mostrarInverso(arr, n, i + 1);
    printf("%d ", arr[i]);
}

int esCapicua(int arr[], int inicio, int fin) {
    if (inicio >= fin)
        return 1;
    if (arr[inicio] != arr[fin])
        return 0;
    return esCapicua(arr, inicio + 1, fin - 1);
}

int sumaArreglo(int arr[], int n) {
    if (n == 0)
        return 0;
    return arr[n - 1] + sumaArreglo(arr, n - 1);
}

int menorElemento(int arr[], int n) {
    if (n == 1)
        return arr[0];
    int menor = menorElemento(arr, n - 1);
    return (arr[n - 1] < menor) ? arr[n - 1] : menor;
}

int menorArchivo(FILE *f) {
    int num;
    if (fread(&num, sizeof(int), 1, f) != 1)
        return INT_MAX;
    int menorSig = menorArchivo(f);
    return (num < menorSig) ? num : menorSig;
}

void invertirArreglo(int arr[], int i, int j) {
    if (i >= j) return;
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    invertirArreglo(arr, i + 1, j - 1);
}

   fseek(archivo, 0, SEEK_END);

    // Obtener la posición actual (es decir, el tamaño en bytes del archivo)
    long tamanio = ftell(f);

    // Calcular cuántos enteros hay
    int cantidad = tamanio / sizeof(int);

    printf("El archivo contiene %d números enteros.\n", cantidad);

    fclose(archivo);