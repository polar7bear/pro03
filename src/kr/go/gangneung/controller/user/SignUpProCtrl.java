package kr.go.gangneung.controller.user;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crypto.util.AES256;

import kr.go.gangneung.dto.User;
import kr.go.gangneung.model.UserDAO;

@WebServlet("/SignUpPro.do")
public class SignUpProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8"); 
		User user = new User();
		String key = "%03b";
		String pw = request.getParameter("pw");
		String passwd ="";
		try {
			passwd = AES256.encryptAES256(pw, key);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		user.setId(request.getParameter("id"));
		user.setPw(passwd);
		user.setName(request.getParameter("name"));
		user.setAddress(request.getParameter("address1")+" "+request.getParameter("address2"));
		user.setTel(request.getParameter("tel"));
		
		UserDAO dao = new UserDAO();
		int cnt = dao.userJoin(user);
		
		if(cnt>=1){
			response.sendRedirect("Login.do");
		} else{
			response.sendRedirect("SignUp.do");
		}
		
	}

}
