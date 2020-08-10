package com.HotelManagement.service.bill;

import com.HotelManagement.pojo.Bill;

import java.util.Date;
import java.util.List;

public interface BillService {

    //增加订单
    public int addBill(Bill bill);

    //通过订单号和房间类型返回带有房间名和房间规格的表
    public List<Bill> getBillByBillCode(String billCode,Integer roomType);

    //获取订单价格最高值
    public int getHPrice();

    //获取订单价格最低值
    public int getLPrice();

    //根据订单id删除订单
    public int deleteBillbyId(Integer billId);

    //根据订单id删除订单
    public int deleteBillByCode(String billCode);

    //是否已经入住
    public int isCheckIn(Integer id, int flag);

    public int getHotelId(String hotelName);
    int getRoomType(String hotelRoomType);
    //根据时间、酒店名称、酒店地址获取订单和酒店
    List<Bill> getBillListAndHotelNameByDateAndHotelNameAndAddress(int id,Date date, String hotelName, String hotelAddress);
}
