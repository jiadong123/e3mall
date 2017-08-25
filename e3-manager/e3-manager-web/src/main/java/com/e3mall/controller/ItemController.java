package com.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.pojo.TbItem;
import com.e3mall.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	public ItemService itemService;
	
	@RequestMapping("item/{itemId}")
	public @ResponseBody TbItem findItemById(@PathVariable Long itemId){
		return itemService.findItemById(itemId);
	}
}
