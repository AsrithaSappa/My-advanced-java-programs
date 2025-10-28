package Programs;


		import java.sql.*;
		import java.util.Scanner;

		public class StudentCRUD {
		    // Database credentials
		    static final String URL = "jdbc:mysql://localhost:3306/student";
		    static final String USER = "root"; // change as needed
		    static final String PASS = "root"; // change as needed

		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        try {
		            // 1️⃣ Load and register driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // 2️⃣ Establish connection
		            Connection con = DriverManager.getConnection(URL, USER, PASS);

		            while (true) {
		                System.out.println("\n===== STUDENT CRUD APPLICATION =====");
		                System.out.println("1. Insert Student");
		                System.out.println("2. View All Students");
		                System.out.println("3. Update Student");
		                System.out.println("4. Delete Student");
		                System.out.println("5. Exit");
		                System.out.print("Enter your choice: ");
		                int choice = sc.nextInt();

		                switch (choice) {
		                    case 1:
		                        insertStudent(con, sc);
		                        break;
		                    case 2:
		                        viewStudents(con);
		                        break;
		                    case 3:
		                        updateStudent(con, sc);
		                        break;
		                    case 4:
		                        deleteStudent(con, sc);
		                        break;
		                    case 5:
		                        con.close();
		                        System.out.println("✅ Application closed. Goodbye!");
		                        System.exit(0);
		                        break;
		                    default:
		                        System.out.println("❌ Invalid choice! Try again.");
		                }
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    // 3️⃣ Create (Insert)
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
		        System.out.println(rows + " student added successfully!");
		    }

		    // 4️⃣ Read (View)
		    public static void viewStudents(Connection con) throws SQLException {
		        String query = "SELECT * FROM students";
		        Statement stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);

		        System.out.println("\nID\tNAME\tAGE");
		        System.out.println("------------------------");
		        while (rs.next()) {
		            System.out.println(rs.getInt("id") + "\t" +
		                               rs.getString("name") + "\t" +
		                               rs.getInt("age"));
		        }
		    }

		    // 5️⃣ Update
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
		        System.out.println(rows + " student updated successfully!");
		    }

		    // 6️⃣ Delete
		    public static void deleteStudent(Connection con, Scanner sc) throws SQLException {
		        System.out.print("Enter ID to delete: ");
		        int id = sc.nextInt();

		        String query = "DELETE FROM students WHERE id = ?";
		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setInt(1, id);

		        int rows = ps.executeUpdate();
		        System.out.println(rows + " student deleted successfully!");
		    }
		

	}


