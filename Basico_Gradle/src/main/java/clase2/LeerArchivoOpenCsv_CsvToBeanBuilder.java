package clase2;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

//Implementar la dependendencia 'openCSV' en 'build.gradle'
public class LeerArchivoOpenCsv_CsvToBeanBuilder {
    public static void main(String[] args) throws FileNotFoundException {
        //Creamos un objeto de tipo 'FileReader' con el path del archivo csv
        FileReader fileReader = new FileReader("src/main/resources/semillero.csv");

        //Creamos un objeto de tipo 'CsvToBeanBuilder' donde pasamos el archivo file
        CsvToBean csvToBean = new CsvToBeanBuilder(fileReader)
                //Establecemos el tipo de objeto del archivo
                .withType(Participante.class)
                .build();

        //Creamos una lista de objetos de la clase 'Participante'
        List<Participante> listaObtenida = csvToBean.parse();

        //Iteramos sobre la lista e imprimimos
        for (Participante p : listaObtenida) {
            System.out.println(p);
        }
    }
}
