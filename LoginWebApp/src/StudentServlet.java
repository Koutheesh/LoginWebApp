import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        this.studentDAO =new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO studentDAO =new StudentDAO();
		String regno =request.getParameter("regno");
		String pass =request.getParameter("pass");
		String sname=request.getParameter("name");
		String pass2 =request.getParameter("pass2");
		String dept =request.getParameter("dept");
		
		String submit =request.getParameter("submit");
		Student student;

		
		try {
			student = studentDAO.selectStudent(regno);
			
		
		if(submit.equals("login")){
					if(student!=null && pass.equals(student.getPass())){
			request.setAttribute("name", student.getName());
			request.setAttribute("regno", student.getRegno());
			request.setAttribute("dept", student.getDept());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
					else
						request.setAttribute("alertMsg", "Invalid login credentials");
						RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
						rd.include(request, response);
		}
		else if(submit.equals("register")){
			Student student2 =new Student(regno,sname,pass2,dept);
			
			int count=studentDAO.insertStudent(student2);
			if(count==0)
			request.setAttribute("alertMsg", "Not Registered- Reg No already exists ");
			if(count==1)
			request.setAttribute("alertMsg", "Successfully Registered");
			RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");  
			rd.include(request, response);
			
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
	}

}
