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

@WebServlet("/AdminUserDetail.do")
public class AdminUserDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("id");
		
		User user = new User();
		UserDAO dao = new UserDAO();
		String msg = "회원 상세";
		
		user = dao.myPage(id);
		
		request.setAttribute("user", user);
		request.setAttribute("msg", msg);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/adminUserDetail.jsp");
		view.forward(request, response);
		
	}

}
