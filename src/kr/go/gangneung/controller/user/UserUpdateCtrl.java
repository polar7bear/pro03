package kr.go.gangneung.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.dto.User;
import kr.go.gangneung.model.UserDAO;

@WebServlet("/UserUpdate.do")
public class UserUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = new User();
		UserDAO dao = new UserDAO();
		
		user = dao.myPage(id);
		
		request.setAttribute("user", user);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/updateUser.jsp");
		view.forward(request, response);
		
	}

}
