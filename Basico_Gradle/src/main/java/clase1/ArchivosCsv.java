package clase1;

import clase1.models.Participante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArchivosCsv {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/resources/semillero.csv");

        //Creamos un objeto de la clase 'FileReader' donde pasamos el nombre del archivo a leer
        FileReader fileReader = new FileReader(file);

        //Creamos un objeto de la clase 'BufferedReader' pasando el fileReader creado
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Creamos un objeto tipo 'String'
        //Con 'bufferedReader.readLine()' se salta la primera linea del archivo
        String linea = bufferedReader.readLine();

        //Mientras la linea siguiente sea diferente a 'null'
        while ((linea = bufferedReader.readLine()) != null) {
            //Creamos una matriz con los textos del archivo separando las palabras por las comas
            String[] lineasTextos = linea.split(",");
            //Si las lineas tienen una longitud
            if (lineasTextos.length > 1) {
                //Podemos crear un objeto de tipo 'Participante' pasando por parametro las columnas
                //Los parametros son segun el constructor de la clase
                Participante participante = new Participante(lineasTextos[0], lineasTextos[1], lineasTextos[2]);
                //Convertimos los objetos creados a String e imprimimos
                System.out.println(participante.toString());

                //O podemos imprimir cada linea del archivo como una linea nueva
                //System.out.println("Nombre: " + lineasTextos[0]);
                //System.out.println("Fecha: " + lineasTextos[1]);
                //System.out.println("Area: " + lineasTextos[2]);
            }
        }
    }
}
