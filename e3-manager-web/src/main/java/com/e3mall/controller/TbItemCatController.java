package com.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.pojo.EasyUITreeNode;
import com.e3mall.service.TbItemCatService;

@Controller
public class TbItemCatController {

	@Autowired
	private TbItemCatService tbItemCatService;
	@RequestMapping("item/cat/list")
	public @ResponseBody
	List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		return tbItemCatService.getCatList(parentId);
	}
}
