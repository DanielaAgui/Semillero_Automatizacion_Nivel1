package clase2;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//Implementar la dependendencia 'openCSV' en 'build.gradle'
public class LeerArchivoOpenCsv_CsvReaderBuilder {
    public static void main(String[] args) throws IOException, CsvException {
        //Creamos un objeto de tipo 'FileReader' con el path del archivo csv
        FileReader fileReader = new FileReader("src/main/resources/semillero.csv");

        //Creamos un objeto 'CSVReader' para leer el arhivo file
        CSVReader csvReader = new CSVReaderBuilder(fileReader).build();

        //Creamos una lista de vectores donde pasamos y leemos el archivo csv
        List<String[]> datos = csvReader.readAll();

        //Iteramos sobre la lista
        for (String[] dato : datos) {
            //Desde la posicion cero hasta la longitud de la lista
            for (int i = 0; i < dato.length; i++) {
                //Imprimimos el archivo como lista
                System.out.println(dato[i]);
            }
        }
    }
}
