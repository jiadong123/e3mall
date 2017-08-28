package com.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemCatMapper;
import com.e3mall.pojo.EasyUITreeNode;
import com.e3mall.pojo.TbItemCat;
import com.e3mall.pojo.TbItemCatExample;
import com.e3mall.pojo.TbItemCatExample.Criteria;
import com.e3mall.service.TbItemCatService;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	public List<EasyUITreeNode> getCatList(Long id) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		List<EasyUITreeNode> lists = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			lists.add(node);
		}
		return lists;
	}

}
