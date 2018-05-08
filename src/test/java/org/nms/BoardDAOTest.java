package org.nms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nms.dao.BoardDAO;
import org.nms.vo.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Autowired
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		
		
		for(int i = 0 ; i <300; i++ ) {
		board.setTitle("페이징 테스트 제목");
		board.setContent("페이징 테스트 내용");
		board.setWriter("tester00");
		dao.create(board);
		}
	}
	
/*	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(2).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("�׽�Ʈ ������ ��");
		board.setContent("�׽�Ʈ ������ ����");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}*/
}
