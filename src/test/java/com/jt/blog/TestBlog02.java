package com.jt.blog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestBlog02 {
	
	@Test
	public void testFindBlogById01() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///cgbmybatis","root","root");
		PreparedStatement stmt = conn.prepareStatement("select * from blog");
		ResultSet rs = stmt.executeQuery();
		//rs.absolute(2);
		ResultSetMetaData metaData = rs.getMetaData();
		int cCount = metaData.getColumnCount();
		
		for(int i=1;i<=cCount;i++){
			//System.out.println(metaData.getColumnName(i));
			//System.out.println(metaData.getCatalogName(i));
			System.out.println(metaData.getColumnTypeName(i));
		}
		Map<String, Object> maps = null;
		while(rs.next()){
			maps = new HashMap<String, Object>();
			for(int i=1;i<=cCount;i++){
				maps.put(metaData.getColumnName(i), rs.getString(i));
			}
			System.out.println(maps);
		}
	}
	
	@Test
	public void testFindBlogById02() throws IOException{
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
		.build(Resources.getResourceAsStream("mybatis-configs.xml"));
		SqlSession session = factory.openSession();
		Map<String, Object> map = session.selectOne("com.jt.blog.BlogDao.findBlogById",new int[]{1});
		System.out.println(map);
		session.close();
	}
}
