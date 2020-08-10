package com.HotelManagement.controller.hotelController;

import com.HotelManagement.pojo.Hotel;
import com.HotelManagement.pojo.User;
import com.HotelManagement.service.hotel.HotelService;
import com.HotelManagement.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
@RequestMapping("hotelList")
public class HotelListController {

    private static final Logger logger = Logger.getLogger(HotelListController.class);

    @Autowired
    private HotelService hotelService;

    /*
     * 对酒店本身的搜索
     * */
    @RequestMapping(value = "doHotelSearch", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<Hotel> doHotelSearch(@RequestParam(value = "hotelName", required = false) String hotelName,
                                     @RequestParam(value = "hotelAddress", required = false) String hotelAddress,
                                     HttpSession session) {
        logger.debug("HotelListController---------------->doHotelSearch");

        User    loginUser = (User) session.getAttribute(Constants.USER_SESSION);
        Integer userId    = loginUser.getId();

        return this.hotelService.searchHotel(userId, hotelName, hotelAddress);
    }

    @RequestMapping(value = "doHotelSearch2", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<Hotel> doHotelSearch2(@RequestParam(value = "hotelName", required = false) String hotelName,
                                      @RequestParam(value = "hotelAddress", required = false) String hotelAddress,
                                      HttpSession session) {
        logger.debug("HotelListController---------------->doHotelSearch");

        Integer userId = 5;
        return this.hotelService.searchHotel(userId, hotelName, hotelAddress);
    }

    // test: hotelAdd/doAddNewHotel.html?hotelName=1112&hotelAddress=122&postCode=123455&tel=123423
    /*
     * 新增酒店
     * */
    @RequestMapping(value = "doAddNewHotel", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int addNewHotel(@RequestParam(value = "hotelName") String hotelName,
                           @RequestParam(value = "hotelAddress") String hotelAddress,
                           @RequestParam(value = "postCode") String postCode,
                           @RequestParam(value = "tel") String tel,
                           HttpSession session) {

        Hotel hotel = new Hotel();

        User loginUser = (User) session.getAttribute(Constants.USER_SESSION);

        hotel.setHotelName(hotelName);
        hotel.setHotelAddress(hotelAddress);
        hotel.setPostCode(postCode);
        hotel.setTel(tel);
        hotel.setCreationDate(new Date());
        hotel.setUserId(loginUser.getId());


        return this.hotelService.addNewHotel(hotel);
    }

    /*
     * 删除酒店
     * */
    @RequestMapping(value = "deleteHotel", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int deleteHotel(@RequestParam(value = "hotelId") String id) {
        return this.hotelService.deleteHotelById(Integer.parseInt(id));
    }
}
