package kr.go.gangneung.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import kr.go.gangneung.dto.Notice;
import kr.go.gangneung.util.MySQL8;

public class NoticeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//공지사항 목록보기
	public ArrayList<Notice> noticeList(){
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Notice notice = new Notice();
				notice.setNo(rs.getInt("no"));
				notice.setTitle(rs.getString("title"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setVisited(rs.getInt("visited"));
				notice.setFile1(rs.getString("file1"));
				noticeList.add(notice);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(rs, pstmt, con);
		}
		return noticeList;
	}
	
	//공지사항 글 상세보기
	public Notice noticeDetail(int no){
		noticeVisited(no);
		Notice notice = new Notice();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				notice.setNo(rs.getInt("no"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setVisited(rs.getInt("visited"));
				notice.setFile1(rs.getString("file1"));
				notice.setEditdate(rs.getString("editdate"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return notice;
	}
	
	//공지사항 글 한개를 클릭하여 들어갔을때 조회수 1씩 증가
	public void noticeVisited(int no){
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_UPDATE_VISITED);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(pstmt, con);
		}
	}
	
	//공지사항 글 쓰기
	public int noticeInsert(Notice notice){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_INSERT);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getFile1());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	public Notice noticeUpdate(int no){
		Notice notice = new Notice();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				notice.setNo(rs.getInt("no"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setFile1(rs.getString("file1"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setVisited(rs.getInt("visited"));
				notice.setEditdate(rs.getString("editdate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return notice;
	}
	
	//공지사항 글 수정
	public int noticeUpdatePro(Notice notice){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			if(notice.getFile1()==null){
				pstmt = con.prepareStatement(MySQL8.NOTICE_UPDATE);
				pstmt.setString(1, notice.getTitle());
				pstmt.setString(2, notice.getContent());
				pstmt.setString(3, notice.getFile1());
				pstmt.setInt(4, notice.getNo());
			} else{
				pstmt = con.prepareStatement(MySQL8.NOTICE_UPDATE2);
				pstmt.setString(1, notice.getTitle());
				pstmt.setString(2, notice.getContent());
				pstmt.setInt(3, notice.getNo());
			}
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	//공지사항 글 삭제
	public int noticeDelete(int no){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_DELETE);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
}
