package com.HotelManagement.service.bill;

import com.HotelManagement.dao.bill.BillMapper;
import com.HotelManagement.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    //用户端：新建订单
    public int addBill(Bill bill) {
        return this.billMapper.addBill(bill);
    }


    //用户端: 根据Date、酒店名称、地址获取订单列表
    @Override
    public List<Bill> getBillListAndHotelNameByDateAndHotelNameAndAddress(int id,Date date, String hotelName, String hotelAddress) {
        return billMapper.getBillListAndHotelNameByDateAndHotelNameAndAddress(id,date, hotelName, hotelAddress);
    }

    //获取订单价格最高值
    public int getHPrice() {
        return this.billMapper.HPrice();
    }

    //获取订单价格最低值
    public int getLPrice() {
        return this.billMapper.LPrice();
    }

    //根据订单id删除订单
    public int deleteBillbyId(Integer billId) {
        return this.billMapper.deleteBillById(billId);
    }

    @Override
    public int deleteBillByCode(String billCode) {
        return this.billMapper.deleteBillByCode(billCode);
    }

    //是否已经入住
    public int isCheckIn(Integer id, int flag) {
        return this.billMapper.isCheckIn(id, flag);
    }

    @Override
    public int getHotelId(String hotelName) {
        return this.billMapper.getHotelId(hotelName);
    }

    //通过订单号和房间类型返回带有房间名和房间规格的表
    public List<Bill> getBillByBillCode(String billCode,Integer roomType) {
        return this.billMapper.getBillByBillCode(billCode, roomType);
    }
    @Override
    public int getRoomType(String hotelRoomType) {
        return this.billMapper.getRoomType(hotelRoomType);
    }
}
