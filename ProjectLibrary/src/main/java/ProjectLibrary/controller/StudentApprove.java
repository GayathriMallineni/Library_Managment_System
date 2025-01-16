package ProjectLibrary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProjectLibrary.dao.StudentDao;

@WebServlet("/ApproveStudent")
public class StudentApprove extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		
		StudentDao studentDao = new StudentDao();
		 if(studentDao.approve(email)>0)
		 {
			 req.getRequestDispatcher("BorrowRequest.jsp").forward(req, resp);
		 }
		
		
	}

}