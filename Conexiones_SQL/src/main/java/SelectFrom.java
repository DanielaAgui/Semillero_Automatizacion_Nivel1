import java.sql.*;

//Un 'ResultSet' se utiliza para devolver resultados de una consulta en base de datos
public class SelectFrom {
    public static void main(String[] args) {

        //Podemos consultar todos los elementos de la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "")) {
            //Creamos un objeto para enviar la query
            Statement statement = connection.createStatement();
            //Creamos un objeto de tipo 'ResultSet' y ejecutamos la query
            ResultSet resultSet = statement.executeQuery("select * from test");

            //Se le puede poner alias a las columnas
            //ResultSet resultSet = statement.executeQuery("select ID as Identification* from test");

            //Verificamos si hay datos de resultados, devuelve un booleano
            while (resultSet.next()) {
                //Imprime de la consulta un String con los datos de la columna 'ID'
                System.out.println(resultSet.getString("Name"));

                //Se puede consultar los datos con el alias puesto o con el indice de la columna
                //System.out.println(resultSet.getString("Identification"));
                //System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Podemos consultar unos elementos especificos de la base de datos
        String busqueda = "Name";
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test", "sa", "")) {
            Statement statement = connection.createStatement();
            //Concatenar variables en el query usando 'Statement' es mala practica, es mejor usar 'PreparedStatements'
            ResultSet resultSet = statement.executeQuery("select * from test where Name='" + busqueda + "'");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
