package methods;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class dbRead {
	
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            
            Class.forName("org.postgresql.Driver");
       
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shoppingcart",
					"postgres", "password");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from items");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("insert into items values(?, ?, ?, ?, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "TestTYPE");
            preparedStatement.setString(3, "TestNAME");
            preparedStatement.setBigDecimal(4, resultSet.getBigDecimal(4));
            preparedStatement.setInt(5, resultSet.getInt(5));
            preparedStatement.setString(6, "TestDescription");
            preparedStatement.executeUpdate();

            preparedStatement = connect.prepareStatement("SELECT id, type, name, price, amount, description");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            /*
            preparedStatement = connect
            .prepareStatement("delete from feedback.comments where myuser= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();
            */

            resultSet = statement.executeQuery("select * from items");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
       
        while (resultSet.next()) {
            // possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString(2);
            String type = resultSet.getString(2);
            String name = resultSet.getString(3);
            String price = resultSet.getString(4);
            String quantity = resultSet.getString(5);
            String description = resultSet.getString(6);
            System.out.println("Item ID: " + id);
            System.out.println("Type : " + type);
            System.out.println("Name: " + name);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Description: " + description);

        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
