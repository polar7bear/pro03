package kr.go.gangneung.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import kr.go.gangneung.dto.Board;
import kr.go.gangneung.dto.Category;
import kr.go.gangneung.util.MySQL8;

public class BoardDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//특정 게시글 상세보기
	public Board boardDetail(int bno){
		Board board = new Board();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_SELECT_ONE);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBaddress(rs.getString("baddress"));
				board.setBtel(rs.getString("btel"));
				board.setBpic1(rs.getString("bpic1"));
				board.setBpic2(rs.getString("bpic2"));
				board.setBpic3(rs.getString("bpic3"));
				board.setBpic4(rs.getString("bpic4"));
				board.setCate(rs.getString("cate"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			MySQL8.close(rs, pstmt, con);
		}
		return board;
	}
	
	//카테고리 소분류별 게시글 목록 불러오기
	public ArrayList<Board> getCateBoardList(String cate){
		ArrayList<Board> bList = new ArrayList<Board>();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_SELECT_CATE);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBaddress(rs.getString("baddress"));
				board.setBtel(rs.getString("btel"));
				board.setBpic1(rs.getString("bpic1"));
				board.setBpic2(rs.getString("bpic2"));
				board.setBpic3(rs.getString("bpic3"));
				board.setBpic4(rs.getString("bpic4"));
				board.setCate(rs.getString("cate"));
				bList.add(board);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return bList;
	}
	
	//카테고리 로딩
	public HashMap<String, String> getCategory(String cate){
		HashMap<String, String> cateMap = new HashMap<String, String>();
		String cateGroup = "";
		String cateName = "";
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_SELECT_CATENAME);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cateGroup = "catename";
				cateName = rs.getString("catename");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		cateMap.put(cateGroup, cateName);
		return cateMap;
	}
	
	//카테고리 대분류별 게시글 목록 불러오기
	public ArrayList<Board> getCateGroupBoardList(String initial){
		ArrayList<Board> bList = new ArrayList<Board>();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_SELECT_CATEGROUP);
			pstmt.setString(1, initial);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBaddress(rs.getString("baddress"));
				board.setBtel(rs.getString("btel"));
				board.setBpic1(rs.getString("bpic1"));
				board.setBpic2(rs.getString("bpic2"));
				board.setBpic3(rs.getString("bpic3"));
				board.setBpic4(rs.getString("bpic4"));
				board.setCate(rs.getString("cate"));
				bList.add(board);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return bList;
	}
	
	public ArrayList<Category> getFirstCategoryList(){
		ArrayList<Category> cateList = new ArrayList<>();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FIRST_CATEGORY_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category cate = new Category();
				cate.setCt(rs.getString("ct"));
				cate.setCateGroup(rs.getString("cateGroup"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cateList;
	}
	
	public ArrayList<Category> getSecondCategoryList(){
		ArrayList<Category> cateList = new ArrayList<Category>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SECOND_CATEGORY_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category cate = new Category();
				cate.setCate(rs.getString("cate"));
				cate.setCateName(rs.getString("cateName"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cateList;
	}

	
	//전체 게시글 불러오기 (관리자 기능)
	public ArrayList<Board> boardAll(){
		ArrayList<Board> bList = new ArrayList<Board>();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBaddress(rs.getString("baddress"));
				board.setBtel(rs.getString("btel"));
				board.setBpic1(rs.getString("bpic1"));
				board.setBpic2(rs.getString("bpic2"));
				board.setBpic3(rs.getString("bpic3"));
				board.setBpic4(rs.getString("bpic4"));
				board.setCate(rs.getString("cate"));
				bList.add(board);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return bList;
	}
	
	//게시글 리스트 불러오기 (관리자 기능) 단, 글번호와 카테고리 번호만
	public ArrayList<Board> boardList(){
		ArrayList<Board> bList = new ArrayList<Board>();
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_SELECT_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setCate(rs.getString("cate"));
				bList.add(board);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return bList;
	}
	
	//게시글 등록 (관리자 기능)
	public int boardInsert(Board board){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_INSERT);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBaddress());
			pstmt.setString(4, board.getBtel());
			pstmt.setString(5, board.getBpic1());
			pstmt.setString(6, board.getBpic2());
			pstmt.setString(7, board.getBpic3());
			pstmt.setString(8, board.getBpic4());
			pstmt.setString(9, board.getCate());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	//게시글 수정 (관리자 기능)
	public int boardUpdate(Board board){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_UPDATE);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBaddress());
			pstmt.setString(4, board.getBtel());
			pstmt.setString(5, board.getBpic1());
			pstmt.setString(6, board.getBpic2());
			pstmt.setString(7, board.getBpic3());
			pstmt.setString(8, board.getBpic4());
			pstmt.setString(9, board.getCate());
			pstmt.setInt(10, board.getBno());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	//게시글 삭제 (관리자 기능)
	public int boardDelete(int bno){
		int cnt = 0;
		try{
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.BOARD_DELETE);
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
}
