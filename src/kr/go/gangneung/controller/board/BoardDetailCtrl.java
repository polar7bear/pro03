package kr.go.gangneung.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.dto.Board;
import kr.go.gangneung.model.BoardDAO;

@WebServlet("/BoardDetail.do")
public class BoardDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		Board board = new Board();
		BoardDAO dao = new BoardDAO();
		
		board = dao.boardDetail(bno);
		
		request.setAttribute("board", board);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/adminBoardDetail.jsp");
		view.forward(request, response);
	}

}
