package kr.go.gangneung.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crypto.util.AES256;

import kr.go.gangneung.dto.User;
import kr.go.gangneung.util.MySQL8;

public class UserDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String key = "%03b";
	String qpw;
	
	//유저 회원가입
	public int userJoin(User user){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_JOIN);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getTel());
			pstmt.setString(5, user.getAddress());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	//유저 로그인
	public int userLogin(String id, String pw){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				if(pw.equals(qpw)){
					cnt = 1;
				} else{
					cnt = 0;
				}
			} else{
				cnt = 9;
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	//유저 마이페이지
	public User myPage(String id){
		User user = new User();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_SELECT_ONE);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();
				String vpw = qpw.substring(0, 3);
				String hpw = "";
				for(int i=0;i<k-3;i++){
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddress(rs.getString("address"));
				user.setRegdate(rs.getString("regdate"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(rs, pstmt, con);
		}
		return user;
	}
	
	//유저 회원정보 수정
	public int userUpdate(User user){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_UPDATE);
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	//회원탈퇴
	public int userDelete(String id){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_DELETE);
			pstmt.setString(1, id);
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
}
