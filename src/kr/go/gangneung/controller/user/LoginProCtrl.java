package kr.go.gangneung.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.gangneung.model.UserDAO;

@WebServlet("/LoginPro.do")
public class LoginProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = new UserDAO();
		int cnt = 0;
		cnt = dao.userLogin(id, pw);
		
		HttpSession ses = request.getSession();
		String msg;
		if(cnt==1){
			msg = "로그인 성공";
			ses.setAttribute("sid", id);
			response.sendRedirect(request.getContextPath());
		} else if(cnt==9){
			msg = "아이디 혹은 비밀번호가 틀립니다.";
			response.sendRedirect("Login.do?msg="+msg);
		} else{
			msg = "아이디가 존재하지 않습니다.";
			response.sendRedirect("Login.do?msg="+msg);
		}
	}

}
