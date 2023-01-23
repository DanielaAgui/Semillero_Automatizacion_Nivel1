package clase5;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.List;

public class BaseDeDatos {
    public static void main(String[] args) throws FileNotFoundException {

        insertarFila();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/ejercicioNuevo", "sa", "")) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarFila() throws FileNotFoundException {

        FileReader fileReader = new FileReader("src/main/resources/empleados.csv");

        CsvToBean csvToBean = new CsvToBeanBuilder(fileReader)
                .withType(Empleado.class)
                .build();

        List<Empleado> listaObtenida = csvToBean.parse();

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/ejercicioNuevo", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement("Insert into ejercicio_final values (?, ?, ?, ?, ?)")) {

            for (int i = 0; i < listaObtenida.size(); i++) {
                preparedStatement.setInt(1, listaObtenida.get(i).getId());
                preparedStatement.setString(2, listaObtenida.get(i).getNombre());
                preparedStatement.setInt(3, listaObtenida.get(i).getEdad());
                preparedStatement.setString(4, listaObtenida.get(i).getPerfil());
                preparedStatement.setInt(5, listaObtenida.get(i).getSalario());
            }
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
