
void MatrizesUno(){
    int[][] matriz = new int[9][9];

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            matriz[i][j] = (int) (Math.random() * 100);
        }
    }


    int sumaFila = 0;
    int sumaColumna = 0;
    int sumaDiagonalIzquierda = 0;
    int sumaDiagonalDerecha = 0;

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            sumaFila += matriz[i][j];
            sumaColumna += matriz[j][i];
            if (i == j){
                sumaDiagonalIzquierda += matriz[i][j];
            //    System.out.println(sumaDiagonalIzquierda);
            } else if (i + j == matriz.length - 1) {
                sumaDiagonalDerecha += matriz[i][j];
            //    System.out.println(sumaDiagonalDerecha);
            }


        }
        System.out.println("Suma de fila: " + (i + 1) + " es " + sumaFila);
        System.out.println("Suma de columna: "+  (i + 1) + " es " + sumaColumna);
        sumaFila = 0;
        sumaColumna = 0;
    }
    System.out.println("Suma en diagonal 1 es: "  + sumaDiagonalIzquierda);
    System.out.println("Suma en diagonal 2 es: "  + sumaDiagonalDerecha);
}

void mostrarMatriz(int[][] matriz){
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print("[" + matriz[i][j] + "]");
        }
        System.out.println();
    }
}


void invertirHorizontalmente(){
    int[][] matriz = new int[9][9];

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            matriz[i][j] = (int) (Math.random() * 100);
        }
    }
    System.out.println("Matriz inicial");
    mostrarMatriz(matriz);

    // La logica es que
    for (int i = 0; i < (matriz.length % 2 == 0? matriz.length/2 : (matriz.length - 1)/2); i++) {
        int[] aux = matriz[i];
        matriz[i] = matriz[matriz.length - 1 - i];
        matriz[matriz.length - 1 - i] = aux;
    }
    System.out.println("Matriz invertido");
    mostrarMatriz(matriz);
}

void invertirVerticalmente(){
    int[][] matriz = new int[9][9];

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            matriz[i][j] = (int) (Math.random() * 100);
        }
    }
    System.out.println("Matriz inicial");
    mostrarMatriz(matriz);


    for (int i = 0; i < (matriz.length % 2 == 0? matriz.length/2 : (matriz.length - 1)/2); i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            
        }









































































































































































































































        



        int[] aux = matriz[i];
        matriz[i] = matriz[matriz.length - 1 - i];
        matriz[matriz.length - 1 - i] = aux;
    }
    System.out.println("Matriz invertido");
    mostrarMatriz(matriz);
}

void invertirAmbas(){}





void main() {
    // MatrizesUno();
    invertirHorizontalmente();
}
