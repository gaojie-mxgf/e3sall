package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	/**
	 * 根据id查询客户
	 */
	@Override
	public TbItem getItemById(long id) {
		return itemMapper.selectByPrimaryKey(id);
	}
	/*
	 * 查询商品列表
	 * (non-Javadoc)
	 * @see cn.e3mall.service.ItemService#getItemList(int, int)
	 */
	@Override
	public DataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询结果
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页结果
		PageInfo<TbItem> info = new PageInfo<>(list);
		//把结果封装到DataGridResult对象中
		DataGridResult result = new DataGridResult();
		result.setTotal(info.getTotal());
		result.setRows(list);
		//返回结果
		return result;
	}

}
