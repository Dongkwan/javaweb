package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.demo.domain.BoardVO;

//WebEnvironment.RANDOM_PORT설정하면 MockMvc 객체 사용하지 않음
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BoardControllerTest2 {	
	
	@Autowired
	private TestRestTemplate restTemplate; 
	
	@Test //내장톰캣으로 테스트하기
	public void testGetBoard() {
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터", board.getWriter());
	}
}


