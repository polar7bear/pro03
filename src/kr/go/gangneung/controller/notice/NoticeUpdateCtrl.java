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
		
		notice = ndao.noticeUpdate(no);
		
		//한글 파일 이름 인코딩 처리
		String file1 = notice.getFile1().substring(5);
		String filepath1 = notice.getFile1().substring(0, 4);
		
		file1 = URLEncoder.encode(file1, "UTF-8");
		
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("notice", notice);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeUpdate.jsp");
		view.forward(request, response);
	}

}
