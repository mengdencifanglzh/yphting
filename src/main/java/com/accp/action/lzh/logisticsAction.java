package com.accp.action.lzh;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.lzh.logisticsBiz;
import com.accp.pojo.Logistics;
import com.accp.pojo.Sharea;
import com.accp.util.file.Upload;
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
	@GetMapping("getShareaState")
	public List<Sharea> getShareaState(){
		return biz.getShareaState();
	}
	@GetMapping("getKoreaCity/{state}")
	public List<Sharea> getKoreaCity(@PathVariable String state){
		return biz.getKoreaCity(state);
	}
	@GetMapping("getChinaCity/{state}")
	public List<Sharea> getChinaCity(@PathVariable String state){
		return biz.getChinaCity(state);
	}
	@GetMapping("getChinaArea/{city}")
	public List<Sharea> getChinaArea(@PathVariable String city){
		return biz.getChinaArea(city);
	}
	@GetMapping("getKoreaArea/{city}")
	public List<Sharea> getKoreaArea(@PathVariable String city){
		return biz.getKoreaArea(city);
	}
	@RequestMapping(value="addLogis",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addLogistics(@RequestBody Logistics logis){
		biz.addLogistics(logis);
		Map<String, String> message = new HashMap<String, String>();
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	@PutMapping("updateCollectAdds/{collectGoods}/{collectGoodsPhone}/{collectGoodsAddr}/{orderID}")
	public Map<String,String> updateCollectAdds(@PathVariable String collectGoods,@PathVariable String collectGoodsPhone,@PathVariable String collectGoodsAddr,@PathVariable String orderID) {
		biz.updateCollectAdds(collectGoods, collectGoodsPhone, collectGoodsAddr, orderID);
		Map<String, String> message = new HashMap<String, String>();
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	@GetMapping("getUpdateAdds/{orderID}")
	public Logistics getUpdateAdds(@PathVariable String orderID) {
		return biz.getUpdateAdds(orderID);
	}
	@PostMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		if (!file.isEmpty()) {
			try {
				String url = Upload.saveFile(file);// 返回值直接用
				System.out.println(url);
				model.addAttribute("message", "上传成功，访问路径：" + url);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				model.addAttribute("message", "上传失败");
			}
		} else {
			model.addAttribute("message", "文件为空");
		}
		return null;
		
	}
}
