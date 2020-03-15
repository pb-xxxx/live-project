package dao;

import java.util.List;
import pojo.User;
public interface UserDAO {
    boolean isDb(User user);//查询数据库判断是否可预约
    boolean isList(User user,List<User> users);//查询预约列表判断是否可预约
    List<User> addList(User user,List<User> users);//把用户添加进列表，预约成功set置1
    List<User> select(List<User> users);//选出中签的用户列表
    boolean add(List<User> users);//把中签的用户添加进数据库
    void end();//数据库里order-1；
    boolean isMatch(int id);//查询是否中奖
}
