package com.HotelManagement.controller.userController;


import com.HotelManagement.pojo.HotelType;
import com.HotelManagement.pojo.User;
import com.HotelManagement.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("userlist")
public class UserListController {
    private static final Logger logger = Logger.getLogger(UserListController.class);

    @Autowired
    private UserService userService;
    @RequestMapping(value = "doUserSearch",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<User> doSearch(@RequestParam(value = "UserName", required = false) String UserName,
                               @RequestParam(value = "UserRole", required = false,defaultValue = "2") String UserRole){

        int UserRole1 = Integer.parseInt(UserRole);


        List<User> list = this.userService.getUserList(UserName,UserRole1);

        return list;
    }

    @RequestMapping(value = "deleteUser", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int deleteUser(@RequestParam(value = "userCode") String userCode){
        return this.userService.deleteUserByUserCode(userCode);
    }
}
