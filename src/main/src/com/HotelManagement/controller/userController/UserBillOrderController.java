package com.HotelManagement.controller.userController;

import com.HotelManagement.pojo.HotelType;
import com.HotelManagement.service.hotelType.HotelTypeService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Eytins
 */

@Controller
@RequestMapping("userbillorder")
public class UserBillOrderController {

    private static final Logger logger = Logger.getLogger(UserBillOrderController.class);

    //service自己视需求调用

    @Autowired
    private HotelTypeService hotelTypeService;

    /**
     * Created by Eytins
     * Edit by Thousand
     */
    @RequestMapping(value = "doUserHotelSearch",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<HotelType> doSearch(@RequestParam(value = "priceMin", required = false, defaultValue = "200") String priceMin,
                                   @RequestParam(value = "priceMax", required = false, defaultValue = "20000") String priceMax,
                                   @RequestParam(value = "hotelName", required = false) String hotelName,
                                   @RequestParam(value = "hotelAddress", required = false) String hotelAddress) {
        int priceMin1 = Integer.parseInt(priceMin);
        int priceMax1 = Integer.parseInt(priceMax);
        HotelType hotelType ;
        List<HotelType> list = this.hotelTypeService.selectByUser(priceMin1, priceMax1, hotelName, hotelAddress);
        return list;
    }
}
