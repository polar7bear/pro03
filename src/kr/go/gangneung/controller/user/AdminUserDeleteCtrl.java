package kr.go.gangneung.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.model.UserDAO;

@WebServlet("/AdminUserDelete.do")
public class AdminUserDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int cnt = 0;
		UserDAO dao = new UserDAO();
		
		cnt = dao.userDelete(id);
		
		if(cnt>=1){
			response.sendRedirect("UserList.do");
		} else{
			response.sendRedirect("UserList.do");
		}
	}

}
