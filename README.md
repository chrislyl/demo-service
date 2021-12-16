## Welcome

Welcome to this simulated microservice scenario, this is a sample microservice project based on Spring Boot 2.5.6, Spring Cloud 2020.0.4, Spring Cloud Alibaba 2021.1, MyBatis Plus 3.4.3.4, 
here are the basic architecture:
~~~
demo-service    
├── demo-common             // the common dependencies, utils, configurations
├── demo-order              // [10010] order module
├── demo-product            // [10020] product module
├── demo-payment            // [10030] payment module
├── demo-invoice            // [10040] invoice module
├── pom.xml                  
~~~

Now our data are built based on these domains:

- **demo-order** is based on the domain [Order](demo-order/src/main/java/com/qima/sp/order/domain/Order.java)
```json
{
    "id": 1,
    "orderNo": "RD-00001",
    "bookingDate": "2021-12-13T15:34:31",
    "totalAmount": 309.0,
    "serviceType": "INSPECTION",
    "status": "FINISHED",
    "invoiceId": 1
}
```
***<sup>the attribute `id` corresponds to the database auto-incrementing primary key column</sup>***  
***<sup>The attribute `invoiceId` is associated with the primary key of the domain [Invoice](demo-invoice/src/main/java/com/qima/sp/invoice/domain/Invoice.java) of the microservice `demo-invoice`</sup>***

- **qima-product** is based on the 3 domains  

[Category](demo-product/src/main/java/com/qima/sp/product/domain/Category.java)
```json
{
    "id": 16,
    "parentId": 1,
    "name": "cat16",
    "sort": 5,
    "status": "ACTIVE",
    "children": []
}
```
***<sup>`parentId` is associated with its own primary key `id`</sup>***  

[Product](demo-product/src/main/java/com/qima/sp/product/domain/Product.java)
```json
{
    "id": 1,
    "orderId": 1,
    "categoryId": 16,
    "name": "p1",
    "quantity": 9
}
```
***<sup>the attribute `categoryId` is associated with the primary key `id` of domain [Category](demo-product/src/main/java/com/qima/sp/product/domain/Category.java)</sup>***  
***<sup>the attribute `orderId` is associated with the primary key of the domain [Order](demo-order/src/main/java/com/qima/sp/order/domain/Order.java) of the microservice `demo-order`</sup>***

[ProductAttribute](demo-product/src/main/java/com/qima/sp/product/domain/ProductAttribute.java)
```json
{
    "id": 1,
    "productId": 1,
    "attrName": "arrt name 1",
    "attrValue": "attr value 1",
    "attrSort": 1
}
```
***<sup>the attribute `productId` is associated with the primary key `id` of domain [Product](demo-product/src/main/java/com/qima/sp/product/domain/Product.java)</sup>***  

- **qima-payment** is based on the domain [PaymentRecord](demo-payment/src/main/java/com/qima/sp/payment/domain/PaymentRecord.java)
```json
{
    "id": 1,
    "orderId": 1,
    "paymentGateway": "ADYEN",
    "amountPaid": 99.99,
    "payer": "Steve Jobs",
    "paymentDate": "2021-12-13T15:34:53",
    "status": "COMPLETED"
}
```
***<sup>the attribute `orderId` is associated with the primary key of the domain [Order](demo-order/src/main/java/com/qima/sp/order/domain/Order.java) of the microservice `demo-order`</sup>***

- **qima-invoice** is based on the domain [Invoice](demo-invoice/src/main/java/com/qima/sp/invoice/domain/Invoice.java)
```json
{
    "id": 1,
    "invoiceNo": "INV-2100001",
    "issueDate": "2021-12-13",
    "totalAmount": 309.0,
    "currency": "USD"
}
```

---
**Now everything starts ...**

---

## Tasks

Here are the tasks to achieve requirements.

##### 1. [ProductServiceImpl#getByOrderId](demo-product/src/main/java/com/qima/sp/product/service/impl/ProductServiceImpl.java)
optimize this business service method to improve query efficiency

##### 2. [CategoryServiceImpl#getTreeList](demo-product/src/main/java/com/qima/sp/product/service/impl/CategoryServiceImpl.java)
implement feature to query all the product category, **Note: the result must be a tree list**  
here is a sample json result
```json
[
  {
    "id": 1,
    "parentId": 0,
    "name": "cat1",
    "sort": 1,
    "status": "ACTIVE",
    "children": [
      {
        "id": 12,
        "parentId": 1,
        "name": "cat12",
        "sort": 1,
        "status": "ACTIVE",
        "children": [
          {
            "id": 51,
            "parentId": 12,
            "name": "cat51",
            "sort": 1,
            "status": "ACTIVE",
            "children": [
              {
                "id": 56,
                "parentId": 51,
                "name": "cat56",
                "sort": 1,
                "status": "ACTIVE",
                "children": []
              },
              {
                "id": 57,
                "parentId": 51,
                "name": "cat57",
                "sort": 2,
                "status": "ACTIVE",
                "children": []
              }
            ]
          },
          {
            "id": 52,
            "parentId": 12,
            "name": "cat52",
            "sort": 2,
            "status": "ACTIVE",
            "children": []
          }
        ]
      },
      {
        "id": 13,
        "parentId": 1,
        "name": "cat13",
        "sort": 2,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 14,
        "parentId": 1,
        "name": "cat14",
        "sort": 3,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 15,
        "parentId": 1,
        "name": "cat15",
        "sort": 4,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 16,
        "parentId": 1,
        "name": "cat16",
        "sort": 5,
        "status": "ACTIVE",
        "children": []
      }
    ]
  },
  {
    "id": 2,
    "parentId": 0,
    "name": "cat2",
    "sort": 2,
    "status": "ACTIVE",
    "children": [
      {
        "id": 17,
        "parentId": 2,
        "name": "cat17",
        "sort": 1,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 18,
        "parentId": 2,
        "name": "cat18",
        "sort": 2,
        "status": "ACTIVE",
        "children": [
          {
            "id": 53,
            "parentId": 18,
            "name": "cat53",
            "sort": 1,
            "status": "ACTIVE",
            "children": [
              {
                "id": 58,
                "parentId": 53,
                "name": "cat58",
                "sort": 1,
                "status": "ACTIVE",
                "children": []
              },
              {
                "id": 59,
                "parentId": 53,
                "name": "cat59",
                "sort": 2,
                "status": "ACTIVE",
                "children": []
              },
              {
                "id": 60,
                "parentId": 53,
                "name": "cat60",
                "sort": 3,
                "status": "ACTIVE",
                "children": []
              }
            ]
          },
          {
            "id": 54,
            "parentId": 18,
            "name": "cat54",
            "sort": 2,
            "status": "ACTIVE",
            "children": []
          },
          {
            "id": 55,
            "parentId": 18,
            "name": "cat55",
            "sort": 3,
            "status": "ACTIVE",
            "children": []
          }
        ]
      },
      {
        "id": 19,
        "parentId": 2,
        "name": "cat19",
        "sort": 3,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 20,
        "parentId": 2,
        "name": "cat20",
        "sort": 4,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 21,
        "parentId": 2,
        "name": "cat21",
        "sort": 5,
        "status": "ACTIVE",
        "children": []
      },
      {
        "id": 22,
        "parentId": 2,
        "name": "cat22",
        "sort": 6,
        "status": "ACTIVE",
        "children": []
      }
    ]
  }
]
```

##### 3. [OrderServiceImpl#orderDetails](demo-order/src/main/java/com/qima/sp/order/service/impl/OrderServiceImpl.java)
Use thread pools and asynchronous orchestration to optimize this business query