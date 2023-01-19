import java.sql.*;

public class InsertInto {
    public static void main(String[] args) {

        //Usamos el metodo de insertarFila
        insertarFila(4, "Laura");
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

    //Creamos un metodo para insertar elemenos en la fila
    //Pasamos los parametros segun base de datos
    public static void insertarFila(int id, String name) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "");
             //Creamos un objeto tipo 'PreparedStatement' dentro del 'try' para que se cierre automaticamente
             //Insertamos la query de 'insert' con ? que son los parametros a usar (en ese orden respectivamente)
             PreparedStatement preparedStatement = connection.prepareStatement("Insert into test values (?, ?)")) {
            //Establecemos el parametro para las columnas de la base de datos
            //Tener en cuenta que los indices comienzan desde 1
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            //Ejecutamos la query
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
}
