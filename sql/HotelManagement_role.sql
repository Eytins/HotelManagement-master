create table role
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    roleName     varchar(15) null comment '角色名称',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '修改者',
    modifyDate   datetime    null comment '修改时间'
)
    collate = utf8_unicode_ci;

INSERT INTO HotelManagement.role (id, roleName, creationDate, modifyBy, modifyDate) VALUES (1, '系统管理员', '2016-04-13 00:00:00', null, null);
INSERT INTO HotelManagement.role (id, roleName, creationDate, modifyBy, modifyDate) VALUES (2, '普通用户', '2016-04-13 00:00:00', null, null);
INSERT INTO HotelManagement.role (id, roleName, creationDate, modifyBy, modifyDate) VALUES (3, '酒店管理员', '2016-04-13 00:00:00', null, null);