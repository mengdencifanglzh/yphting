package com.accp.biz.lzh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lzh.logisticsDao;
import com.accp.pojo.Logistics;
import com.accp.pojo.Sharea;
import com.accp.vo.lzh.logisticsVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)

/**
 * 修改替换@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
 * */
public class logisticsBiz {
	
	@Autowired
	private logisticsDao dao;
	
	public PageInfo<logisticsVO> getlogisticsInit(Integer userID,Integer pageNum, Integer pageSize){
		//System.out.println("JSON.toJSONString(dao.querylogisticsInit(userID)"+JSON.toJSONString(dao.querylogisticsInit(userID)));
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<logisticsVO>(dao.querylogisticsInit(userID));
	}
	public PageInfo<logisticsVO>getlogisticsLike(Integer userID,String like,Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<logisticsVO>(dao.querylogisticsLike(userID, like));
	}
	public Logistics getlogisticsDetail(Integer userID,String orderID) {
		return dao.querylogisticsDetail(userID, orderID);
	}
	public List<Sharea> getShareaState(){
		return dao.queryShareaState();
	}
	public List<Sharea> getKoreaCity(String state){
		return dao.queryKoreaCity(state);
	}
	public List<Sharea> getChinaCity(String state){
		return dao.queryChinaCity(state);
	}
	public List<Sharea> getChinaArea(String city){
		return dao.queryChinaArea(city);
	}
	public List<Sharea> getKoreaArea(String city){
		return dao.queryKoreaArea(city);
	}
	public void addLogistics(Logistics logis) {
		dao.addLogistics(logis);
	}
}
