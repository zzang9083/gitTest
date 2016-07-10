package com.naver.mapper;

import org.apache.ibatis.annotations.Param;

public interface urlMapper {

	int urlAdd(@Param("real_url")String REAL_URL, @Param("short_url")String SHORT_URL);
		
}
