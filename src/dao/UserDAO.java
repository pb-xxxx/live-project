package dao;

import java.util.List;
import pojo.User;
public interface UserDAO {
    boolean add(User user);//添加进数据库
    void setzero(List<User> users);//预约结束后将set置0
    List<User> select(List<User> users);//返回中签的用户列表
    List<User> list();//返回本轮预约成功的用户列表
    boolean isMatch(int id);//查询是否中奖
}
