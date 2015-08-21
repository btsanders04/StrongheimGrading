import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Grades
 */
@WebServlet("/Grades")
public class Grades extends HttpServlet {
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

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Grades() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String avg = request.getParameter("avg");
		String high = request.getParameter("high");
		String low = request.getParameter("low");
		String weighted = request.getParameter("weighted");
		String classType = request.getParameter("class");
		if (request.getParameter("submit") != null) {
			try {
				String findAverage = "";
				String findHigh = "";
				String findLow = "";
				String findWeight ="";
				if (avg != null)
					findAverage = sqlGen("avg", type, id,classType);
				if (high != null)
					findHigh = sqlGen("high", type, id,classType);
				if (low != null)
					findLow = sqlGen("low", type, id,classType);
				if (weighted != null)
					findWeight = sqlGen("gpa", type, id,classType);
				System.out.println(findAverage);
				System.out.println(findHigh);
				System.out.println(findLow);
				System.out.println(findWeight);
				String average = "";
				String top = "";
				String bottom = "";
				String weightGPA = "";

				if (!findAverage.equals(""))
					average = printResult(DBQuery.getFromDB(findAverage),
							"Average");
			//	System.out.println(average);

				if (!findHigh.equals(""))
					top = printResult(DBQuery.getFromDB(findHigh), "High");
			//	System.out.println(top);

				if (!findLow.equals(""))
					bottom = printResult(DBQuery.getFromDB(findLow), "Low");
			//	System.out.println(bottom);
				
				if (!findWeight.equals(""))
					weightGPA = printResult(DBQuery.getFromDB(findWeight), "Weighted Grade");
			//	System.out.println(weightGPA);

				request.setAttribute("average", average);
				request.setAttribute("high", top);
				request.setAttribute("low", bottom);
				request.setAttribute("gpa", weightGPA);
				request.setAttribute("classes", Assignments.getClasses());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		getServletContext().getRequestDispatcher("/average.jsp").forward(
				request, response);
	}

	private String printResult(ResultSet result, String type) {

		String grade = "<div class=\"container\"> "
				+ "<table class=\"table table-bordered\"><thead><tr><th>"
				+ type + "</th>" + "</thead><tbody>";
		try {
			if(result.next()) {
				grade += "<tr><td>" + result.getString(1) + "</td>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grade += "</tbody></table></div>";

		return grade;
	}

	private String sqlGen(String grade, String type, String id, String classType) {
		String sql = "class='"+classType+"' and ";
		boolean and=false;
		if(!id.equals("")){
			sql+="studentid='"+id+"'";
			and=true;
			System.out.println("No Type");
		}
	    if(!type.equals("")){
	    	if(and){
	    		sql+=" and ";
	    	}
			sql+="assignType='"+type+"'";
			System.out.println("No id");
		}
		
		//else if(class)
		switch (grade) {
		case ("avg"):
			return "select avg(grade) as average from gradebook where "+sql;
		case ("high"):
			return "select * from (select  grade from gradebook where " + sql
					+ " order by grade desc) where rownum=1";
		case ("low"):
			return "select * from (select  grade from gradebook where " + sql 
					+ " order by grade asc) where rownum=1";
		case("gpa"):
			return "select round(((sum(grade*weight))/sum(weight)),1) as average "+
					"from gradebook where " +sql;
		}
		return "";
	}

}
