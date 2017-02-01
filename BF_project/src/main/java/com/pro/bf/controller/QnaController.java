package com.pro.bf.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pro.bf.dao.QnADao;
import com.pro.bf.dto.QnAVO;
import com.pro.bf.serviceImpl.MbrServiceImpl;
import com.pro.bf.serviceImpl.QnAServiceImpl;

@Controller
@RequestMapping(value = "/qna")
public class QnaController {

	/*@Autowired(required = false)
	QnAService qnaService;*/

	@Autowired(required = false)
	QnAServiceImpl qnaServiceImpl;

	@Autowired(required = false)
	MbrServiceImpl mbrServiceImpl;

	@Autowired(required = false)
	QnADao qnaDao;

	/*public void setQnaService(QnAService qnaService) {
		this.qnaService = qnaService;
	}*/

	public void setQnaService(QnAServiceImpl qnaServiceImpl) {
		this.qnaServiceImpl = qnaServiceImpl;
	}

	public void setMbrService(MbrServiceImpl mbrServiceImpl) {
		this.mbrServiceImpl = mbrServiceImpl;
	}

	@RequestMapping("/qnaList")
	public String qnaList(HttpServletRequest request, HttpSession session,
			Model model) throws ServletException, IOException {

		String url = "qna/qnaList";
		String tpage = request.getParameter("tpage");

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		model.addAttribute("tpage", tpage);

		ArrayList<QnAVO> qnaList = null;
		String paging = null;
		try {
			qnaList = qnaServiceImpl.getQnaList(Integer.parseInt(tpage));
			paging = qnaServiceImpl.pageNumber(Integer.parseInt(tpage));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ///////////////////////////////////////////////////////////////////
		model.addAttribute("qnaList", qnaList);
		int n = qnaList.size();
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping("/delete")
	public String deleteQna(@RequestParam("qna_num") int qna_num)
			throws ServletException, IOException {

		String url = "redirect:qnaList";

		try {
			qnaDao.deleteQna(qna_num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/qnaView")
	public String qnaView(@RequestParam("qna_num") int qna_num,
			HttpSession session, Model model) throws ServletException,
			IOException, SQLException {

		String url = "qna/qnaView";

		QnAVO qnaVO = mbrServiceImpl.getQnaVO(qna_num);
		model.addAttribute("qnaVO", qnaVO);

		return url;
	}

	@RequestMapping("/qnaWrite")
	public String qnaWriteForm(HttpSession session) throws ServletException,
			IOException {

		String url = "qna/qnaWrite";
		System.out.println("qnawrite");
		String loginUser = (String) session.getAttribute("loginUser");
		return url;
	}

	// @RequestMapping("/qnaWriteForm")
	@RequestMapping(value = "/qnaWriteForm", method = RequestMethod.POST)
	public String qnaWrite(@RequestParam("qna_title") String qna_title,
			@RequestParam("qna_content") String qna_content, HttpSession session
			,
			@RequestParam(value="file",defaultValue="")
			MultipartFile filefile, HttpServletRequest request
			
			)
			throws ServletException, IOException, SQLException {

		String url = "redirect:qnaList";

		String loginUser = (String) session.getAttribute("loginUser");

		QnAVO qnaVO = new QnAVO();

		qnaVO.setQna_title(qna_title);
		qnaVO.setQna_content(qna_content);
		qnaVO.setMbr_id(loginUser);
		/* qnaVO.setMbr_id("test"); */


		//fileupload
		 session=request.getSession();
		String savaPath="resources/upload";
		ServletContext context=session.getServletContext();
		String uploadFilePath=context.getRealPath(savaPath);
		
		if(!filefile.isEmpty()){
			File file1=new File(uploadFilePath,System.currentTimeMillis()+filefile.getOriginalFilename());
			filefile.transferTo(file1);
			qnaVO.setQna_pict_afat(file1.getName());
		}
		
		
		qnaServiceImpl.insertQna(qnaVO);

		
		
		/* qnaServiceImpl.insertQna(qnaVO, qnaVO.getMbr_id()); */

		return url;
	}

	@RequestMapping("/update")
	public String qnaUpdate(HttpSession session, String qna_num, Model model)
			throws ServletException, IOException, SQLException {

		String url = "qna/qnaUpdate";

		QnAVO qnaVO = qnaServiceImpl.getQnaDetail(qna_num);

		model.addAttribute("qnaVO", qnaVO);
		model.addAttribute(qna_num);

		return url;
	}

	@RequestMapping(value = "/qnaUpdateForm", method = RequestMethod.POST)
	public String qnaUpdateForm(@RequestParam("qna_num") int qna_num,
			@RequestParam("qna_title") String qna_title,
			@RequestParam("qna_content") String qna_content, Model model
			,
			HttpServletRequest request,
			@RequestParam("file")MultipartFile file,
			@RequestParam("nofile")String nofile,
			@RequestParam(value="qna_pict_afat",defaultValue="")String qna_pict_afat
			)
			throws ServletException, IOException, SQLException {

		String url = "redirect:qnaList";

		QnAVO qnaVO = new QnAVO();

		qnaVO.setQna_title(qna_title);
		qnaVO.setQna_content(qna_content);
		qnaVO.setQna_num(qna_num);
		qnaServiceImpl.updateQna(qnaVO);

		model.addAttribute(qna_num);

		

		HttpSession session = request.getSession();

		/////////////
		String savePath = "resources/upload";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		if (!file.isEmpty()) {
			File file1 = new File(uploadFilePath, System.currentTimeMillis() + file.getOriginalFilename());
			file.transferTo(file1);

			qnaVO.setQna_pict_afat(file1.getName());
		} else {
			qnaVO.setQna_pict_afat(nofile);
		}
		qnaServiceImpl.updateQna(qnaVO);

		
		return url;
	}

}
