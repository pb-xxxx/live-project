package dao;

import pojo.User;
import java.sql.*;
import java.util.*;
import java.lang.String;
public class Impl implements UserDAO {
    public boolean isDb(User user)//查询数据库判断是否可预约
    {

    }
    public boolean isList(User user,List<User> users)//查询预约列表判断是否可预约
    {
        for(User User:users)
        {
            if(user.getID().equals(User.getID())||user.getTel().equals(User.getTel()))
                return false;
        }
        return true;
    }
    public void addList(User user,List<User> users)//把用户添加进列表，设置编号预约成功set置1
    {
        users.add(user);
        user.setSet();
        user.setId(users.size());
    }
    public List<User> select(List<User> users,int nums)//选出中签的用户列表
    {
        int num = 0;
        int size = users.size();
        Random ran = new Random();
        HashSet<User> hash = new HashSet<>();
        List<User> userList = new ArrayList<>();
        for(int i=0;;i++)
        {
            int id = ran.nextInt(size);
            if((users.get(id).getNum()+num) > nums)
                break;
            else
            {
                hash.add(users.get(id));
                num = num+users.get(id).getNum();
            }
        }
        userList.addAll(hash);
        return userList;
    }
    public boolean add(List<User> users)//把中签的用户添加进数据库
    {

    }
    public void end()//数据库里order-1；
    {

    }
    public boolean isMatch(int id)//查询是否中奖
    {

    }
}
