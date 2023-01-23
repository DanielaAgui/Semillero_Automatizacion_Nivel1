package clase3;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;

import java.io.FileWriter;
import java.io.IOException;

//Implementar la dependendencia 'openCSV' en 'build.gradle'
public class EscribirArchivoOpenCsv_CsvWriterBuilder {
    public static void main(String[] args) throws IOException {
        //Creamos un objeto tipo 'FileWriter' con el path del archivo
        //Le ponemos 'true' como segundo parametro si queremos que no sobreescriba lo anterior
        FileWriter fileWriter = new FileWriter("src/main/resources/semillero.csv", true);

        //Creamos un objeto de tipo 'CSVWriter' para escribir en el archivo fileWriter
        //La instancia crea un error que se puede corregir con un casteo
        CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(fileWriter)
                //Se establece sin ningun caracter para los elementos citados
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        //O se puede corregir usando la clase 'ICSVWriter'
        //ICSVWriter csvWriter = new CSVWriterBuilder(fileWriter).build();

        //Se genera un array con el texto a escribir
        String[] fila = {"Nuevo", "Dato", "24"};

        //Escribimos el array
        csvWriter.writeNext(fila);
        //Cerramos el escritor de archivos
        csvWriter.close();
    }
}

