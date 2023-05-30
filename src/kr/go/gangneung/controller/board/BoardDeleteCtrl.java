package kr.go.gangneung.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.model.BoardDAO;

@WebServlet("/BoardDelete.do")
public class BoardDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardDelete(bno);
		
		if(cnt>=1) {
			response.sendRedirect("BoardList.do");
		} else {
			response.sendRedirect("BoardList.do");
		}
	}

}
