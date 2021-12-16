drop table if exists qima_order.t_order;
create table qima_order.t_order
(
    id           bigint auto_increment not null COMMENT '订单id',
    order_no     char(100)             not null COMMENT '唯一订单编号',
    booking_date datetime              not null COMMENT '下单日期时间',
    total_amount decimal(10, 2)        not null COMMENT '订单总金额',
    service_type char(20)              not null COMMENT '服务类型',
    status       int                   not null COMMENT '状态',
    invoice_id   bigint                null COMMENT '发票id',
    constraint order_pk
        primary key (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单';

create unique index order_no_uindex on qima_order.t_order (order_no);

insert into qima_order.t_order(id, order_no, booking_date, total_amount, service_type, status, invoice_id) values (1, 'RO-00001', NOW(), 309, 'INSPECTION', 60, 1);
COMMIT;