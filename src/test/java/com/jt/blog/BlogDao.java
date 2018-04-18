package com.jt.blog;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class BlogDao {
	private SqlSessionFactory factory;
	
	@Before
	public void init()throws IOException{
			//初始化SqlSessionFactory
			factory=new SqlSessionFactoryBuilder()
			.build(Resources.getResourceAsStream(
					"mybatis-configs.xml"));
	}
	
	@Test
	public void testFindBlogs(){
		//1.创建SqlSession对象(相当于创建一个连接)
		SqlSession session=factory.openSession();
		//2.执行查询操作(selectList("命名空间"+"元素id"))
		List<Object> list=session.selectList(
		"com.jt.blog.BlogDao.findBlogs");
		for(Object o:list){
		System.out.println(o);
		}
		//3.释放资源(类似关闭连接)
		session.close();
	}
	
	@Test
	public void testFindBlogById(){
		//1.创建session对象
		SqlSession session=
		factory.openSession();
		//2.执行sql操作
		String statement="com.jt.blog.BlogDao.findBlogById";
		Map<String,Object> map=
		session.selectOne(statement,1);
		System.out.println(map);
		//3.释放资源(关闭session对象)
		session.close();
	}

	@Test
	public void testFindPageBlogs(){
			//1.创建session对象
			SqlSession session=
			factory.openSession();
			//2.执行sql操作?????
			String statement="com.jt.blog.BlogDao.findPageBlogs";
			Object parameter=new Object[]{0,4};
			List<Map<?,?>> list=
			session.selectList(statement, parameter);
			for(Map<?,?>map:list){
				System.out.println(map);
			}
			//3.释放资源(关闭session对象)
		    session.close();
		};

		@Test
		public void testInsertObject(){
				//1.创建session
				SqlSession session=factory.openSession();
				//2.执行sql
				String statement="com.jt.blog.BlogDao.insertObject";
				Object parameter=new Object[]{"te","te..."};
				int rows=session.insert(statement, parameter);
				System.out.println("insert.rows="+rows);
				session.commit();
				//3.关闭session
				session.close();
			}

		@Test
		public void testUpdateObject(){
				//1.创建session
				SqlSession session=factory.openSession();
				//2.执行sql
				String statement="com.jt.blog.BlogDao.updateObject";
				Object parameter=new Object[]{"taa","taa...",1};
				int rows=session.update(statement, parameter);
				System.out.println("update.rows="+rows);
				session.commit();
				//3.关闭session
				session.close();
			}

		@Test
		public void testDeleteObject(){
			//1.创建session
			SqlSession session=factory.openSession();
			//2.执行sql
			String statement="com.jt.blog.BlogDao.deleteObject";
			Object parameter=7;
			int rows=session.delete(statement, parameter);
			session.commit();
			System.out.println("delete.rows="+rows);
			//3.关闭session
			session.close();
		}



}
