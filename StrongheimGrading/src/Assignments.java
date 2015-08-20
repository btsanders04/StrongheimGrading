

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assignments
 */
@WebServlet("/Assignments")
public class Assignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignments() {
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
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String sql="select * from gradebook where ";
		String assignment="";
		if(id!=null && type!=null){
		
		    if(type.equals("")){
				sql+="studentid='"+id+"'";
				System.out.println("No Type");
			}
			else if(id.equals("")){
				sql+="assignType='"+type+"'";
				System.out.println("No id");
			}
			else{
				sql+="studentid='"+id+"' and assignType='"+type+"'";
				System.out.println("Both");
				}
		}
		
		if(request.getParameter("submit")!=null){
		try {
			ResultSet result = DBQuery.getFromDB(sql);
			assignment+= "<div class=\"container\"> <h2>Assignments</h2> "+           
			  "<table class=\"table table-bordered\"><thead><tr><th>Assignment</th><th>Type</th>"+
			  "<th>Date</th><th>Grade</th></tr></thead><tbody>";
			while(result.next()){
				assignment+="<tr><td>"+result.getString("assignment")+"</td><td>"
						+ result.getString("assigntype")+"</td><td>"+result.getString("submitdate")+
						"</td><td>"+result.getString("grade")+"</td></tr>";
			}
			assignment+="</tbody></table></div>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		request.setAttribute("assignment", assignment);
		getServletContext().getRequestDispatcher("/assignment.jsp").forward(
				request, response);
	}

}
