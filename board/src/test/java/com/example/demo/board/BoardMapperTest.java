package com.example.demo.board;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper mapper;
	
	@Test
	public void 게시글전체검색() {
		BoardVO vo = new BoardVO();
		SearchVO svo = new SearchVO();
		List<BoardVO> list = mapper.getBoardList(vo, svo);
		for(BoardVO board : list) {
			System.out.println(board.getBoardNo()+ ":" + board.getTitle());	
		}
		System.out.println("결과는 : " + list.size());
	}
	
	@Test
	public void 게시글단건조회() {
		String boardNo = "2";
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
	}

}
