create table hotelType
(
    id              bigint auto_increment comment '主键ID'
        primary key,
    hotelId         bigint         null comment '酒店ID',
    hotelRoomType   varchar(20)    null comment '酒店房间类型',
    hotelRoomNumber bigint         null comment '房间总数量',
    hotelPrice      decimal(20, 2) null comment '单价',
    hotelPeople     bigint         null comment '可入住人数',
    creationDate    datetime       null comment '创建时间',
    modifyDate      datetime       null comment '更新时间',
    constraint hotelType_ibfk_1
        foreign key (hotelId) references hotel (id)
            on update cascade on delete cascade
)
    collate = utf8_unicode_ci;

create index hotelId
    on hotelType (hotelId);

INSERT INTO HotelManagement.hotelType (id, hotelId, hotelRoomType, hotelRoomNumber, hotelPrice, hotelPeople, creationDate, modifyDate) VALUES (2, 1, '豪华大床房', 5, 1600.00, 5, '2020-06-07 00:00:00', null);
INSERT INTO HotelManagement.hotelType (id, hotelId, hotelRoomType, hotelRoomNumber, hotelPrice, hotelPeople, creationDate, modifyDate) VALUES (3, 2, '标准间', 5, 500.00, 5, null, null);
INSERT INTO HotelManagement.hotelType (id, hotelId, hotelRoomType, hotelRoomNumber, hotelPrice, hotelPeople, creationDate, modifyDate) VALUES (4, 2, '豪华大床房', 10, 2000.00, 10, null, null);
INSERT INTO HotelManagement.hotelType (id, hotelId, hotelRoomType, hotelRoomNumber, hotelPrice, hotelPeople, creationDate, modifyDate) VALUES (5, 1, '四人间', 20, 500.00, 4, null, null);