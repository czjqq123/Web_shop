package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {

	private static DataSource ds = new ComboPooledDataSource();	//使用c3p0的数据源
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws Exception {
		return ds.getConnection();
	}
}
