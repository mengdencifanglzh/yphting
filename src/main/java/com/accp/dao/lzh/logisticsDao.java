package com.accp.dao.lzh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Logistics;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
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
	//查询省————》市(中国)
	public List<Sharea> queryChinaArea(@Param("city") String city);
	//查询省————》市(韩国)
	public List<Sharea> queryKoreaArea(@Param("city") String city);
	//发物流
	public void addLogistics(@Param("logis")Logistics logis);
	//修改收货信息
	public void updateCollectAdds(@Param("collectGoods")String collectGoods,@Param("collectGoodsPhone")String collectGoodsPhone,@Param("collectGoodsAddr")String collectGoodsAddr,@Param("orderID")String orderID);
	//修改查询
	public Logistics queryUpdateAdds(@Param("orderID")String orderID);

	 public User queryjinbi(@Param("userid") int userid);
	 public Logistics querydingdan(@Param("logisticsID") String logisticsID);
	 public int updatejb (@Param("id") Float id,@Param("userid") int userid);
	 public int updatezt (@Param("logisticsID") int logisticsID);
}
