package cn.e3mall.PageHelperDemo;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {

	@Test
	public void testPageHelper() {
		//初始化spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-dao.xml");
		//从容器中获取对象
		TbItemMapper mapper = context.getBean(TbItemMapper.class);
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(0, 10);
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> selectByExample = mapper.selectByExample(tbItemExample);
		PageInfo<TbItem> pageInfo = new PageInfo<>(selectByExample);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(selectByExample.size());		
	}
	
}
