import java.sql.*;

public class StudentDAO {
	String url ="jdbc:mysql://localhost:3306/webapp?useSSL=false";
	String username ="root";
	String password="Root@123";


	private static final String INSERTQUERY = "INSERT INTO STUDENT (regno,sNAME,PASS,DEPT) VALUES (?,?,?,?);";
	// private static final String SELECTQUERY = "Select sname,pass,dept from
	// STUDENT where regno=?";

	protected Connection getConnection() {
	Connection con=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;
		
		
		

	}

	public int insertStudent(Student student) throws ClassNotFoundException {
		int count=0;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("insert into student (regno,sname,pass,dept) values (?,?,?,?);");
			st.setString(1, student.getRegno());
			st.setString(2, student.getName());
			st.setString(3, student.getPass());
			st.setString(4, student.getDept());

			count=st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Student selectStudent(String regno) throws ClassNotFoundException {
		Student student = null;
		

		try {
			Connection con = getConnection();
		
			PreparedStatement st = con.prepareStatement("Select sname,pass,dept from STUDENT where regno=?;");
			st.setString(1, regno);

	
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String name = rs.getString("sname");
				String pass = rs.getString("pass");
				String dept = rs.getString("dept");
				student = new Student(regno, name, pass, dept);

			}
		} catch (SQLException e) {
			System.out.println("catchin");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
}
