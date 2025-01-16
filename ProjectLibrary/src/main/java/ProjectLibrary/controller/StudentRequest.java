package ProjectLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProjectLibrary.dao.StudentDao;
import ProjectLibrary.dto.Student;

@WebServlet("/StudentRequest")
public class StudentRequest extends HttpServlet
{
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		     
		 
		String email = req.getParameter("email");
		System.out.println(email);
			
		StudentDao studentDao = new StudentDao();
			
		 
	 
		if(studentDao.request(email)>0)
		{
			req.getRequestDispatcher("studentLogin.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("request", "The email was not found in the data base please Enter the correct email");
			req.getRequestDispatcher("studentRequest.jsp").include(req, resp);
		}
		 
		 
		
		
	}
}
