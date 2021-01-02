package com.dongns.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongns.mp.entity.User;
import com.dongns.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelectList()
    {
        System.out.println("======================查询测试==============================");
        List<User> userList=userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    public void testadd()
    {
        System.out.println("======================新增测试==============================");
        User user=new User();
        user.setName("东岸四");
        user.setAge(123);
        user.setEmail("15867739440@qq.com");

        int result = userMapper.insert(user);
        System.out.println("新增结果："+result);
    }

    @Test
    public void testUpdate()
    {
        System.out.println("----更新测试");
        User user=new User();
        user.setId(1L);
        user.setName("时晴");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testdelete()
    {
        System.out.println("删除测试");
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("id",2L);
        int i = userMapper.delete(wrapper);
        System.out.println(i);
    }


    @Test
    public void testPage()
    {
        Page<User>page=new Page<>(1,5);
        IPage<Map<String,Object>> mapIPage=userMapper.selectMapsPage(page,null);

        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
    }

}
