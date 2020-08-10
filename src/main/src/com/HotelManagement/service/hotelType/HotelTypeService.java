package com.HotelManagement.service.hotelType;

import com.HotelManagement.pojo.HotelType;

import java.util.List;

public interface HotelTypeService {

    //添加新的房间类型
    int addNewHotelType(HotelType hotelType);

    //删除房间类型
    int deleteHotelType(int id);

    //查询剩余房型量
    int selectRemainNumber(Integer hotelTypeId,
                           Integer hotelId);

    //用户查询
    public List<HotelType> selectByUser(
            Integer priceMin,
            Integer priceMax,
            String hotelName,
            String hotelAddress
    );

    //查询房型
    List<HotelType> selectHotelTypeByIdType(String hotelRoomType, Integer hotelId);

    //更改房型信息
    int modifyRoomType(Integer roomTypeId,
                       long price,
                       Integer numberOfPerson);

}
