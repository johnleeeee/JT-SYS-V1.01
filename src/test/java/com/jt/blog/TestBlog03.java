package com.jt.blog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

public class TestBlog03 {
	/*优先于test执行*/
	SqlSessionFactory factory = null;
	@Before
	public void init() throws IOException{
		factory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-configs.xml"));
	}
	
	@Test
	public void testFindPageObject(){
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startIndex", 2);
		map.put("pageIndex", 2);
		/*List<Map<String, Object>> selectList = session
				.selectList("com.jt.blog.BlogDao.findPageBlogs", new int[]{2,2});*/
		List<Map<String, Object>> selectList = session
				.selectList("com.jt.blog.BlogDao.findPageBlogs", map);
		System.out.println(selectList);
		session.close();
		
	}
	/**
	 * 事务
	 */
	/*@Test
	public void testInsertObject01(){
		SqlSession session = factory.openSession();
		Blog blog = new Blog();
		blog.setTitle("title-a");
		blog.setContent("content-a");
		int rows = session.insert("com.jt.blog.BlogDao.insertObject01", blog);
		System.out.println(rows);
		//提交事务
		session.commit();//建议手动提交事务
		session.close();
	}*/
	
	@Test
	public void testUpdateObject02(){
		SqlSession session = factory.openSession();
		
		Map<String, Object> map = session.selectOne("com.jt.blog.BlogDao.findBlogById", 1);
		//Blog blog = new Blog(1,"title-a","content-a");
		map.put("title", "title_wwwwwwwwww");
		/*blog.setId(1);
		blog.setTitle("title-a");
		blog.setContent("content-a");*/
		int rows = session.insert("com.jt.blog.BlogDao.updateObject02", map);
		System.out.println(rows);
		//提交事务
		session.commit();//建议手动提交事务
		session.close();
	}
	
	@Test
	public void testUpdateObject03(){
		SqlSession session = factory.openSession();
		List<String> list = new ArrayList<String>();
		list.add("title-b");
		list.add("content-b");
		list.add("1");
		//Blog blog = new Blog(1,"title-a","content-a");
		
		/*blog.setId(1);
		blog.setTitle("title-a");
		blog.setContent("content-a");*/
		int rows = session.insert("com.jt.blog.BlogDao.updateObject03", list);
		System.out.println(rows);
		//提交事务
		session.commit();//建议手动提交事务
		session.close();
	}
	
	@Test
	public void testDeleteObject(){
		SqlSession session = factory.openSession();
		int rows = session.delete("com.jt.blog.BlogDao.deleteObject", 5);
		System.out.println(rows);
		session.commit();
		session.close();
	}
}
