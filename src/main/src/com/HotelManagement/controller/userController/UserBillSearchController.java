package com.HotelManagement.controller.userController;

import com.HotelManagement.pojo.Bill;
import com.HotelManagement.pojo.User;
import com.HotelManagement.service.bill.BillService;
import com.HotelManagement.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Eytins
 */

@Controller
@RequestMapping("userbillsearch")
public class UserBillSearchController {

    private static final Logger logger = Logger.getLogger(UserBillOrderController.class);

    //service自己视需求调用
    @Autowired
    private BillService billService;

    @RequestMapping(value = "doUserHotelSearch", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    /*
    * 用户自身的订单查询
    * */
    public List<Bill> doUserHotelSearch(@RequestParam(value = "theDay", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date theDay,
                                        @RequestParam(value = "hotelName", required = false) String hotelName,
                                        @RequestParam(value = "hotelAddress", required = false) String hotelAddress, HttpSession session) {
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        return this.billService.getBillListAndHotelNameByDateAndHotelNameAndAddress(user.getId(),theDay, hotelName, hotelAddress);
    }


}
