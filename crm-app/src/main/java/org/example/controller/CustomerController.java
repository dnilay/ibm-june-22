package org.example.controller;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController extends HttpServlet {

    private CustomerDao customerDao;

    @Override
    public void init() throws ServletException {
        customerDao=new CustomerDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }
    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fName=req.getParameter("fName");
        String lName=req.getParameter("lName");
        String email=req.getParameter("email");
        Customer customer=new Customer();
        customer.setFirstName(fName);
        customer.setLastName(lName);
        customer.setEmail(email);
        Customer c=customerDao.createCustomer(customer);
        req.setAttribute("CUSTOMER",c);
        RequestDispatcher view=req.getRequestDispatcher("success.jsp");
        view.forward(req,resp);

    }
}
