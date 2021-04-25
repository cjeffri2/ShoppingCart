import java.sql.*;

public class DB {
	//variables
	static Connection c = null;
	static Statement stmt = null;
	static ResultSet resultSet = null;
	static PreparedStatement preparedStatement = null;
	
	//establishes connection with database - shoppingcart with username postgres and password password
	public static void main(String[] args) {
		
	
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shoppingcart",
					"postgres", "password");
			System.out.println("Opened database successfully.");
		} catch(Exception e){ 
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		
		
	
	
	//create table method
	/*
		try {
			stmt = c.createStatement();
			
			//ITEMS
			String items = ("CREATE TABLE items(ID SERIAL UNIQUE PRIMARY KEY NOT NULL, TYPE CHAR(15), NAME TEXT NOT NULL, PRICE DECIMAL(12,2) NOT NULL, AMOUNT SMALLINT, DESCRIPTION TEXT NOT NULL);");
			stmt.executeUpdate(items);
			
			//USERS
			String users = ("CREATE TABLE users(ID SERIAL UNIQUE PRIMARY KEY NOT NULL, FIRSTNAME TEXT NOT NULL, LASTNAME TEXT NOT NULL, POSITION TEXT NOT NULL, ADDRESS CHAR(20), USERNAME CHAR(15) NOTNULL, PASSWORD CHAR(50) NOT NULL, SALARY REAL);");
			stmt.executeUpdate(users);
		
			stmt.close();
			c.close();
			System.out.println("Created table succesfully.");
		}catch(Exception e) {
			e.printStackTrace();
				System.err.println(e.getClass().getName()+ ": " + e.getMessage());
				System.exit(0);
		}
		*/
		
		//INSERT
		
	/*
		  try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO items (type, name, price, amount) VALUES ('food', 'Truffle', '10.00', 100)";
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			c.commit();
			c.close();
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+":" + e.getMessage());
			System.exit(0);
		}
		
		
		
		//SELECT
		
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company;");
			while(rs.next()) {
				String name= rs.getString("NAME");
				String birthEra = rs.getString("BIRTHERA");
				int birth = rs.getInt("BIRTH");
				String deathEra = rs.getString("DEATHERA");
				int death = rs.getInt("DEATH");
				String knownFor = rs.getString("KNOWNFOR");
				
				System.out.println("NAME = " + name);
				System.out.println("BIRTHERA = " + birthEra);
				System.out.println("BIRTH = " + birth);
				System.out.println("DEATHERA = " + deathEra);
				System.out.println("DEATH = " + death);
				System.out.println("KNOWNFOR = " + knownFor);

			}
			rs.close();
			stmt.close();
			c.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+":" + e.getMessage());
			System.exit(0);
		}
		*/
	}
	
	
	private static void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
	


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }
    
    


}

