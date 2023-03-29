package top.smartliu.dataPool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void testDruid() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/school");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        DruidPooledConnection connection = druidDataSource.getConnection();

        System.out.println(connection);
        connection.close();
    }
}
