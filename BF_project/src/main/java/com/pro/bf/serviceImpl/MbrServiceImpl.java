package com.pro.bf.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.bf.dao.MbrDao;
import com.pro.bf.dao.QnADao;
import com.pro.bf.daoImpl.MbrDaoImpl;
import com.pro.bf.dto.MbrVO;
import com.pro.bf.dto.QnAVO;
import com.pro.bf.service.MbrService;

@Service
public class MbrServiceImpl implements MbrService {

	@Autowired
	private MbrDaoImpl mbrDao;

	public void setMbrDAO(MbrDaoImpl mbrDao) {
		this.mbrDao = mbrDao;
	}

	@Autowired
	private QnADao qnaDAO;

	public void setQnaDAO(QnADao qnaDAO) {
		this.qnaDAO = qnaDAO;
	}

	@Autowired
	private MbrDao mbrDAO;

	public void setMbrDAO(MbrDao mbrDAO) {
		this.mbrDAO = mbrDAO;
	}

	@Override
	public void insertMember(MbrVO mbrVo) throws SQLException { // 회원가입
		mbrDao.insertMember(mbrVo);
	}

	@Override
	public String idCheck(String idcheck) throws SQLException { // 아이디 중복확인
		String data = mbrDao.idCheck(idcheck);
		System.out.println("3 리턴받은 아이디 값(Service) " + data);
		return data;
	}

	@Override
	public String login(MbrVO mbrVo) throws SQLException { // 로그인
		String login = mbrDao.login(mbrVo);
		return login;
	}

	@Override
	public String searchUserName(String login) throws SQLException { // 로그인한 유저
																		// 이름 찾기
		String loginUserName = mbrDao.searchUserName(login);
		return loginUserName;
	}

	@Override
	public String searchUserId(MbrVO mbrVo) throws SQLException { // 아이디 찾기
		String id = mbrDao.searchUserId(mbrVo);
		return id;
	}

	@Override
	public Map searchUserPwd(MbrVO mbrVo) throws SQLException { // 비밀번호 찾기 /
																// 이메일도 같이 찾아야함
		MbrVO result = mbrDao.searchUserPwd(mbrVo);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		try {
			String pwd = result.getMbr_pwd();
			String email = result.getMbr_eml();
			searchMap.put("pwd", pwd);
			searchMap.put("email", email);
		} catch (NullPointerException e) {
			searchMap.put("pwd", "not Information");
		}
		return searchMap;
	}

	@Override
	public ArrayList<QnAVO> getQnaList(String mbr_id) throws SQLException {
		ArrayList<QnAVO> qnaList = null;
		try {
			qnaList = qnaDAO.listQna(mbr_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaList;
	}

	@Override
	public QnAVO getQnaVO(int qna_num) throws SQLException {
		QnAVO qnaVO = new QnAVO();
		try {
			qnaVO = qnaDAO.getQna(qna_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaVO;
	}

	@Override
	public void insertQna(QnAVO qnaVO, String mbr_id) throws SQLException {
		try {
			qnaDAO.insertQna(qnaVO, mbr_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}