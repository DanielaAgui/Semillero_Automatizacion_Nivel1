package clase1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class EscrituraDeArchivos {
    public static void main(String[] args) throws IOException {

        File file = new File("./src/main/resources/texto.txt");

        //Escribiendo con la clase 'FilesWriter'
        //Creamos un objeto tipo 'FileWriter' pasando el nombre del archivo
        //Ponemos 'true' si queremos escribir lo nuevo sin borrar lo anterior, o sino se sobreescribe
        FileWriter fileWriter = new FileWriter(file, true);

        //Creamos un objeto de tipo 'BufferedWriter' pasando el 'fileWriter'
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //Mandamos lo que queremos escribir en el archivo
        bufferedWriter.write("Escribiendo desde bufferedWriter \n");

        //Cerramos el bufferedWriter para que pueda escribir, de lo contrario no lo hace
        bufferedWriter.close();

        //Escribiendo con la clase 'Files'
        //Archivo escrito con la clase 'Files' donde pasamos la ruta del archivo y el texto a escribir
        //Con 'StandardOpenOption.APPEND' escribimos sin borrar lo anterior, o sino se sobreescribe
        Files.write(file.toPath(), "Hola \n".getBytes(), StandardOpenOption.APPEND);
    }
}
