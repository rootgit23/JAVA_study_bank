package com.im.start.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public ArrayList<BoardDTO> getList() throws Exception{
		return boardDAO.getList();
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return boardDAO.getDetail(boardDTO);
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception{
		return boardDAO.setAdd(boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return boardDAO.setUpdate(boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return boardDAO.setDelete(boardDTO);
	}

}
