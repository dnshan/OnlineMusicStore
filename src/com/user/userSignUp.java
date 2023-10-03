package com.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userSignUp")
public class userSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public userSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
	}

}
