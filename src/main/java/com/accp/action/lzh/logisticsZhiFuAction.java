package com.accp.action.lzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.biz.lzh.logisticsBiz;
import com.accp.pojo.Logistics;
import com.accp.pojo.User;

@Controller
@RequestMapping("/lzh/api/ZhiFu")
public class logisticsZhiFuAction {
	@Autowired
	private logisticsBiz biz;
	@GetMapping("querydingdan")
	public String getList(String logisticsID,int userid, Model model) {
		Logistics pageInfo= biz.querydingdan(logisticsID);
		model.addAttribute("PAGE_INFO",pageInfo);
		User pageInfo1= biz.queryjinbi(userid);
		model.addAttribute("PAGE_INFO1",pageInfo1);
		return "fukuan";
	}
}
