package dao;


import pojo.User;
import java.sql.*;
import java.util.*;
import util.DBUtil;

import java.lang.String;
public class Impl implements UserDAO {
    public boolean isDb(User user)//查询数据库判断是否可预约
    {
    	String IDsql = "select * from user  where ID = ?";
    	String telsql = "select * from user where tel = ?"; 
    	ResultSet IDrs = null;
    	ResultSet telrs = null;
    	int flag = 0 ;
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(IDsql);) {
            ps.setString(1, user.getID());
            IDrs = ps.executeQuery();
            if (IDrs.next()) {
              flag = 1;
            } 
            else {
              flag = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(telsql)) {
            ps.setString(1, user.getTel());
            telrs = ps.executeQuery();
            if (telrs.next()) {
              flag = 1;
            } 
            else {
              flag = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(IDrs,null, null);
        DBUtil.close(telrs,null, null);
        if(flag==1) {
        	return false;
        }
        else {
			return true;
		}
    }

    public void addList(User user,List<User> users)//把用户添加进列表，设置编号预约成功set置1
    {
        users.add(user);
        user.setSet();
        user.setId(users.size());
    }
    public boolean isList(User user,List<User> users)//查询预约列表判断是否可预约
    {
        for(User Users:users)
        {
            if(user.getID().equals(Users.getID())||user.getTel().equals(Users.getTel())||Users.getSet()==1)
                return false;
        }
        return true;
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
                users.get(id).setOrder();
                num = num+users.get(id).getNum();
            }
        }
        userList.addAll(hash);
        return userList;
    }
    public void add(List<User> users)//把中签的用户添加进数据库
    {
    	String sql = "insert into user values(?,?,?,?,?)"; 	
    	for(User user:users)
        {
    		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
    			ps.setString(1,user.getID());
    			ps.setString(2,user.getTel());
    			ps.setInt(3, user.getNum());
    			ps.setString(4,user.getTel());
    			ps.setInt(5, user.getOrder());
    			ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
    }
    public void end()//数据库里order-1；
    {
    	String sql1 = "select * from user ";
    	String sql2 = "update user set order = ? where ID=?";
        String sql3 = "delete from user where order = 0 ";
		ResultSet rs = null;
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql1);) {
        	rs = ps.executeQuery();
		    while(rs.next()) { 	
		        int orderNum = rs.getInt("order");
		        String ID = rs.getString("ID");
		        orderNum--;
		        try (Connection c1 = DBUtil.getConnection(); PreparedStatement ps1 = c1.prepareStatement(sql2);) {
		        	ps1.setInt(1, orderNum);
		        	ps1.setString(2, ID);			   
				    ps1.execute();                     									
				     }
		         catch (SQLException e) {
		            e.printStackTrace();
		        }          									
		     }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection c2 = DBUtil.getConnection(); Statement ps2 = c2.createStatement();) {    			   
		    ps2.executeUpdate(sql3);                     									
		     }
         catch (SQLException e) {
            e.printStackTrace();
        }          									

    }
    public boolean isMatch(int id,List<User> users)//查询是否中奖
    {
        for(User user:users)
        {
            if(user.getId()==id)
                return true;
        }
        return false;
    }
}
