package com.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.pojo.EasyUIDataGridResult;
import com.e3mall.service.ItemService;

@Controller
public class PageController {

	@Autowired
	private ItemService itemService;
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page){
		return page;
	}
	@RequestMapping("/item/list")
	public @ResponseBody
	EasyUIDataGridResult getItemList(Integer page,Integer rows){
		System.out.println(111);
		return itemService.getItemList(page, rows);
	}
}
