package com.HotelManagement.service.hotel;

import com.HotelManagement.pojo.Bill;
import com.HotelManagement.pojo.Hotel;

import java.util.List;

public interface HotelService {

    //通过酒店名酒店地址搜索酒店
    List<Hotel> searchHotel(Integer userId,String hotelName, String hotelAddress);

    List<Hotel> searchHotel2(String hotelName, String hotelAddress);

    //添加新的酒店
    int addNewHotel(Hotel hotel);

    //删除酒店
    int deleteHotelById(int id);

    // 酒店端：查询订单
    List<Bill> searchBillByHotel(Integer isPayment, Integer isCheckIn);

    //办理入住
    int checkIn(int billId);
}
