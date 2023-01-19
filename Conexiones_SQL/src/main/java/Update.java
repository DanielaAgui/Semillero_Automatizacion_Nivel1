import java.sql.*;

public class Update {
    public static void main(String[] args) {

        //Usamos el metodo 'updateFilas'
        updateFila(2, "Johan");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from test");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Creamos un metodo para actualizar los elementos de la fila
    public static void updateFila(int id, String name) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement("update test set Name = ? where ID = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            //Usamos 'executeUpdate' que nos devuelve un int con las filas afectadas
            int rows = preparedStatement.executeUpdate();
            //Imprimimos las filas que se afectaron en la actualizacion
            System.out.println("Filas afectadas: " + rows);
        } catch (SQLException e) {

        }
    }
}
