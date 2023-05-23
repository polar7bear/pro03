package kr.go.gangneung.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.gangneung.dto.User;
import kr.go.gangneung.model.UserDAO;

@WebServlet("/MyInfo.do")
public class MyInfoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String id = (String) ses.getAttribute("sid");
		
		User user = new User();
		UserDAO dao = new UserDAO();
		String msg = "정보 로딩";
		
		user = dao.myPage(id);
		
		request.setAttribute("user", user);
		request.setAttribute("msg", msg);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/myInfo.jsp");
		view.forward(request, response);
	}

}
