package com.HotelManagement.service.user;

import com.HotelManagement.dao.user.UserMapper;
import com.HotelManagement.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelManagement.pojo.Role;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userCode, String password) {

        User user = userMapper.getUserByUserCode(userCode);

        if (user != null && !user.getUserPassword().equals(password)) {
            user = null;
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int getUserRole(String userCode) {
        return this.userMapper.getUserRole(userCode);
    }

    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(String userName, Integer userRole) {
        return this.userMapper.getUserList(userName,userRole);

    }

    //获得角色列表
    public List<Role> getRoleList() {
        return   this.userMapper.getRoleList();

    }

    public  int deleteUserByUserCode( String userCode){
        return  this.userMapper.deleteUserByUserCode(userCode);
    }
}
