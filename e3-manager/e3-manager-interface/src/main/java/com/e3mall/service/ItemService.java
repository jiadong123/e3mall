package com.e3mall.service;

import com.e3mall.pojo.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;

public interface ItemService {

	public TbItem findItemById(Long id);
	public EasyUIDataGridResult getItemList(int start,int size);
}
