package demo.crud.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	static
	{
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("config/mybatis-config.xml");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
		
		//very import, otherwise we my batis will not consider the class as a Mapper: Used only if we do not use any mapper class
		// factory.getConfiguration().addMapper(UserMapper.class);
	}
 
	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}
