package com.accp.dao.lzh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Logistics;
import com.accp.vo.lzh.logisticsVO;

public interface logisticsDao {
	public List<logisticsVO> querylogisticsInit(@Param("userID")Integer userID);
	public List<logisticsVO> querylogisticsLike(@Param("userID")Integer userID,@Param("like") String like);
	public Logistics querylogisticsDetail(@Param("userID")Integer userID,@Param("orderID")String orderID);
}
