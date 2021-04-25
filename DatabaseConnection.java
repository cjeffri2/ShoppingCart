package DB;

import java.math.BigDecimal;
import java.sql.*;

public class Database {
    public static void main( String[] args )
    {
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/shoppingcart",
                    "postgres",
                    "password"
            );
            System.out.println("Opened Database Successfully!");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
        }

        // Create Table
        //createTable(connection);

        // INSERT (connection, id, type, name, price, amount, description)
        //insert(connection,"Fruit","Strawberries",3.89, 30, "16oz Container");
        //insert(connection,"Fruit", "Green Apples",1.29, 30, "1lb of Ripe Apples");
        //insert(connection,"Cereal","Kapn Krunch",10.99, 15, "Berry flavorful!");
        //insert(connection,"Cereal", "Cheerios", 9.99, 15, "Need lower cholesterol?");
        //insert(connection,"Protein", "Venison Burgers", 8.95, 20, "Pack of 3.");
        //insert(connection,"Protein", "Vension Burgers", 79.95, 2, "Pack of 30.");
        //insert(connection,"Electronics", "Wireless Charger", 9.99, 10, "Qi supported.");
        //insert(connection,"Electronics", "Power Brick", 14.99, 10, "20W MagSafe.");
     



        //SELECT
        select(connection);

        // UPDATE(connection, id, amount)
        //update(connection, );

        // DELETE (connection, id)
        //delete(connection, 14);
        
        


        // Close the connection once we are finished
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection connection)
    {
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sqlCommand =
                    "CREATE TABLE items("+
                        "ID SERIAL UNIQUE PRIMARY KEY NOT NULL, "+
                        "TYPE CHAR(15), "+
                        "NAME TEXT NOT NULL, "+
                        "PRICE DECIMAL(12,2) NOT NULL, "+
                        "AMOUNT SMALLINT,"+
                        "DESCRIPTION TEXT NOT NULL"+
                    ")";
            statement.executeUpdate(sqlCommand);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Table Created...");
    }

    public static void insert(Connection connection, String type, String name, double price, int amount, String description)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "INSERT INTO items("+
                        "TYPE, "+
                        "NAME, "+
                        "PRICE, "+
                        "AMOUNT, "+
                        "DESCRIPTION"+
                    ") ";
            sqlCommand += String.format("VALUES('%s', '%s', %.2f, %d, '%s');",type,name,price,amount,description);
            statement.executeUpdate(sqlCommand);
            statement.close();
            connection.commit();
            System.out.println("Data Inserted...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void select(Connection connection)
    {

        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sqlCommand =
                    "SELECT * FROM items;";
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");

                System.out.println(String.format("ID = %d\n TYPE = %s\n NAME = %s\n PRICE = %.2f\n AMOUNT = %d\n DESCRIPTION = %s\n",id,type,name,price,amount,description));
            }
            resultSet.close();
            statement.close();
            System.out.println("Data Selected...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void update(Connection connection, int id, int amount)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "UPDATE items amount = "+amount+"where ID = "+id+";";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            System.out.println("Data Updated...");


            select(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void delete(Connection connection, int id)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "DELETE from items where ID = "+id+";";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            System.out.println("Data Deleted...");


            select(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
