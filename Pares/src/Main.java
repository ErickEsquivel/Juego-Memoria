import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Funciones funcion = new Funciones();
        Scanner scanner = new Scanner(System.in);

        char[][] tableroVisible = new char[4][4];
        char[][] tableroLetras = new char[4][4];

        int[] puntuaciones = {0, 0}; // puntuaciones[0] para jugador 1, puntuaciones[1] para jugador 2


        funcion.inicializarTablero(tableroVisible);
        funcion.rellenarConPares(tableroLetras);
        funcion.mostrarTablero(tableroVisible);

        boolean juegoTerminado = false;
        int turno = 0;

        while (!juegoTerminado) {
            System.out.println("Turno del jugador " + (turno + 1) + " (Puntaje: " + puntuaciones[turno] + ")");

            int fila1, columna1, fila2, columna2;

            do {
                System.out.println("Elige las coordenadas de la primera carta (fila y columna): ");
                fila1 = scanner.nextInt();
                columna1 = scanner.nextInt();
            } while (!funcion.coordenadasValidas(fila1, columna1, tableroVisible));

            do {
                System.out.println("Elige las coordenadas de la segunda carta (fila y columna): ");
                fila2 = scanner.nextInt();
                columna2 = scanner.nextInt();
                if (fila1 == fila2 && columna1 == columna2) {
                    System.out.println("Las coordenadas no pueden ser iguales. Elige otra carta.");
                }
            } while (!funcion.coordenadasValidas(fila2, columna2, tableroVisible) || (fila1 == fila2 && columna1 == columna2));

            tableroVisible[fila1][columna1] = tableroLetras[fila1][columna1];
            tableroVisible[fila2][columna2] = tableroLetras[fila2][columna2];
            funcion.mostrarTablero(tableroVisible);


            if (tableroLetras[fila1][columna1] == tableroLetras[fila2][columna2]) {
                System.out.println("¡Pareja encontrada!");
                puntuaciones[turno]++;

                if (funcion.juegoTerminado(tableroVisible)) {
                    juegoTerminado = true;
                    System.out.println("¡El juego ha terminado!");
                    System.out.println("Jugador 1: " + puntuaciones[0] + " puntos");
                    System.out.println("Jugador 2: " + puntuaciones[1] + " puntos");
                    System.out.println("El ganador es el Jugador " + (puntuaciones[0] > puntuaciones[1] ? "1" : "2"));
                    break;
                }

            } else {

                System.out.println("No son iguales. Fin del turno.");
                tableroVisible[fila1][columna1] = 'X';
                tableroVisible[fila2][columna2] = 'X';


                turno = (turno + 1) % 2;
            }
        }

        scanner.close();
    }
}