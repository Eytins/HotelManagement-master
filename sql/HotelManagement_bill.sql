create table bill
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    billCode     varchar(20)    null comment '账单编码',
    orderId      bigint         null comment '下单用户ID',
    hotelId      bigint         null comment '用户所订购酒店ID',
    roomType     bigint         null comment '房间类型',
    checkInDate  date           null comment '入住时间',
    checkOutDate date           null comment '退房时间',
    isCheckIn    int(10)        null comment '是否入住（1：未入住 2：已入住）',
    countDays    bigint         null comment '入住天数',
    totalPrice   decimal(20, 2) null comment '总额',
    isPayment    int(10)        null comment '是否支付（1：未支付 2：已支付）',
    creationDate datetime       null comment '创建时间',
    modifyDate   datetime       null comment '更新时间',
    providerId   bigint         null comment '供应商ID',
    constraint bill_ibfk_1
        foreign key (orderId) references user (id)
            on update cascade on delete cascade
)
    collate = utf8_unicode_ci;

create index orderId
    on bill (orderId);

INSERT INTO HotelManagement.bill (id, billCode, orderId, hotelId, roomType, checkInDate, checkOutDate, isCheckIn, countDays, totalPrice, isPayment, creationDate, modifyDate, providerId) VALUES (2, 'BILL2016_002', 3, 1, 1, '2020-06-01', '2020-06-02', 1, 1, 25000.00, 2, '2020-05-21 13:02:03', null, 5);
INSERT INTO HotelManagement.bill (id, billCode, orderId, hotelId, roomType, checkInDate, checkOutDate, isCheckIn, countDays, totalPrice, isPayment, creationDate, modifyDate, providerId) VALUES (3, 'BILL2016_003', 4, 1, 1, '2020-06-01', '2020-06-02', 1, 1, 25000.00, 2, '2020-05-21 13:02:03', null, 5);
INSERT INTO HotelManagement.bill (id, billCode, orderId, hotelId, roomType, checkInDate, checkOutDate, isCheckIn, countDays, totalPrice, isPayment, creationDate, modifyDate, providerId) VALUES (5, '2YJhQO1idmeY', 2, 2, 2, '2020-06-13', '2020-06-14', 0, 1, 2000.00, 2, null, null, 1);
INSERT INTO HotelManagement.bill (id, billCode, orderId, hotelId, roomType, checkInDate, checkOutDate, isCheckIn, countDays, totalPrice, isPayment, creationDate, modifyDate, providerId) VALUES (6, 'FgHqArt3Zbbl', 2, 2, 1, '2020-06-13', '2020-06-14', 0, 1, 500.00, 2, null, null, 1);
INSERT INTO HotelManagement.bill (id, billCode, orderId, hotelId, roomType, checkInDate, checkOutDate, isCheckIn, countDays, totalPrice, isPayment, creationDate, modifyDate, providerId) VALUES (7, 'tL9ni1V8C3XH', 2, 1, 2, '2020-06-19', '2020-06-20', 0, -9, 1600.00, 2, null, null, 1);
INSERT INTO HotelManagement.bill (id, billCode, orderId, hotelId, roomType, checkInDate, checkOutDate, isCheckIn, countDays, totalPrice, isPayment, creationDate, modifyDate, providerId) VALUES (9, '7w3NW729lvWS', 2, 1, 1, '2020-06-19', '2020-06-20', 0, -9, 1000.00, 2, null, null, 1);