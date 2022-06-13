package org.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.dao.LeagueDao;
import org.example.dao.LeagueDaoImpl;
import org.example.model.League;

/**
 * Servlet implementation class ListLeague
 */
public class ListLeague extends HttpServlet {
	private List<League> leagueList;
	private LeagueDao leagueDao;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		leagueDao=new LeagueDaoImpl();
		try {
			leagueList = leagueDao.fetchAllLeagues();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Set page title
		String pageTitle = "Duke’s Soccer League: List Leagues";
		// Specify the content type is HTML
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Generate the HTML response
		out.println("<html>");
		out.println("<head>");
		out.println(" <title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		// Generate page heading
		out.println("<!-- Page Heading -->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
		out.println(" <td><h3>" + pageTitle + "</h3></td>");
		out.println("</tr>");
		out.println("</table>");
		// Generate main body
		out.println("<p>");
		out.println("The set of soccer leagues are:");
		out.println("</p>");
		out.println("<ul>");
		Iterator<League> items = leagueList.iterator();
		while ( items.hasNext() ) {
		League league = items.next();
		out.println("<li>" + league.getTitle() + "</li>");
		 }
		 out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		} // END of doGet method

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
