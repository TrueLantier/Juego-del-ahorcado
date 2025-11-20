// Usando BufferedReader.
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Ahorcado_básico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> palabras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/angel/Documentos" +
                "/ESCUELA/Juego del ahorcado/Palabras.txt"));)  {
            String linea;
            while ( (linea = br.readLine()) != null ) {
                palabras.add(linea);
                //System.out.print(linea + " ");
            }
        }   catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }

        Random random = new Random();
        int indiceAleatorio = random.nextInt(palabras.size());
        String palabraRandom = palabras.get(indiceAleatorio);
        String[] caracteres = new String[palabraRandom.length()]; // Todavía mejorable. Tal vez cambiar por StringBuilder
        for ( int i = 0; i < palabraRandom.length(); i++) {
            caracteres[i] = "_";
        }

        List<String> letras_usadas = new ArrayList<>();
        String palabra_formada = "";
        String ingreso;
        boolean encontrar_letra = false;
        boolean hayLetraRepetida;
        int vidas = 10;
        int contador_aciertos = 0;
        int contar_letras = 0;

        System.out.println("Bienvenido al juego del ahorcado.");
        do {
            System.out.print("\nPalabra: \t");
            for ( int i = 0; i < palabraRandom.length(); i++) {
                System.out.print( caracteres[i] );
            }

            hayLetraRepetida = false;
            contar_letras = 0;
            System.out.println("\nVidas " + vidas);
            if (!letras_usadas.isEmpty()) {
                System.out.println("Has usado: ");
                System.out.println(letras_usadas);
            }
            System.out.println("Ingrese una letra: ");
            ingreso = String.valueOf(scanner.nextLine().charAt(0)); // Ver cómo mejorar.
            ingreso = ingreso.toUpperCase().trim();

            for ( String letra_repetida: letras_usadas) {
                if (letra_repetida.equals(ingreso)) {
                    hayLetraRepetida = true;
                    break;
                }
            }

            if (hayLetraRepetida) {
                System.out.println("No repita letras.\n");
                // Tal vez agregar un contador de letras repetidas.
            }   else {
                letras_usadas.add(ingreso);
                for ( int i = 0; i < palabraRandom.length(); i++) {
                    if ( ingreso.equals(String.valueOf(palabraRandom.charAt(i))) ) {
                        caracteres[i] = ingreso;
                        contar_letras++;
                        contador_aciertos++;
                        encontrar_letra = true;
                    }   else {
                        encontrar_letra = false;
                    }
                }

                if ( contar_letras == 0 ) {
                    System.out.println("Letra incorrecta. Vidas -1");
                    vidas--;
                }
            }
        }   while ( (vidas > 0 ) && (contador_aciertos < palabraRandom.length()) );

        if ( !encontrar_letra ) {
            System.out.println("Vidas = 0 \nHas perdido.");
            System.out.println(palabraRandom);
        }   else {
            for ( int i = 0; i < palabraRandom.length(); i++) {
                palabra_formada += caracteres[i];
            }
            System.out.println(palabra_formada);
            System.out.println("Has ganado.");
        }

        scanner.close();
    }
}
