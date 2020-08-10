package com.HotelManagement.controller.billController;

import com.HotelManagement.pojo.Bill;
import com.HotelManagement.pojo.User;
import com.HotelManagement.service.bill.BillService;
import com.HotelManagement.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("billlist")
public class BillListController {

    private static final Logger logger = Logger.getLogger(BillListController.class);

    @Autowired
    private BillService billService;

    @RequestMapping(value = "doBillSearch", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    /*
     * 订单的查询
     * */
    public List<Bill> doBillSearch(@RequestParam(value = "billCode", required = false) String billCode,
                                   @RequestParam(value = "roomType", required = false, defaultValue = "1") String roomType) {
        int roomType1 = Integer.parseInt(roomType);
        return this.billService.getBillByBillCode(billCode, roomType1);
    }

    @RequestMapping(value = "addNewBill", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int addNewBill(@RequestParam(value = "hotelName") String hotelName,
                          @RequestParam(value = "roomType") String roomType,
                          @RequestParam(value = "checkInDate") String checkInDate,
                          @RequestParam(value = "checkOutDate") String checkOutDate,
                          @RequestParam(value = "totalPrice") Integer totalPrice,
                          HttpSession session) {
        String result   = java.net.URLDecoder.decode(hotelName, StandardCharsets.UTF_8);
        String roomtype = java.net.URLDecoder.decode(roomType, StandardCharsets.UTF_8);

        Bill bill      = new Bill();
        User loginUser = (User) session.getAttribute(Constants.USER_SESSION);
        Date inDate    = null;
        Date outDate   = null;
        try {
            inDate  = new SimpleDateFormat("yyyy-MM-dd").parse(checkInDate);
            outDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkOutDate);
            long between = (outDate.getTime() - inDate.getTime()) / (3600 * 24 * 1000);
            totalPrice = Math.toIntExact(totalPrice * between);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user      = (User) session.getAttribute(Constants.USER_SESSION);
        int  hotelId   = this.billService.getHotelId(result);
        int  roomTypee = this.billService.getRoomType(roomtype);
        bill.setBillCode(getRandomString(12));
        bill.setOrderId(user.getId());
        bill.setHotelId(hotelId);
        bill.setRoomType(roomTypee);
        bill.setCheckInDate(inDate);
        bill.setCheckOutDate(outDate);
        bill.setIsCheckIn(0);
        bill.setIsPayment(2);
        bill.setCreationDate(new Date());
        bill.setCountDays(getDifferenceDays(checkInDate, checkOutDate));
        bill.setTotalPrice(totalPrice);
        bill.setTotalPrice(totalPrice);
        bill.setProviderId(1);

        return this.billService.addBill(bill);
    }


    @RequestMapping(value = "deleteBill", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int deleteBill(@RequestParam(value = "billCode") String billCode) {
        return this.billService.deleteBillByCode(billCode);
    }

    // 生成随机orderId字符串
    public static String getRandomString(int length) {

        String        str    = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random        random = new Random();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            buffer.append(str.charAt(number));
        }

        return buffer.toString();
    }

    //计算两天之差
    public static int getDifferenceDays(String in, String out) {
        int a = Integer.parseInt(in.substring(in.length() - 1, in.length()));
        int b = Integer.parseInt(out.substring(out.length() - 1, out.length()));
        return b - a;
    }
}
