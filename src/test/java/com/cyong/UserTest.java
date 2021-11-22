package com.cyong;


import com.cyong.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong
 * @Author: cyong
 * @CreateTime: 2021-11-22 12:16
 * @Description: 用户相关的单元测试
 */

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //按照指定方法运行
public class UserTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Test
    public void test0() throws SQLException
    {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void test1(){
            userService.findUserByPhone("15039774090");
    }
}
