package com.accp.action.lzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.lzh.logisticsBiz;
import com.accp.pojo.Logistics;
import com.accp.util.file.Upload;

@Controller
@RequestMapping("/lzh/api/add")
public class logisticsAddAction {
	@Autowired
	private logisticsBiz biz;
	@RequestMapping(value="addLogis",method=RequestMethod.POST)
	public String addLogistics( MultipartFile file, Logistics logis) throws Exception{
		if (!file.isEmpty()) {
			String url = Upload.saveFile(file);
			logis.setImg1(url);
			biz.addLogistics(logis);
		}
		return "redirect:/lzh/api/ZhiFu/querydingdan?userid=1001&logisticsID="+logis.getOrderid();
	}
}
