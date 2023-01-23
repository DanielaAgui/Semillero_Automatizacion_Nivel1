package clase6;

import clase5.Empleado;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.List;

public class Ejercicio {
    public static void main(String[] args) throws FileNotFoundException {

        crearTabla();
        List<Empleado> empleados = obtenerListaEmpleados();

        for (Empleado emp : empleados) {
            insertarEmpleado(emp);
        }
        imprimirDatosTabla();
    }

    //Metodo para obtener una lista con los elementos
    public static List<Empleado> obtenerListaEmpleados() throws FileNotFoundException {
        //leemos el archivo csv
        CsvToBean csvToBean = new CsvToBeanBuilder<Empleado>(new FileReader("./src/main/resources/empleadosEjercicio"))
                .withType(Empleado.class)
                .build();

        //Convertimos a lista y la devolvemos
        List<Empleado> empleados = csvToBean.parse();
        return empleados;
    }

    //Metodo para insertar elementos en la base de datos
    public static void insertarEmpleado(Empleado empleado) {
        //Nos conectamos a la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/ejercicioNuevo", "sa", "");
             //Creamos la query para insertar elementos
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLEADOS VALUES (?, ?, ?, ?, ?)")) {

            //Obtenemos los elementos a insertar
            preparedStatement.setInt(1, empleado.getId());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setInt(3, empleado.getEdad());
            preparedStatement.setString(4, empleado.getPerfil());
            preparedStatement.setInt(5, empleado.getSalario());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para crear una tabla en la base de datos
    public static void crearTabla() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/ejercicioNuevo", "sa", "");
             Statement statement = connection.createStatement()) {

            //Creamos la query para crear una tabla
            statement.execute("CREATE TABLE IF NOT EXISTS EMPLEADOS " +
                    "(ID INT NOT NULL, " +
                    "Nombre VARCHAR(50), " +
                    "Edad INT," +
                    "Perfil VARCHAR(50), " +
                    "Salario INT )");
            statement.execute("DELETE FROM EMPLEADO");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para imprimir los datos de la tabla
    public static void imprimirDatosTabla() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/ejercicioNuevo", "sa", "");
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLEADO");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
