package kr.go.gangneung.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.model.NoticeDAO;

@WebServlet("/NoticeDelete.do")
public class NoticeDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.noticeDelete(no);
		
		if(cnt>=1){
			response.sendRedirect("NoticeList.do");
		} else {
			response.sendRedirect("NoticeDetail.do");
		}
	}

}
