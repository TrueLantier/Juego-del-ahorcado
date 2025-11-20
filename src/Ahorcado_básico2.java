// Usando Scanner
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Ahorcado_básico2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> palabras = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("/home/angel/Documentos" +
                    "/ESCUELA/Juego del ahorcado/Palabras.txt"));
            String linea;
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                palabras.add(linea);
            }
            scanner.close();
        }   catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        System.out.println(palabras);
    }
}
