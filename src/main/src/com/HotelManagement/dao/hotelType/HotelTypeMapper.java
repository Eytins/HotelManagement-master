package com.HotelManagement.dao.hotelType;

import com.HotelManagement.pojo.HotelType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelTypeMapper {

    //添加新的房间类型
    int addNewHotelType(HotelType hotelType);

    //删除房间类型
    int deleteHotelType(int id);

    //查询房型
    List<HotelType> selectHotelTypeByIdType(@Param("hotelRoomType") String hotelRoomType, @Param("hotelId") Integer hotelId);

    //查询剩余房型量
    int selectRemainNumber(@Param("hotelTypeId") Integer hotelTypeId,
                           @Param("hotelId") Integer hotelId);

    //用户查询
    List<HotelType> selectByUser(
            @Param(value = "priceMin") Integer priceMin,
            @Param(value = "priceMax") Integer priceMax,
            @Param(value = "hotelName") String hotelName,
            @Param(value = "hotelAddress") String hotelAddress
    );
    //按时间查询已预定房间数量



    //更改房型
    int modifyRoomType(@Param("roomTypeId") Integer roomTypeId,
                       @Param("price") long price,
                       @Param("numberOfPerson") Integer numberOfPerson);


}
