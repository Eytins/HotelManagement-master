package com.HotelManagement.dao.bill;

import com.HotelManagement.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BillMapper {

    //用户端：新建订单
    public int addBill(Bill bill);

    //根据id删除订单信息
    public int deleteBillById(@Param("billId") Integer billId);

    //根据订单编号和房间类型获得包含房间类型和房间规格的订单列表
    public List<Bill> getBillListWithType(@Param("billCode") String billCode, @Param("roomType") Integer roomType);

    //用户端: 根据Date、酒店名称、地址获取订单列表
    //todo:需要配置是哪一个用户的订单
    List<Bill> getBillListAndHotelNameByDateAndHotelNameAndAddress(@Param("id") int id,@Param("date") Date date, @Param("hotelName") String hotelName, @Param("hotelAddress") String hotelAddress);

    //获取订单价格最高值
    public int HPrice();

    //获取订单价格最低值
    public int LPrice();

    //是否已经入住
    public int isCheckIn(@Param("id") Integer id, @Param("flag") int flag);

    //根据订单编号和房间类型获得订单列表
    public List<Bill> getBillByBillCode(@Param("billCode") String billCode, @Param("roomType")Integer roomType);

    public Integer getHotelId(String hotelName);
    int getRoomType(String hotelRoomType);

    int deleteBillByCode(@Param("billCode") String billCode);
}
