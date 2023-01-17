package clase1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class LecturaDeArchivos {
    public static void main(String[] args) {

        //Creamos un objeto de la clase 'File' enviando la ruta relativa o absoluta del archivo
        File file = new File("./src/main/resources/texto.txt");

        //Leyendo con la clase 'FileReader'
        try {
            //Creamos un objeto de la clase 'FileReader' al que le pasamos el nombre del archivo a leer
            FileReader fileReader = new FileReader(file);
            //Creamos un objeto de la clase 'BufferedReader' al que le pasamos el fileReader creado
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Creamos un objeto de tipo 'String'
            String linea;
            //Mientras la linea leida por el bufferedReader sea diferente a null
            while ((linea = bufferedReader.readLine()) != null) {
                //Se imprime
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Leyendo con la clase 'Files'
        try {
            //Iteramos sobre cada elemento del archivo leido con la clase 'Files' a la cual le pasamos el archivo obteniendo la ruta
            //Con 'StandardCharsets" o "Charset.defaultCharset()" podemos leer los caracteres especiales
            for (String linea : Files.readAllLines(file.toPath(), StandardCharsets.ISO_8859_1)) {
                //Imprimimos cada linea
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
