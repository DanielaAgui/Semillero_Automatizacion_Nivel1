import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBaseDeDatos {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "");
        Statement statement = connection.createStatement();
        String queryInsert = "Insert into TEST values (1, 'Name')";
        statement.execute(queryInsert);
        connection.close();
    }
}
