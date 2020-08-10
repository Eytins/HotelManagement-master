package com.HotelManagement.service.hotelType;

import com.HotelManagement.dao.hotelType.HotelTypeMapper;
import com.HotelManagement.pojo.HotelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelTypeServiceImpl implements HotelTypeService {
    @Autowired
    private HotelTypeMapper hotelTypeMapper;

    //添加新的房间类型
    public int addNewHotelType(HotelType hotelType) {
        return this.hotelTypeMapper.addNewHotelType(hotelType);
    }

    //删除房间类型
    public int deleteHotelType(int id) {
        return this.hotelTypeMapper.deleteHotelType(id);
    }

    //查询房型
    public List<HotelType> selectHotelTypeByIdType(String hotelRoomType, Integer hotelId) {
        return this.hotelTypeMapper.selectHotelTypeByIdType(hotelRoomType, hotelId);
    }

    //查询剩余房型量
    public int selectRemainNumber(
            Integer hotelTypeId,
            Integer hotelId) {
        return this.hotelTypeMapper.selectRemainNumber(hotelTypeId, hotelId);
    }

    public List<HotelType> selectByUser(
            Integer priceMin,
            Integer priceMax,
            String hotelName,
            String hotelAddress) {

        return this.hotelTypeMapper.selectByUser(priceMin, priceMax, hotelName, hotelAddress);
    }

    @Override
    public int modifyRoomType(Integer roomTypeId, long price, Integer numberOfPerson) {
        return this.hotelTypeMapper.modifyRoomType(roomTypeId,price,numberOfPerson);
    }


}
