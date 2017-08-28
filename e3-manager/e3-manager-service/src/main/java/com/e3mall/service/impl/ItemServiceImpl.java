package com.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	public TbItemMapper tbItemMapper;
	@Override
	public TbItem findItemById(Long id) {
		
		/*TbItem item = tbItemMapper.selectByPrimaryKey(id);*/
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItem> item = tbItemMapper.selectByExample(example);
		if(item!=null&&item.size()>0){
			return item.get(0);
		}
		return null;
	}
	public EasyUIDataGridResult getItemList(int start,int size){
		PageHelper.startPage(start, size);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> info = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(info.getTotal());
		result.setRows(list);
		return result;
		
	}

}
