package dao;

import java.util.List;
import pojo.User;
public interface UserDAO {
    boolean isDb(User user);//查询数据库判断是否可预约
    boolean isList(User user,List<User> users);//查询预约列表判断是否可预约
    void addList(User user,List<User> users);//把用户添加进列表,设置编号，预约成功set置1
    List<User> select(List<User> users,int nums);//选出中签的用户列表,nums为口罩总量;
    boolean add(List<User> users);//把中签的用户添加进数据库
    void end();//数据库里order-1；
    boolean isMatch(int id,List<User> users);//输入id与中奖名单查询是否中奖
}
