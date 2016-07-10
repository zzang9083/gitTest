package com.naver.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naver.bo.urlBO;
import com.naver.dao.urlDAO;

@Service
public class urlBOImpl implements urlBO{
	
	@Autowired
	private urlDAO urlDAO;
	
	public int urlAdd(String REAL_URL, String SHORT_URL)
	{
		return urlDAO.urlAdd(REAL_URL,SHORT_URL);	
	}
	
	

}
