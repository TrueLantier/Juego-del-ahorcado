// Métodos propios. Luego usaré StringBuild y sus métodos.
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Ahorcado_básico {

    /*
    private List<String> cargarPalabrasDesdeArchivo() {
        List<String> palabras = new ArrayList<>();
        try {
            Path archivo = Paths.get("Palabras.txt");
            palabras = Files.readAllLines(archivo);

            //Limpieza.

            return
        }

    }
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido al juego del ahorcado.");
        String[] lista = {"ANGEL"};


        String palabra = lista[0];
        String[] caracteres = new String[palabra.length()];
        for ( int i = 0; i < palabra.length(); i++) {
            caracteres[i] = "_";
        }
        String palabra_formada = "";
        String ingreso;
        boolean encontrar_letra = false;
        int vidas = 10;
        int contador_aciertos = 0;

        do {
            for ( int i = 0; i < palabra.length(); i++) {
                System.out.print( caracteres[i] );
            }

            System.out.println("\nVidas " + vidas);
            System.out.println("Ingrese una letra: ");
            ingreso = String.valueOf(scanner.nextLine().charAt(0)); // Ver cómo mejorar.
            ingreso = ingreso.toUpperCase().trim();

            for ( int i = 0; i < palabra.length(); i++) {
                if ( ingreso.equals(String.valueOf(palabra.charAt(i))) ) {
                    caracteres[i] = ingreso;
                    encontrar_letra = true;
                    contador_aciertos++;
                    break;
                }   else {
                    encontrar_letra = false;
                }
            }

            if ( !encontrar_letra ) {
                System.out.println("Letra incorrecta. Vidas -1");
                vidas--;
            }

        }   while ( (vidas > 0 ) && (contador_aciertos < palabra.length()) );

        if ( !encontrar_letra ) {
            System.out.println("Vidas = 0 \nHas perdido.");
        }   else {
            System.out.println("Has ganado.");
            for ( int i = 0; i < palabra.length(); i++) {
                palabra_formada += caracteres[i];
            }
            System.out.println(palabra_formada);
        }

        scanner.close();
    }
}
