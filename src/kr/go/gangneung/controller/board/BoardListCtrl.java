package kr.go.gangneung.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.dto.Board;
import kr.go.gangneung.model.BoardDAO;

@WebServlet("/BoardList.do")
public class BoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardDAO dao = new BoardDAO();
		ArrayList<Board> board = dao.boardList();
		
		request.setAttribute("board", board);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/admin/boardList.jsp");
		view.forward(request, response);
	}

}
