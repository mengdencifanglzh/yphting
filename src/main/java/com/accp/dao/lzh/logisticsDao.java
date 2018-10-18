package com.accp.dao.lzh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Logistics;
import com.accp.pojo.Sharea;
import com.accp.vo.lzh.logisticsVO;

public interface logisticsDao {
	public List<logisticsVO> querylogisticsInit(@Param("userID")Integer userID);
	public List<logisticsVO> querylogisticsLike(@Param("userID")Integer userID,@Param("like") String like);
	public Logistics querylogisticsDetail(@Param("userID")Integer userID,@Param("orderID")String orderID);
	//发物流下拉查询
	public List<Sharea> queryShareaState();
	//查询韩国》省市
	public List<Sharea> queryKoreaCity(@Param("state")String state);
	//查询中国》省
	public List<Sharea> queryChinaCity(@Param("state")String state);
	//查询省————》市
	public List<Sharea> queryArea(@Param("city") String city);
}
