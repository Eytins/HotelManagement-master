create table hotel
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    hotelName    varchar(20) null comment '酒店名称',
    hotelAddress varchar(50) null comment '酒店地址明细',
    postCode     varchar(15) null comment '邮编',
    tel          varchar(20) null comment '联系人电话',
    creationDate datetime    null comment '创建时间',
    userId       bigint      null comment '老板ID',
    constraint hotel_ibfk_1
        foreign key (userId) references user (id)
            on update cascade on delete cascade
)
    collate = utf8_unicode_ci;

create index userId
    on hotel (userId);

INSERT INTO HotelManagement.hotel (id, hotelName, hotelAddress, postCode, tel, creationDate, userId) VALUES (1, '金陵饭店', '南京汉中路2号', '210000', '15366024589', '2020-06-07 00:00:00', 5);
INSERT INTO HotelManagement.hotel (id, hotelName, hotelAddress, postCode, tel, creationDate, userId) VALUES (2, '金鹰酒店', '新街口', '262500', '13344445555', '2020-06-12 14:40:58', 5);
INSERT INTO HotelManagement.hotel (id, hotelName, hotelAddress, postCode, tel, creationDate, userId) VALUES (13, 'aa', '12', '123', '12', '2020-06-12 14:50:43', 5);