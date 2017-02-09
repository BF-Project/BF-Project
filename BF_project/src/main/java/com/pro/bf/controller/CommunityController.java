package com.pro.bf.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pro.bf.dao.CommunityDao;
import com.pro.bf.daoImpl.CommunityDaoImpl;
import com.pro.bf.dto.CommunityVO;
import com.pro.bf.dto.NoticeVO;
import com.pro.bf.serviceImpl.CmtServiceImpl;
import com.pro.bf.serviceImpl.CommunityServiceImpl;
import com.pro.bf.serviceImpl.MbrServiceImpl;
import com.pro.bf.serviceImpl.NoticeServiceImpl;

//controller 설정
//Requestmapping 설정

@Controller
@RequestMapping(value="/cmmt")
public class CommunityController {
	
	//@Autowired설정
	@Autowired(required=false)
	CommunityServiceImpl cmmtServiceImpl;
	
	@Autowired(required=false)
	MbrServiceImpl mbrServiceImpl;
	
	@Autowired(required=false)
	CommunityDao cmmtDao;
	
	@Autowired(required=false)
	CommunityDaoImpl cmmtDaoImpl;
	
	/*@Autowired
	NoticeServiceImpl noticeService;
	*/
	//set설정
	public void setCmmtServiceImpl(CommunityServiceImpl cmmtServiceImpl) {
		this.cmmtServiceImpl = cmmtServiceImpl;
	}

	public void setMbrServiceImpl(MbrServiceImpl mbrServiceImpl) {
		this.mbrServiceImpl = mbrServiceImpl;
	}

	public void setCmmtDao(CommunityDao cmmtDao) {
		this.cmmtDao = cmmtDao;
	}

	//listmapping설정
	@RequestMapping("/cmmtList")
	public String cmmtList(HttpServletRequest request,HttpSession session,Model model)
	throws ServletException,IOException{
		
		String url="cmmt/cmmtList";
		
		//페이징처리(전체페이지변수)
		String tpage =request.getParameter("tpage");
		String search=request.getParameter("search");
		if(search==null || search.equals(""))
			search="";
		System.out.println("tpage:"+tpage);
		System.out.println("search:"+search);
		if(tpage==null){
			tpage="1";
		}else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		//페이징처리 배열설정 (초기변수)
		ArrayList<CommunityVO> cmmtList=null;
		String paging =null;
		try{
			cmmtList=cmmtServiceImpl.getCmmtList(Integer.parseInt(tpage), search);
			//getCmmtList(Integer.parseInt(tpage));
			paging=cmmtServiceImpl.pageNumber(Integer.parseInt(tpage), search);
					//pageNumber(Integer.parseInt(tpage),search);
			System.out.println("cnntList:"+cmmtList);
			System.out.println("paging:"+paging);
			for(CommunityVO VO : cmmtList){
				System.out.println(VO.getCmmt_content());
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		///////////////////페이징처리
		model.addAttribute("cmmtList",cmmtList);
		int n=cmmtList.size();
		System.out.println("n:"+n);
		model.addAttribute("cmmtListSize",n);
		model.addAttribute("paging",paging);
		
		return url;
	}
	
	//delete mapping 설정
	@RequestMapping("/delete")
	public String deleteCmmt(
			@RequestParam("cmmt_num")int cmmt_num)throws ServletException,IOException{
		
		String url="redirect:cmmtList";
		
		try{
			cmmtDao.deleteCmmt(cmmt_num);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return url;
	}
	
	
		@RequestMapping("/cmmtView")
		public String cmmtView(@RequestParam("cmmt_num") int cmmt_num,
				HttpSession session, Model model) throws ServletException,
				IOException, SQLException {

			String url = "cmmt/cmmtView";

			CommunityVO cmmtVO = mbrServiceImpl.getCmmtVO(cmmt_num);
			model.addAttribute("cmmtVO", cmmtVO);

			return url;
		}

		@RequestMapping("/cmmtWrite")
		public String cmmtWriteForm(HttpSession session) throws ServletException, IOException {
			String url = "cmmt/cmmtWrite";
			String loginUser = (String) session.getAttribute("loginUser");
			return url;
		}

		@RequestMapping(value = "/cmmtWriteForm", method = RequestMethod.POST)
		public String cmmtWrite(@RequestParam("cmmt_title") String cmmt_title,
				
				@RequestParam("cmmt_content") String cmmt_content, HttpSession session
				,
				@RequestParam(value="file",defaultValue="")
				MultipartFile filefile, HttpServletRequest request
				
				)
				throws ServletException, IOException, SQLException {

			String url = "redirect:cmmtList";

			String loginUser = (String) session.getAttribute("loginUser");

			CommunityVO cmmtVO = new CommunityVO();

			cmmtVO.setCmmt_title(cmmt_title);
			cmmtVO.setCmmt_content(cmmt_content);
			cmmtVO.setMbr_id(loginUser);
			

			//fileupload
			 session=request.getSession();
			String savaPath="resources/upload";
			ServletContext context=session.getServletContext();
			String uploadFilePath=context.getRealPath(savaPath);
			
			if(!filefile.isEmpty()){
				File file1=new File(uploadFilePath,System.currentTimeMillis()+filefile.getOriginalFilename());
				filefile.transferTo(file1);
				cmmtVO.setCmmt_pict_afat(file1.getName());
			}
			
			
			cmmtServiceImpl.insertCmmt(cmmtVO);
			
			return url;
		}

		@RequestMapping("/update")
		public String cmmtUpdate(HttpSession session, Model model, HttpServletRequest request)
				throws ServletException, IOException, SQLException {
			
			int cmmt_num = Integer.parseInt(request.getParameter("cmmt_num"));
			String url = "cmmt/cmmtUpdate";

			CommunityVO cmmtVO = cmmtServiceImpl.getCmmtDetail((cmmt_num));

			model.addAttribute("cmmtVO", cmmtVO);
			model.addAttribute(cmmt_num);

			return url;
		}

		@RequestMapping(value = "/cmmtUpdateForm", method = RequestMethod.POST)
		public String cmmtUpdateForm(@RequestParam("cmmt_num") int cmmt_num,
				@RequestParam("cmmt_title") String cmmt_title,
				@RequestParam("cmmt_content") String cmmt_content, Model model
				,
				HttpServletRequest request,
				@RequestParam("file")MultipartFile file,
				@RequestParam("nofile")String nofile,
				@RequestParam(value="cmmt_pict_afat",defaultValue="")String cmmt_pict_afat
				)
				throws ServletException, IOException, SQLException {

			String url = "redirect:cmmtList";

			CommunityVO cmmtVO = new CommunityVO();

			cmmtVO.setCmmt_title(cmmt_title);
			cmmtVO.setCmmt_content(cmmt_content);
			cmmtVO.setCmmt_num(cmmt_num);

			model.addAttribute(cmmt_num);

			

			HttpSession session = request.getSession();

			/////////////
			String savePath = "resources/upload";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);

			if (!file.isEmpty()) {
				File file1 = new File(uploadFilePath, System.currentTimeMillis() + file.getOriginalFilename());
				file.transferTo(file1);

				cmmtVO.setCmmt_pict_afat(file1.getName());
			} else {
				cmmtVO.setCmmt_pict_afat(nofile);
			}
			cmmtServiceImpl.updateCmmt(cmmtVO);

			
			return url;
		}

		
		//추가
		@RequestMapping(value="/search",method=RequestMethod.POST) // method=RequestMethod.GET | POST
		public String cmmtSearch(
				HttpServletRequest request, 
				Model model,
				HttpSession session) throws NumberFormatException, SQLException{
			
			
			
			
			// 공지사항 리스트 or 검색
			String search = request.getParameter("search"); // 공지사항 검색, null 일 경우 전체 리스트 가져옴, 초기값 null
			if(search==null || search.equals(""))
				search="";
			request.setAttribute("search", search);
			
			// 현재 페이지
			String tpage = request.getParameter("tpage"); // 처음에는 page 값 null
			if(tpage==null || tpage.equals(""))
				tpage="1";
			model.addAttribute("tpage",tpage);
			
			// 페이지 이동
			String paging = null; // 처음 접속할땐 null
			
			// Service, dao, db
			//String currentPage = "main";
			
			ArrayList<CommunityVO> cmmtList=null;
			cmmtList = cmmtDaoImpl.listAllCmmt(Integer.parseInt(tpage), search); // 공지사항 리스트(검색/검색안할때)
			paging = cmmtServiceImpl.pageNumber(Integer.parseInt(tpage), search); // 
			
			int cmmtListSize = 0;
			if(!(cmmtList.size()==0))
				cmmtListSize = cmmtList.size();
			request.setAttribute("cmmtListSize", cmmtListSize); 
			request.setAttribute("cmmtList", cmmtList);
			request.setAttribute("paging", paging);
			return "/cmmt/cmmtList";
		}
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
