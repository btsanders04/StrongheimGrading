

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Record
 */
@WebServlet("/Record")
public class Record extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Record() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBQuery.openConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
		getServletContext().getRequestDispatcher("/grading.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("submit")!=null){
		String studentId = request.getParameter("id");
		String assignment = request.getParameter("assignment");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String grade = request.getParameter("grade");
		String sql = "insert into gradebook(studentId,assignment,assignType,submitDate,grade)"
				+ "values('"+studentId+"','"+assignment+"','"+type+"','"+
				date+"',"+grade+")";
		try {
			DBQuery.updateDB(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		getServletContext().getRequestDispatcher("/grading.jsp").forward(
				request, response);
	}

}
