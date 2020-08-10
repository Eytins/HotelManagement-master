package com.HotelManagement.controller.hotelController;

import com.HotelManagement.pojo.HotelType;
import com.HotelManagement.service.hotelType.HotelTypeService;
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
@RequestMapping("hotelroom")
public class HotelRoomController {

    private static final Logger logger = Logger.getLogger(HotelRoomController.class);

    //service自己视需求调用

    @Autowired
    private HotelTypeService hotelTypeService;

    /*
     * 所有房间的查询
     * */
    @RequestMapping(value = "searchHotelRoom", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<HotelType> doRoomSearch(@RequestParam(value = "hotelId") String hotelId) {

        Integer hotelIdOfInt = null;
        if (hotelId != null) {
            hotelIdOfInt = Integer.valueOf(hotelId);
        }

        List<HotelType> hotelTypes = hotelTypeService.selectHotelTypeByIdType(null, hotelIdOfInt);

        //todo:添加一个剩余房间数的属性
        for (int j = 0; j < hotelTypes.size(); j++) {
            hotelTypes.get(j).setRemainNumber(
                    hotelTypeService.selectRemainNumber(hotelTypes.get(j).getId(), hotelIdOfInt));
        }
        return hotelTypes;
    }

    /*
     * 新增酒店房间类型
     * */
    @RequestMapping(value = "addHotelRoom", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int addNewRoom(@RequestParam(value = "hotelId") String hotelId,
                          @RequestParam(value = "roomType") String roomType,
                          @RequestParam(value = "roomNumber") String roomNumber,
                          @RequestParam(value = "price") String price,
                          @RequestParam(value = "numberOfPerson") String numberOfPerson) {
        HotelType hotelType    = new HotelType();
        Integer   hotelIdOfInt = null;
        if (hotelId != null) {
            hotelIdOfInt = Integer.valueOf(hotelId);
        }
        hotelType.setHotelId(hotelIdOfInt);
        hotelType.setHotelRoomType(roomType);

        Integer roomNumberOfInt = null;
        if (roomNumber != null) {
            roomNumberOfInt = Integer.valueOf(roomNumber);
        }
        hotelType.setHotelRoomNumber(roomNumberOfInt);

        Integer priceOfInt = null;
        if (price != null) {
            priceOfInt = Integer.valueOf(price);
        }
        hotelType.setHotelPrice(priceOfInt);

        Integer numberOfPersonOfInt = null;
        if (numberOfPerson != null) {
            numberOfPersonOfInt = Integer.valueOf(numberOfPerson);
        }
        hotelType.setHotelPeople(numberOfPersonOfInt);

        return hotelTypeService.addNewHotelType(hotelType);
    }

    /*
     * 编辑酒店房间
     * */
    @RequestMapping(value = "editHotelRoom", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int editRoom(@RequestParam(value = "roomId") String roomTypeId,
                        @RequestParam(value = "roomPrice") String price,
                        @RequestParam(value = "numberOfPerson") String numberOfPerson) {


        Integer roomTypeIdOfInt = null;
        if (roomTypeId != null) {
            roomTypeIdOfInt = Integer.valueOf(roomTypeId);
        }

        long priceOfLong = Long.parseLong(price);

        Integer numberOfPersonOfInt = null;
        if (numberOfPerson != null) {
            numberOfPersonOfInt = Integer.valueOf(numberOfPerson);
        }

        return hotelTypeService.modifyRoomType(roomTypeIdOfInt, priceOfLong, numberOfPersonOfInt);
    }

    /*
     * 删除酒店房间
     * */
    @RequestMapping(value = "deleteHotelRoom", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int deleteHotelRoom(@RequestParam(value = "roomId") String roomId) {

        Integer roomIdOfInt = null;
        if (roomId != null) {
            roomIdOfInt = Integer.valueOf(roomId);
        }

        return hotelTypeService.deleteHotelType(roomIdOfInt);
    }

}
