import java.sql.*;

public class DeleteFrom {
    public static void main(String[] args) {

        deleteFila(1);
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

    //Creamos un metodo para eliminar elementos de la base de datos
    public static void deleteFila(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement("delete from test where ID = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
}
