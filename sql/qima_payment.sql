drop table if exists qima_payment.t_payment_record;
create table qima_payment.t_payment_record
(
    id              bigint auto_increment not null comment '主键ID',
    order_id        bigint                not null comment '订单ID',
    payment_gateway char(20)              not null comment '支付网关：ALIPAY, ADYEN, PAYPAL',
    amount_paid     decimal(10, 2)        not null comment '支付金额',
    payer           char(100)             not null comment '付款人',
    payment_date    datetime              not null comment '支付日期',
    status          int                   not null comment '支付状态：成功COMPLETED-0,失败FAILED-1, 已删除FAILED-2',
    constraint t_payment_record_pk
        primary key (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='支付记录';


insert into qima_payment.t_payment_record(id, order_id, payment_gateway, amount_paid, payer, payment_date, status) values (1, 1, 'ADYEN', 99.99, 'Steve Jobs', now(), 0);
insert into qima_payment.t_payment_record(id, order_id, payment_gateway, amount_paid, payer, payment_date, status) values (2, 1, 'PAYPAL', 100.01, 'Bill Gates', now(), 0);
insert into qima_payment.t_payment_record(id, order_id, payment_gateway, amount_paid, payer, payment_date, status) values (3, 1, 'ALIPAY', 109.00, 'Zhang San', now(), 0);
commit;