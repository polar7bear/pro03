package kr.go.gangneung.controller.notice;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.dto.Notice;
import kr.go.gangneung.model.NoticeDAO;

@WebServlet("/NoticeUpdate.do")
public class NoticeUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDAO ndao = new NoticeDAO();
		Notice notice = new Notice();
		String file1 = request.getParameter("file1");
		
		if(file1==null) {
			notice = ndao.noticeUpdate2(no);
		} else {
			notice = ndao.noticeUpdate(no);
		}
		
		
		request.setAttribute("notice", notice);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeUpdate.jsp");
		view.forward(request, response);
	}

}
