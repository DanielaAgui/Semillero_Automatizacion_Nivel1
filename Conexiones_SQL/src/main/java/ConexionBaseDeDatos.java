import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBaseDeDatos {
    public static void main(String[] args) {
        //La clase 'Connection' genera una excepcion que podemos capturar con un 'try/catch'
        //El 'try' cierra automaticamente todas las clases que son 'Autocloseable'
        //Se crea un objeto tipo 'Connection' y nos conectamos a la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "")) {
            //Creamos un objeto tipo 'Statement' para enviar querys a la base de datos
            Statement statement = connection.createStatement();
            //Creamos un string con la query a ejecutar con la tabla
            String queryInsert = "Insert into TEST values (2, 'Camilo')";
            statement.execute(queryInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
