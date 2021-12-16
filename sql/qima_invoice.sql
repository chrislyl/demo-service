drop table if exists qima_invoice.t_invoice;
create table qima_invoice.t_invoice
(
    id           bigint auto_increment not null COMMENT '发票主键ID',
    invoice_no   char(100)             not null COMMENT '唯一发票号码',
    issue_date   date                  not null COMMENT '发票生成日期',
    total_amount decimal(10, 2)        not null COMMENT '发票总金额',
    currency     char(5)               not null COMMENT '货币',
    constraint t_invoice_pk
        primary key (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单发票信息';

create unique index t_invoice_no_uindex on qima_invoice.t_invoice (invoice_no);

insert into qima_invoice.t_invoice(id, invoice_no, issue_date, total_amount, currency) values (1, 'INV-2100001', NOW(), 309.00, 'USD');
COMMIT ;