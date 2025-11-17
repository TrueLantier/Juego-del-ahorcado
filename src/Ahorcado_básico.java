import java.util.Scanner;
// Métodos míos. Luego usaré métodos hechos.

public class Ahorcado_básico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego del ahorcado.");
        String[] lista = {"angel"};

        String palabra = lista[0];
        char ingreso;
        boolean util = true;
        boolean encontrar_letra = false;
        int errores_max = palabra.length();
        int contador_errores = 0;

        do {
            for ( int i = 0; i < palabra.length(); i++) {
                System.out.print("_");
            }

            System.out.println("Ingrese una letra: ");
            ingreso = scanner.nextLine().charAt(0);

            for ( int i = 0; i < palabra.length(); i++) {
                if ( ingreso == palabra.charAt(i) ) {
                    encontrar_letra = true;
                    break;
                }
            }
            if (encontrar_letra) {

            }

            /*
            util = false;
                    contador_errores++;
             */

        }   while ( contador_errores < errores_max );


        //scanner.close();
    }
}
