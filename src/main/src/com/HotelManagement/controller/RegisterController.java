package com.HotelManagement.controller;

import com.HotelManagement.pojo.User;
import com.HotelManagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register.html")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/doRegister.html")
    public String doRegister(@RequestParam(value = "userCode") String userCode,
                             @RequestParam(value = "userPassword") String password,
                             @RequestParam(value = "userName") String userName,
                             @RequestParam(value = "gender") String gender,
                             @RequestParam(value = "birthday") String birthday,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "role") String role) {

        User user = new User();

        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setUserCode(userCode);
        user.setUserPassword(password);
        user.setUserName(userName);
        user.setGender(Integer.parseInt(gender));
        user.setBirthday(birthDate);
        user.setPhone(phone);
        user.setUserCode(role);

        user.setCreationDate(new Date());

        this.userService.addUser(user);

        return "login";
    }

    @RequestMapping(value = "/doRegister2", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int doRegister2(@RequestParam(value = "userCode") String userCode,
                             @RequestParam(value = "userPassword") String password,
                             @RequestParam(value = "userName") String userName,
                             @RequestParam(value = "gender") String gender,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "userRole") String userRole) {

        User user = new User();

        Integer genderOfInt = null;
        if (genderOfInt != null) {
            genderOfInt = Integer.valueOf(gender);
            user.setGender(genderOfInt);
        }

        Integer userRoleOfInt = null;
        if (userRole != null) {
            userRoleOfInt = Integer.valueOf(userRole);
            user.setUserRole(userRoleOfInt);
        }

        user.setUserCode(userCode);
        user.setUserPassword(password);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setCreationDate(new Date());

        return this.userService.addUser(user);
    }
}
