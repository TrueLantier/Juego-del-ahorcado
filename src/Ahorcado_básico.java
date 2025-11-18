// Métodos propios. Luego usaré StringBuild y sus métodos.
import java.util.Scanner;

public class Ahorcado_básico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego del ahorcado.");
        String[] lista = {"angel"};

        String palabra = lista[0];
        char[] caracteres = new char[palabra.length()];
        for ( int i = 0; i < palabra.length(); i++) {
            caracteres[i] = '_';
        }
        String palabra_formada = "";
        char ingreso;
        boolean util = true;
        boolean encontrar_letra = false;
        int errores_max = palabra.length();
        int contador_errores = 0;
        int contador_aciertos = 0;

        do {
            for ( int i = 0; i < palabra.length(); i++) {
                System.out.print( caracteres[i] );
            }

            System.out.println("\nIngrese una letra: ");
            ingreso = scanner.nextLine().charAt(0);

            for ( int i = 0; i < palabra.length(); i++) {
                if ( ingreso == palabra.charAt(i) ) {
                    caracteres[i] = ingreso;
                    encontrar_letra = true;
                    contador_aciertos++;
                    break;
                }   else {
                    encontrar_letra = false;
                }
            }

            if ( !encontrar_letra ) {
                System.out.println("Letra incorrecta.");
                contador_errores++;
            }

        }   while ( (contador_errores < palabra.length()) || (contador_aciertos < palabra.length()) );

        for ( int i = 0; i < palabra.length(); i++) {
            palabra_formada += caracteres[i];
        }
        System.out.println(palabra_formada);

        scanner.close();
    }
}
