package com.HotelManagement.controller.hotelController;

import com.HotelManagement.pojo.Bill;
import com.HotelManagement.pojo.User;
import com.HotelManagement.service.bill.BillService;
import com.HotelManagement.service.hotel.HotelService;
import com.HotelManagement.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Eytins
 */

@Controller
@RequestMapping("hotelbill")
public class HotelBillController {

    private static final Logger logger = Logger.getLogger(HotelBillController.class);

    @Autowired
    private HotelService hotelService;
    private BillService  billService;

    @RequestMapping(value = "searchBillByHotel", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<Bill> searchBillByHotel(@RequestParam(value = "isPayment", required = false) String isPayment,
                                        @RequestParam(value = "isCheckIn", required = false) String isCheckIn) {

        Integer isPaymentOfInt = null;
        if (isPayment != null && !isPayment.equals("")) {
            isPaymentOfInt = Integer.valueOf(isPayment);
        }

        Integer isCheckInOfInt = null;
        if (isCheckIn != null && !isCheckIn.equals("")) {
            isCheckInOfInt = Integer.valueOf(isCheckIn);
        }

        return this.hotelService.searchBillByHotel(isPaymentOfInt, isCheckInOfInt);
    }

    @RequestMapping(value = "checkIn", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int checkIn(@RequestParam(value = "billId") String billId) {
        return this.hotelService.checkIn(Integer.parseInt(billId));
    }

    @RequestMapping(value = "deleteBill", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int deleteBill(@RequestParam(value = "billId") String billId) {

        Integer billIdOfInt = null;
        if (billId != null && !billId.equals("")) {
            billIdOfInt = Integer.valueOf(billId);
        }

        return this.billService.deleteBillbyId(billIdOfInt);
    }
}
