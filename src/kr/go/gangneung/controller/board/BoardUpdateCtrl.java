package kr.go.gangneung.controller.board;

import java.io.IOException;



import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.model.BoardDAO;


import kr.go.gangneung.dto.Board;
import kr.go.gangneung.dto.Category;

@WebServlet("/BoardUpdate.do")
public class BoardUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		Board board = new Board();
		BoardDAO dao = new BoardDAO();
		
		board = dao.boardSelectOne(bno);
		
		ArrayList<Category> cateList = dao.getFirstCategoryList();
		request.setAttribute("cateList", cateList);
		
		request.setAttribute("board", board);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/boardUpdate.jsp");
		view.forward(request, response);
	}

}
