
	
		import java.sql.*;

		public class JDBCOperations {
		    public static void main(String[] args) {
		        // Database credentials
		        String url = "jdbc:mysql://localhost:3306/studentdb";
		        String user = "root";       // change if needed
		        String password = "yourpassword";  // change if needed

		        try {
		            // 1️⃣ Load JDBC Driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // 2️⃣ Establish Connection
		            Connection con = DriverManager.getConnection(url, user, password);
		            System.out.println("✅ Database connected successfully!");

		            // 3️⃣ INSERT Operation
		            String insertQuery = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
		            PreparedStatement insertStmt = con.prepareStatement(insertQuery);
		            insertStmt.setInt(1, 1);
		            insertStmt.setString(2, "Asritha");
		            insertStmt.setInt(3, 20);
		            int insertCount = insertStmt.executeUpdate();
		            System.out.println(insertCount + " record inserted.");

		            // 4️⃣ UPDATE Operation
		            String updateQuery = "UPDATE students SET age = ? WHERE id = ?";
		            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		            updateStmt.setInt(1, 21);
		            updateStmt.setInt(2, 1);
		            int updateCount = updateStmt.executeUpdate();
		            System.out.println(updateCount + " record updated.");

		            // 5️⃣ DELETE Operation
		            String deleteQuery = "DELETE FROM students WHERE id = ?";
		            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
		            deleteStmt.setInt(1, 1);
		            int deleteCount = deleteStmt.executeUpdate();
		            System.out.println(deleteCount + " record deleted.");

		            // 6️⃣ Close Connection
		            con.close();
		            System.out.println("🔒 Connection closed.");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		

	}


