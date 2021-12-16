SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS qima_product.t_category;
DROP TABLE IF EXISTS qima_product.t_product;
DROP TABLE IF EXISTS qima_product.t_product_attribute;
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE qima_product.t_category
(
    id        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类主键id',
    name      char(200)  NOT NULL COMMENT '分类名称',
    parent_id bigint(20) NOT NULL COMMENT '父分类id',
    sort      int(11)    NOT NULL COMMENT '排序',
    status    tinyint(4) DEFAULT NULL COMMENT '是否启用[0-已启用，1-已停用]',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='产品分类';


create table qima_product.t_product
(
    id          bigint(20) NOT NULL auto_increment COMMENT '产品主键id',
    name        char(200)  NOT NULL COMMENT '产品名称',
    quantity    int        NULL COMMENT '数量',
    order_id    bigint(20) NOT NULL COMMENT '订单id',
    category_id bigint(20) NOT NULL COMMENT '产品分类id',
    constraint product_pk
        primary key (id),
    constraint product_fk
        foreign key (category_id) references qima_product.t_category (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='产品分类';


create table qima_product.t_product_attribute
(
    id         bigint(20) NOT NULL auto_increment COMMENT '产品属性主键id',
    product_id bigint(20) NOT NULL COMMENT '产品id',
    attr_name  char(200)  NOT NULL COMMENT '属性名',
    attr_value char(200)  NOT NULL COMMENT '属性值',
    attr_sort  int        NOT NULL COMMENT '排序字段',
    constraint product_attribute_pk
        primary key (id),
    constraint product_attribute_fk
        foreign key (product_id) references qima_product.t_product (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='产品属性';