import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Funciones {
    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 'X';
            }
        }
    }


    public static void mostrarTablero(char[][] tablero) {
        System.out.println("  0 1 2 3");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void rellenarConPares(char[][] tableroLetras) {

        List<Character> letras = new ArrayList<>();
        for (char letra = 'A'; letra <= 'H'; letra++) {
            letras.add(letra);
            letras.add(letra);
        }

        // Mezclar las letras para que queden en posiciones aleatorias
        Collections.shuffle(letras);


        int index = 0;
        for (int i = 0; i < tableroLetras.length; i++) {
            for (int j = 0; j < tableroLetras[i].length; j++) {
                if (index < letras.size()) {
                    tableroLetras[i][j] = letras.get(index);
                    index++;
                } else {
                    tableroLetras[i][j] = ' ';
                }
            }
        }
    }


    public static boolean juegoTerminado(char[][] tableroVisible) {
        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible[i].length; j++) {
                if (tableroVisible[i][j] == 'X') {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean coordenadasValidas(int fila, int columna, char[][] tableroVisible) {
        if (fila < 0 || fila >= tableroVisible.length || columna < 0 || columna >= tableroVisible[0].length) {
            System.out.println("Las coordenadas están fuera del rango. Elige de nuevo.");
            return false;
        }
        if (tableroVisible[fila][columna] != 'X') {
            System.out.println("Esta carta ya está descubierta. Elige de nuevo.");
            return false;
        }
        return true;
    }
}

