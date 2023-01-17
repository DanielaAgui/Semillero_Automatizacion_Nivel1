package clase1;

import java.io.File;
import java.io.IOException;

public class ManejoDeArchivos {
    public static void main(String[] args) {

        //Creamos un objeto de la clase 'File' enviando la ruta relativa o absoluta del archivo
        File file = new File("./src/main/resources/texto.txt");

        //Verifica si el archivo existe
        System.out.println(file.exists());

        //Crea un archivo nuevo
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Devuelve la ruta absoluta del archivo
        System.out.println(file.getAbsolutePath());
    }
}
