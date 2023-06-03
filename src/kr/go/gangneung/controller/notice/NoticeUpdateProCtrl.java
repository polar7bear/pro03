package kr.go.gangneung.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gangneung.dto.Notice;
import kr.go.gangneung.model.NoticeDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/NoticeUpdatePro.do")
public class NoticeUpdateProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/data";	
		int uploadFileSizeLimit = 10 * 1024 * 1024;	
		String encType = "UTF-8";		
		ServletContext context = getServletContext();	
		String uploadFilePath = context.getRealPath(savePath);  
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		int no = 0;
		String title = "";
		String content = "";
		String file1 = "";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
				uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		try {
			
			file1 = multi.getFilesystemName("file1"); 
			if (file1 == null) { 
				System.out.print("파일 업로드 실패");
			}  
			no = Integer.parseInt(multi.getParameter("no"));
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			System.out.println(file1);
			System.out.println(no);
			System.out.println(title);
			System.out.println(content);
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		NoticeDAO ndao = new NoticeDAO();
		Notice notice = new Notice();
		notice.setNo(no);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setFile1(file1);
		int cnt = ndao.noticeUpdatePro(notice);
		if(cnt==0){
			String msg = "공지사항을 글이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeInsert.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("NoticeList.do");
		}
	}

}
