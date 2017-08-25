package com.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;

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

}
