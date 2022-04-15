package com.campus.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping("/ajaxView")
	public String ajaxView() {
		return "ajax/ajaxView";
	}
	
	@RequestMapping(value="/ajaxString", method=RequestMethod.GET, produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajaxString(int num, String name, String addr) {
		System.out.println("num->" + num);
		System.out.println("name->" + name);
		System.out.println("addr->" + addr);
		
		String data = "번호 : " + num + "<br>이름 : " + name + "<br>주소 : " + addr;
		
		return data;
	}
	
	@RequestMapping("/ajaxObject")
	@ResponseBody
	public ProductVO ajaxObject(int num, String name) {
		System.out.println(num + "=====" + name);
		
		// ProductVO에 데이터를 담아서 ajax에게 보내기
		return new ProductVO(1234, "컴퓨터", 1200000 ,13);
	}
	
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<ProductVO> ajaxList() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		list.add(new ProductVO(100, "책상", 120000, 2));
		list.add(new ProductVO(200, "의자", 50000, 4));
		list.add(new ProductVO(300, "핸드폰", 500000, 5));
		list.add(new ProductVO(400, "TV", 1500000, 1));
		list.add(new ProductVO(500, "냉장고", 30000000, 3));
		
		return list;
	}
	
	// Map
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public HashMap<String, ProductVO> ajaxMap() {
		HashMap<String, ProductVO> map = new HashMap<String, ProductVO>();
		
		map.put("p1", new ProductVO(100, "책상2", 120000, 2));
		map.put("p2", new ProductVO(200, "의자2", 50000, 4));
		map.put("p3", new ProductVO(300, "핸드폰2", 500000, 5));
		map.put("p4", new ProductVO(400, "TV2", 1500000, 1));
		map.put("p5", new ProductVO(500, "냉장고2", 30000000, 3));
		
		return map;
	}
	
	@RequestMapping(value="/ajaxJson", method=RequestMethod.GET, produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajaxJson(int no, String name, String tel) {
		System.out.println(no + ">>>" + name + ">>>>>" + tel);
		
		int proNo = 1234;
		String proName = "냉장고";
		int price = 1432000;
		
		String txt = "{\"proNo\":\"" + proNo + "\", \"proName\":\"" + proName + "\", \"price\":\"" + price + "\"}";
		System.out.println(txt);
		return txt;
	}
	
	@RequestMapping(value="/ajaxForm", method=RequestMethod.POST)
	@ResponseBody
	public String ajaxForm(String proName, int price) {
		System.out.println(proName);
		System.out.println(price);
		
		return "Ok";
	}
	
	
	
	
}
