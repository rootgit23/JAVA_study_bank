package com.im.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.im.start.util.DBConnector;

public class BoardDAO {
	
	public ArrayList<BoardDTO> getList() throws Exception{
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("NUM"));
			boardDTO.setTitle(rs.getString("TITLE"));
			boardDTO.setContent(rs.getString("CONTENT"));
			boardDTO.setUserName(rs.getString("USER_NAME"));
			boardDTO.setRegist(rs.getDate("REGIST"));
			boardDTO.setHit(rs.getLong("HIT"));
			ar.add(boardDTO);
		}
		DBConnector.disConnection(rs, st, con);
		return ar;
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getNum());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("NUM"));
			boardDTO.setTitle(rs.getString("TITLE"));
			boardDTO.setContent(rs.getString("CONTENT"));
			boardDTO.setUserName(rs.getString("USER_NAME"));
			boardDTO.setRegist(rs.getDate("REGIST"));
			boardDTO.setHit(rs.getLong("HIT"));
		}
		else
			return null;
		String sql2 = "UPDATE BOARD SET HIT = HIT + 1 WHERE NUM=?";
		PreparedStatement st2 = con.prepareStatement(sql2);
		st2.setLong(1, boardDTO.getNum());
		st2.executeUpdate();
		DBConnector.disConnection(rs, st, con);
		DBConnector.disConnection(st2, con);
		return boardDTO;
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContent());
		st.setString(3, boardDTO.getUserName());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BOARD SET TITLE=? , CONTENT=? WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContent());
		st.setLong(3, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "DELETE BOARD WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}

}
