package top.smartliu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.smartliu.config.SpringConfig;
import top.smartliu.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用配置文件的方式；括号内写入字符串，相当于 (value: "classpath:applicationContext.xml")
// @ContextConfiguration("classpath:applicationContext.xml")
// 使用配置类的方式
@ContextConfiguration(classes = {SpringConfig.class})
public class SpringJunitTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testBookService() {
        bookService.save();
    }
}
