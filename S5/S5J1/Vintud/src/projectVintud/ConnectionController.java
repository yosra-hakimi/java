package projectVintud;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionController
 */
@WebServlet("/signup")
public class ConnectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
		
		/*
		
		response.setContentType("text/html");  // le contenue de type text/ html
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		String getPassword = request.getParameter("psw");
		String getEmail = request.getParameter("email");
		writer.println("  <h1> Information Stored Successfully </h1> ");	
		writer.println("  <h3> your Information  </h3> ");
		writer.println("my password is"+ getPassword );
		writer.println("my email is"+ getEmail );
		
		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
