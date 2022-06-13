package org.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.model.League;

/**
 * Servlet implementation class AddLeague
 */
public class AddLeague extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> errorMessage=null;
				errorMessage=new ArrayList<String>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String year = request.getParameter("year");
		String season = request.getParameter("season");
		String title = request.getParameter("title");
		int iYear=0;
		try {
			
			iYear=Integer.parseInt(year);
		} catch (Exception e) {
			// TODO: handle exception
			errorMessage.add("year fieldmust be numeric.");
		}
		if(season.equals("Unknown"))
		{
			errorMessage.add("please select a season.");
		}
		if(title.length()<5)
		{
			errorMessage.add("invalid title must be atleast 5 char long.");
		}
		if(!errorMessage.isEmpty())
		{
			request.setAttribute("ERROR", errorMessage);
			RequestDispatcher view=request.getRequestDispatcher("error_page.view");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("LEAGUE", new League(iYear,season,title));
			RequestDispatcher view=request.getRequestDispatcher("success_page.view");
			view.forward(request, response);
		}

	}
}
