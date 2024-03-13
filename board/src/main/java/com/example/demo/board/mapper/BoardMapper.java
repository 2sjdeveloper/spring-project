package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.board.BoardVO;
import com.example.demo.board.SearchVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(@Param("vo") BoardVO vo, SearchVO svo);
	BoardVO getBoardInfo(String boardNo);
	String insertBoard(BoardVO boardVO);
	String deleteBoard(String BoardNo);
	List<Map<String, Object>> getStat();

}
