package top.smartliu.dataPool;

import org.junit.Test;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void testSpringDruid() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 支持使用类名获取 bean
        // DataSource dataSource = applicationContext.getBean(DataSource.class);
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
        connection.close();
    }

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
