
		import java.sql.*;
		import java.util.Scanner;

		public class JDBCTransactionDemo {
		    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
		    static final String USER = "root";
		    static final String PASS = "yourpassword"; // change this

		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        try {
		            // 1️⃣ Load and register JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // 2️⃣ Establish connection
		            Connection con = DriverManager.getConnection(URL, USER, PASS);
		            System.out.println("✅ Connected to database!");

		            // 3️⃣ Turn off auto-commit to start manual transaction control
		            con.setAutoCommit(false);
		            System.out.println("🔁 Transaction started...");

		            try {
		                // 4️⃣ Perform multiple operations in one transaction

		                // Insert new student
		                String insertQuery = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
		                PreparedStatement psInsert = con.prepareStatement(insertQuery);
		                psInsert.setInt(1, 10);
		                psInsert.setString(2, "Asritha");
		                psInsert.setInt(3, 21);
		                psInsert.executeUpdate();
		                System.out.println("✅ Student inserted!");

		                // Update another student
		                String updateQuery = "UPDATE students SET age = age + 1 WHERE id = ?";
		                PreparedStatement psUpdate = con.prepareStatement(updateQuery);
		                psUpdate.setInt(1, 10);
		                psUpdate.executeUpdate();
		                System.out.println("✅ Student updated!");

		                // Uncomment this line to simulate an error (to test rollback)
		                // int error = 10 / 0;

		                // 5️⃣ If all succeed → commit transaction
		                con.commit();
		                System.out.println("✅ Transaction committed successfully!");

		            } catch (Exception ex) {
		                // 6️⃣ If any operation fails → rollback
		                System.out.println("❌ Error occurred: " + ex.getMessage());
		                System.out.println("↩️ Rolling back transaction...");
		                con.rollback();
		            }

		            // 7️⃣ Finally → enable auto-commit again
		            con.setAutoCommit(true);
		            con.close();
		            System.out.println("🔒 Connection closed.");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

	}

}
