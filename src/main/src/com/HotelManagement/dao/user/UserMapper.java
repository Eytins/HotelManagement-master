package com.HotelManagement.dao.user;

import com.HotelManagement.pojo.User;
import org.apache.ibatis.annotations.Param;

import com.HotelManagement.pojo.Role;
import java.util.List;

public interface UserMapper {

    // 根据用户名获得用户（进行登陆）
    User getUserByUserCode(@Param("userCode") String userCode);

    //注册用户
    int addUser(User user);

    //检测用户类别
    int getUserRole(@Param("userCode") String userCode);

    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole);

    //获得角色列表
    public List<Role> getRoleList();

    public int deleteUserByUserCode(@Param("userCode") String userCode);
}
