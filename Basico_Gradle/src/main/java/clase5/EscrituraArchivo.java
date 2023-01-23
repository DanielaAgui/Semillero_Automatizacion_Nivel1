package clase5;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.ColumnPositionMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraArchivo {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        FileWriter fileWriter = new FileWriter("./src/main/resources/empleados.csv", true);

        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategyBuilder<Empleado>().build();
        strategy.setType(Empleado.class);
        strategy.setColumnMapping("id", "nombre", "edad", "perfil", "salario");

        StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder<>(fileWriter)
                .withMappingStrategy(strategy)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        Empleado empleado = new Empleado(3, "Cristian", 21, "QA", 1500000);

        statefulBeanToCsv.write(empleado);
        fileWriter.close();
    }
}
