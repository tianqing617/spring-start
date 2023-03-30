package top.smartliu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 标志该类是Spring的核心配置类
@Configuration
// <context:component-scan base-package="top.smartliu"/>
@ComponentScan("top.smartliu")
// Spring中注入数据库配置
@Import({DataSourceConfig.class})
public class SpringConfig {
}
