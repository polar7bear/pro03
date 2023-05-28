package kr.go.gangneung.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQL8 {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/gangneung?serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pass = "root1234";
	
	//회원기능
	public final static String USER_JOIN = "insert into user values(?, ?, ?, ?, ?, default);";	//회원가입
	public final static String USER_LOGIN = "select * from user where id=?";	//로그인
	public final static String USER_UPDATE = "update user set pw=?, name=?, tel=?, address=? where id=?"; //회원 정보수정
	public final static String USER_UPDATE2 = "update user set name=?, tel=?, address=? where id=?";
	public final static String USER_SELECT_ONE = "select * from user where id=?"; //마이페이지, 회원 한명의 상세정보
	public final static String USER_DELETE = "delete from user where id=?";	//유저 회원 탈퇴
	public final static String USER_SELECT_LIST = "select id, name, tel, regdate from user order by regdate desc";	//유저 목록 보기 (관리자 기능)
	
	//공지사항 기능
	public final static String NOTICE_INSERT = "insert into notice(no, title, content, regdate, visited, file1) values(default, ?, ?, default, default, ?);";	//공지사항 글쓰기(관리자 기능)
	public final static String NOTICE_UPDATE = "update notice set title=?, content=?, file1=?, editdate=now() where no=?";	//공지사항 글 수정(관리자 기능) (첨부파일有)
	public final static String NOTICE_UPDATE2 = "update notice set title=?, content=? editdate=now() where no=?";	//공지사항 글 수정 (관리자 기능) (첨부파일無)
	public final static String NOTICE_DELETE = "delete from notice where no=?";	//공지사항 글 삭제(관리자 기능)
	public final static String NOTICE_SELECT_ALL = "select no, title, regdate, visited, file1 from notice order by no desc";	//공지사항 목록 보기 (내용제외)
	public final static String NOTICE_SELECT_ONE = "select * from notice where no=?";	//공지사항 상세보기
	public final static String NOTICE_UPDATE_VISITED = "update notice set visited=visited+1 where no=?";	//공지사항 조회수 기능

	//게시판 기능
	public final static String BOARD_SELECT_CATE = "select * from board where cate=?";	//카테고리 소분류별 게시글 목록 불러오기
	public final static String BOARD_SELECT_CATENAME = "select * from category where cate=?";
	public final static String BOARD_SELECT_CATEGROUP = "select * from board where cate like '?%'"; //카테고리 대분류별 게시글 목록 불러오기
	public final static String FIRST_CATEGORY_SELECT = "select distinct substr(cate,1,2) as ct, categroup from category group by substr(cate,1,2), categroup order by ct";
	public final static String SECOND_CATEGORY_SELECT = "select cate, catename from category where cate like ? order by cate";
	public final static String BOARD_SELECT_ONE = "select * from board where bno=?";	//특정 게시글 상세보기
	public final static String BOARD_SELECT_ALL = "select * from board order by cate asc";	//전체 게시글 불러오기 (관리자 기능)
	public final static String BOARD_SELECT_LIST = "select bno, btitle, cate from board order by cate asc";	//전체 게시글 리스트 불러오기(관리자 기능, 글번호랑 제목과 카테번호만)
	public final static String BOARD_INSERT = "insert into board values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	//게시글 등록 (관리자 기능)
	public final static String BOARD_UPDATE = "update board set btitle=?, bcontent=?, baddress=?, btel=?, bpic1=?, bpic2=?, bpic3=?, bpic4=?, cate=? where bno=?";	//게시글 수정 (관리자 기능)
	public final static String BOARD_DELETE = "delete from board where bno=?";	//게시글 삭제 (관리자 기능)
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	
	public static void close(PreparedStatement pstmt, Connection con){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
