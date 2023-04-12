import java.util.Random;
import java.util.Scanner;

public class BuscaMinas {

    public static int filas = 5;
    public static int columnas = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

         int numMinas = 0;
         String dificultad = "";

        System.out.println("Seleccione la dificultad del juego: (Facil / Medio / Dificil)");
        dificultad = sc.nextLine();

        switch (dificultad) {
            case "Facil":
                numMinas = 5;
                break;
            case "Medio":
                numMinas = 8;
                break;
            case "Dificil":
                numMinas = 10;
                break;
            default:
                System.out.println("Se elige la dificultad mas facil");
                numMinas = 5;
        }

        //Inicializamos el tablero
        char[][] tablero = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '-';
            }
        }

        //Colocamos las minas
        for (int i =0; i < numMinas; i++) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (tablero[fila][columna] == '*') {
                i--;
            } else {
                tablero[fila][columna] = '*';
            }
        }

        //Jugar
        int jugadas = 0;
        boolean perdido = false;

        while(jugadas < 6 && !perdido) {
            System.out.println("Ingrese las coordenadas (fila, columna)");
            int fila = sc.nextInt();
            int columna = sc.nextInt();

            if(fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                System.out.println("Coordenadas invalidas");
            } else if (tablero[fila][columna] == '*') {
                System.out.println("!BOOM!, explota la mina. Has perdido");
                tablero[fila][columna] = 'X';
                perdido = true;
            } else {
                tablero[fila][columna] = 'O';
                jugadas++;
            }
        }

        //Mostrar tablero

        for (int i = 0; i < filas; i++) {
            System.out.println("");
            for (int j = 0; j < columnas; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
        }


    }
}
