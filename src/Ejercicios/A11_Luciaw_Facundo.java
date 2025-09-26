package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class A11_Luciaw_Facundo {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        File dir = new File("src/Ejercicios/Ejercicio1");

        System.out.println("Introduce la palabra a buscar: ");
        String palabra = sc.nextLine();

//      ProcessBuilder pb = new ProcessBuilder("findstr", palabra, archivo); OPCION EN WINDOWS
        ProcessBuilder pb = new ProcessBuilder("grep", palabra, "listaPalabras.txt");
        pb.directory(dir);
        pb.inheritIO();

        Process p = pb.start();

        int tiempoMax = 100;
        boolean terminado = p.waitFor(tiempoMax, TimeUnit.MILLISECONDS);

        if (terminado)
            System.out.println("El proceso terminó antes de " + tiempoMax + " milisegundos.");

        else {
            p.destroy();
            System.out.println("Proceso detenido por tardar mas de " + tiempoMax + " milisegundos.");
        }

    }

}
