package com.e3mall.service;

import java.util.List;

import com.e3mall.pojo.EasyUITreeNode;
import com.e3mall.pojo.TbItemCat;

public interface TbItemCatService {

	public List<EasyUITreeNode> getCatList(Long id);
		
	
}
