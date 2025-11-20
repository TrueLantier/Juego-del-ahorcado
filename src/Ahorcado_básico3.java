//Usando Files.readAllLines
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Ahorcado_básico3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> palabras = new ArrayList<>();

        try {
            palabras = Files.readAllLines(Paths.get("/home/angel/Documentos" +
                    "/ESCUELA/Juego del ahorcado/Palabras.txt"));

        }   catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}
