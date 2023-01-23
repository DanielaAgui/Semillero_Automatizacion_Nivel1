package clase3;

import clase1.models.Participante;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.ColumnPositionMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;

//Implementar la dependendencia 'openCSV' en 'build.gradle'
public class EscribirArchivoOpenCsv_StatefulBeanToCsvBuilder {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        //Creamos un objeto tipo 'FileWriter' con el path del archivo
        FileWriter fileWriter = new FileWriter("./src/main/resources/semillero.csv", true);

        //Instanciamos la clase 'Participante' con un nuevo dato
        Participante participante = new Participante("Juan", "17/01/2023", "PCA");

        //Clase para ordenar las columnas del archivo
        //Creamos un objeto de la clase y le pasamos la clase a usar
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategyBuilder<Participante>().build();
        //Establecemos el tipo de la clase usada
        strategy.setType(Participante.class);
        //Establecemos el orden de las columnas segun lo deseado
        strategy.setColumnMapping("nombre", "fechaAsistencia", "area");

        //Creamos un objeto de la clase 'StatefulBeanToCsvBuilder'
        StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(fileWriter)
                //Establecemos la estrategia de orden
                .withMappingStrategy(strategy)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        //Escribimos el texto nuevo
        statefulBeanToCsv.write(participante);
        //Cerramos el escritor
        fileWriter.close();
    }
}

