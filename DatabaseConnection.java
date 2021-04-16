import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rome",
					"postgres", "---------");
			System.out.println("Opened database successfully");
		} catch(Exception e){ 
			e.printStackTrace();
			System.err.println(e.getClass().getName()+":" + e.getMessage());
			System.exit(0);
		}
		
		/*
		//Create table
		
		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE thegreatmen" + 
					"(POSITION CHAR(3) NOT NULL, " +
					" NAME TEXT NOT NULL, " + 
					" BIRTHERA CHAR(2) NOT NULL, " +
					" BIRTH INT NOT NULL, "+
					" DEATHERA CHAR(2) NOT NULL, "+
					" DEATH INT NOT NULL, " +
					" KNOWNFOR TEXT)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
				System.err.println(e.getClass().getName()+ ": " + e.getMessage());
				System.exit(0);
		}
		System.out.println("Table created...");
		
		
		*/
		//INSERT
		
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO THEGREATMEN(POSITION, NAME, BIRTHERA, BIRTH, DEATHERA, DEATH, KNOWNFOR) "
					+ "VALUES(1,'Julius Caesar', 'AD', 100, 'AD', 44, 'Dictator');";
			stmt.executeUpdate(sql);
		/*
			sql = "INSERT INTO THEGREATMEN(NAME, BIRTHERA, BIRTH, DEATHERA, DEATH, KNOWNFOR) "
					+ "VALUES(1, 'Paul', 32, 'California', 20000.00);";
			stmt.executeUpdate(sql);
			
			
			sql = "INSERT INTO THEGREATMEN(NAME, BIRTHERA, BIRTH, DEATHERA, DEATH, KNOWNFOR) "
					+ "VALUES(1, 'Paul', 32, 'California', 20000.00);";
			stmt.executeUpdate(sql);
			
			
			sql = "INSERT INTO THEGREATMEN(NAME, BIRTHERA, BIRTH, DEATHERA, DEATH, KNOWNFOR) "
					+ "VALUES(1, 'Paul', 32, 'California', 20000.00);";
			stmt.executeUpdate(sql);
			
			*/
			stmt.close();
			c.commit();
			c.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+":" + e.getMessage());
			System.exit(0);
		}
		
		
		/*
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
}
