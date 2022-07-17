package com.cyong;


import com.cyong.dao.BlogMapper;
import com.cyong.dao.CategoryMapper;
import com.cyong.dao.TagMapper;
import com.cyong.model.Category;
import com.cyong.model.User;
import com.cyong.service.UserService;
import com.cyong.utils.DataMap;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private DataSource dataSource;

    @Resource
    private UserService userService;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private TagMapper tagMapper;


    @Resource
    private CategoryMapper categoryMapper;

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

    @Test
    public void test2(){
        User caicai = userService.findUserByUsername("caicai");
        System.out.println(caicai);
    }

    @Test
    public void test3(){
        List<Map<String, Object>> maps = blogMapper.articleVagueSearch("", -1,  null, null, null, null, null, null);

        System.out.println(maps);
    }

    @Test
    public void test4(){
        List<String> commentStatusList= new ArrayList<String>();
        System.out.println(commentStatusList);
    }

    @Test
    public void test5(){
        int i = userService.countUserNum();
        System.out.println(i+"countUserNumcountUserNumcountUserNum");
    }

    @Test
    public void test6(){
        List<Map<String, Object>> maps = tagMapper.tagFollowsArticle();
        System.out.println(maps+"tagFollowsArticletagFollowsArticle");
    }

    @Test
    public void test7(){
        List<Map<String, Object>> maps = categoryMapper.categoryFollowsArticle();
        System.out.println(maps+"categoryFollowsArticlecategoryFollowsArticle");
    }

    @Test
    public void test8(){
        List<Map<String, Object>> calendarMaps = blogMapper.calendarArticle("2022");
        System.out.println(calendarMaps+"calendarArticlecalendarArticle");
    }
}
