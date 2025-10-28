
		import java.sql.*;
		import java.util.Scanner;

		public class JDBCPreparedCallableDemo {
		    // Database credentials
		    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
		    static final String USER = "root"; // change as needed
		    static final String PASS = "yourpassword"; // change as needed

		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        try {
		            // 1️⃣ Load the MySQL JDBC Driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // 2️⃣ Create a Connection
		            Connection con = DriverManager.getConnection(URL, USER, PASS);
		            System.out.println("✅ Database connected!");

		            while (true) {
		                System.out.println("\n===== STUDENT CRUD MENU =====");
		                System.out.println("1. Insert Student (PreparedStatement)");
		                System.out.println("2. Update Student (PreparedStatement)");
		                System.out.println("3. Delete Student (PreparedStatement)");
		                System.out.println("4. View Students (CallableStatement)");
		                System.out.println("5. Exit");
		                System.out.print("Enter your choice: ");
		                int ch = sc.nextInt();

		                switch (ch) {
		                    case 1 -> insertStudent(con, sc);
		                    case 2 -> updateStudent(con, sc);
		                    case 3 -> deleteStudent(con, sc);
		                    case 4 -> viewStudents(con);
		                    case 5 -> {
		                        con.close();
		                        System.out.println("👋 Application closed.");
		                        System.exit(0);
		                    }
		                    default -> System.out.println("❌ Invalid choice!");
		                }
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    // 3️⃣ INSERT (PreparedStatement)
		    public static void insertStudent(Connection con, Scanner sc) throws SQLException {
		        System.out.print("Enter ID: ");
		        int id = sc.nextInt();
		        System.out.print("Enter Name: ");
		        String name = sc.next();
		        System.out.print("Enter Age: ");
		        int age = sc.nextInt();

		        String query = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setInt(1, id);
		        ps.setString(2, name);
		        ps.setInt(3, age);

		        int rows = ps.executeUpdate();
		        System.out.println("✅ " + rows + " record(s) inserted.");
		    }

		    // 4️⃣ UPDATE (PreparedStatement)
		    public static void updateStudent(Connection con, Scanner sc) throws SQLException {
		        System.out.print("Enter ID to update: ");
		        int id = sc.nextInt();
		        System.out.print("Enter new Age: ");
		        int newAge = sc.nextInt();

		        String query = "UPDATE students SET age = ? WHERE id = ?";
		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setInt(1, newAge);
		        ps.setInt(2, id);

		        int rows = ps.executeUpdate();
		        System.out.println("✅ " + rows + " record(s) updated.");
		    }

		    // 5️⃣ DELETE (PreparedStatement)
		    public static void deleteStudent(Connection con, Scanner sc) throws SQLException {
		        System.out.print("Enter ID to delete: ");
		        int id = sc.nextInt();

		        String query = "DELETE FROM students WHERE id = ?";
		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setInt(1, id);

		        int rows = ps.executeUpdate();
		        System.out.println("✅ " + rows + " record(s) deleted.");
		    }

		    // 6️⃣ READ (CallableStatement) — calls stored procedure
		    public static void viewStudents(Connection con) throws SQLException {
		        CallableStatement cs = con.prepareCall("{CALL getAllStudents()}");
		        ResultSet rs = cs.executeQuery();

		        System.out.println("\n📋 STUDENT RECORDS:");
		        System.out.println("ID\tNAME\tAGE");
		        System.out.println("---------------------");
		        while (rs.next()) {
		            System.out.println(rs.getInt("id") + "\t" +
		                               rs.getString("name") + "\t" +
		                               rs.getInt("age"));
		        }
		    }
		

	}


