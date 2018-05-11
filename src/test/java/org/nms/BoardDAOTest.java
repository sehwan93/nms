package org.nms;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nms.dao.BoardDAO;
import org.nms.util.Criteria;
import org.nms.vo.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Autowired
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
/*	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		
		
		for(int i = 0 ; i <300; i++ ) {
		board.setTitle("페이징 테스트 제목");
		board.setContent("페이징 테스트 내용");
		board.setWriter("tester00");
		dao.create(board);
		}
	}*/
	
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
	
	@Test
	public void testListPage() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(3);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listPage(cri);
		
		for(BoardVO board : list ) {
			System.out.println(board.getBno());
		}
	}
	
	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
		
	}
	
}
