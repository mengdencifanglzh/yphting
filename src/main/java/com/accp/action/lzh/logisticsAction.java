package com.accp.action.lzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.lzh.logisticsBiz;
import com.accp.pojo.Logistics;
import com.accp.vo.lzh.logisticsVO;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/lzh/api")
public class logisticsAction {
	@Autowired
	private logisticsBiz biz;
	@GetMapping("getlogisticsInit/{userID}/{pageNum}/{pageSize}")
	public PageInfo<logisticsVO> getlogisticsInit(@PathVariable Integer userID,@PathVariable Integer pageNum,@PathVariable Integer pageSize){
		System.out.println(JSON.toJSONString(biz.getlogisticsInit(userID, pageNum, pageSize)));
		return biz.getlogisticsInit(userID, pageNum, pageSize);
	}
	@GetMapping("getlogisticsLike/{userID}/{like}/{pageNum}/{pageSize}")
	public PageInfo<logisticsVO> getlogisticsLike(@PathVariable Integer userID,@PathVariable String like,@PathVariable Integer pageNum,@PathVariable Integer pageSize){
		return biz.getlogisticsLike(userID, like, pageNum, pageSize);
	}
	@GetMapping("getlogisticsDetail/{userID}/{orderID}")
	public Logistics getlogisticsDetail(@PathVariable Integer userID,@PathVariable String orderID) {
		return biz.getlogisticsDetail(userID, orderID);
	}
}
