package top.smartliu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.smartliu.config.SpringConfig;
import top.smartliu.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SpringJunitTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testBookService() {
        bookService.save();
    }
}
