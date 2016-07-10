package com.naver.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naver.dao.urlDAO;
import com.naver.mapper.urlMapper;

@Component
public class urlDAOImpl implements urlDAO {
	    @Autowired
	    private SqlSession sqlSession;

		public int urlAdd(String REAL_URL, String SHORT_URL) {
			int result;
			urlMapper urlMapper = sqlSession.getMapper(urlMapper.class);
			result=urlMapper.urlAdd(REAL_URL,SHORT_URL);
					
			return result;
		}


}
