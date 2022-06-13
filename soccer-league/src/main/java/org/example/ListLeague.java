package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.model.League;

/**
 * Servlet implementation class ListLeague
 */
public class ListLeague extends HttpServlet {
	private List<League> list;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list=new ArrayList<League>();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list.add(new League("IPL", "Winter", "2022"));
		list.add(new League("Soccer League", "Autumn", "2022"));
		list.add(new League("Men's Cricket", "Winter", "2022"));
		list.add(new League("Football", "summer", "2021"));
		list.add(new League("Volley", "Summer", "2022"));
		out.println("<html><head><title>list_leagues_page</title><head><body><table border='1'><tr><td>Title</td><td>Season</td><td>year</td></tr>");
		for(League l:list)
		{
			out.println("<tr><td>"+l.getTitle()+"</td><td>"+l.getSeason()+"</td><td>"+l.getYear()+"</td></tr>");
		}
		out.println("</table></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
