package com.HotelManagement.dao.hotel;

import com.HotelManagement.pojo.Bill;
import com.HotelManagement.pojo.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelMapper {

    // 通过酒店名酒店地址搜索酒店
    List<Hotel> searchHotel(@Param("userId") Integer userId, @Param("hotelName") String hotelName, @Param("hotelAddress") String hotelAddress);

    List<Hotel> searchHotel2( @Param("hotelName") String hotelName, @Param("hotelAddress") String hotelAddress);
    // 添加新的酒店
    int addNewHotel(Hotel hotel);

    //删除酒店
    int deleteHotelById(@Param("id") Integer id);

    // 酒店端：查询订单
    List<Bill> searchBillByHotel(@Param("isPayment") Integer isPayment,
                                 @Param("isCheckIn") Integer isCheckIn);

    // 通过billId办理入住
    int checkIn(@Param("billId") int billId);
}
