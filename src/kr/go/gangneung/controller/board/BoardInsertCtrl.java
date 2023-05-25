package kr.go.gangneung.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.dto.Category;
import kr.go.gangneung.model.BoardDAO;

@WebServlet("/BoardInsert.do")
public class BoardInsertCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "게시글을 작성 해주세요.";
		request.setAttribute("msg", msg);
		BoardDAO dao = new BoardDAO();
		ArrayList<Category> cateList = dao.getFirstCategoryList();
		ArrayList<Category> cateList2 = dao.getSecondCategoryList();
		request.setAttribute("cateList", cateList);
		request.setAttribute("cateList2", cateList2);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/boardInsert.jsp");
		view.forward(request, response);
	}

}
