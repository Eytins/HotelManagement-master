create table user
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    userCode     varchar(15) null comment '用户编码',
    userName     varchar(15) null comment '用户名称',
    userPassword varchar(15) null comment '用户密码',
    gender       int(10)     null comment '性别（1:女、 2:男）',
    birthday     date        null comment '出生日期',
    phone        varchar(15) null comment '手机',
    userRole     bigint      null comment '用户角色（取自角色表-角色id）',
    creationDate datetime    null comment '创建时间',
    modifyDate   datetime    null comment '更新时间',
    constraint user_ibfk_1
        foreign key (userRole) references role (id)
            on update cascade on delete cascade
)
    collate = utf8_unicode_ci;

create index userRole
    on user (userRole);

INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (1, 'admin', '系统管理员', '1234567', 2, '1983-10-10', '13688889999', 1, '2013-03-21 16:52:07', null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (2, 'xiaoming', '小明', '0000000', 2, null, null, 2, null, null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (3, 'xiaocheng', '小程', '0000000', 2, '1999-06-05', '18567542321', 2, '2019-12-31 19:52:09', null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (4, 'xiaoyang', '小扬', '0000000', 2, '1999-06-06', '18567552321', 2, '2019-12-31 19:52:09', null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (5, 'xiaoqian', '小仟', '0000000', 2, '1999-02-08', '18567552321', 3, '2019-12-31 19:52:09', null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (6, 'yong', '扬扬', '0000000', 0, null, '1235625622', 2, null, null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (7, '12', 'a', '3112', 0, null, '1234', 2, null, null);
INSERT INTO HotelManagement.user (id, userCode, userName, userPassword, gender, birthday, phone, userRole, creationDate, modifyDate) VALUES (8, 'sheep', 'sheep', '0000000', 0, null, '13253156286', 1, null, null);