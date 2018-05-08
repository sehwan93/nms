package org.nms.controller;

import org.nms.service.BoardService;
import org.nms.vo.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET(BoardVO board, Model model ) throws Exception {
		logger.info("register get,,...............");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board,RedirectAttributes rttr) throws Exception {
		logger.info("register post............");
		logger.info(board.toString());
		
		service.regist(board);
		
		// �����̷�Ʈ�� �� ���� ���Ǵ� �����͸� ���� �� �� ����.
		rttr.addFlashAttribute("msg","success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list.................");
		model.addAttribute("list",service.listAll());
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg","success");
		return "redirect:/board/listAll";
	}
}
