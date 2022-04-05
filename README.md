
# Orders API
Its an application to run basic functionality of e-commerce website. 



## Run the project

```bash
  ./mvnw spring-boot:run
```
    
## API Reference(Endpoints)

## Items
### Get all items
#### Request

```http
  GET /api/v1/items
```
#### Response
```bash
  [
    {
        "itemId": 1001,
        "name": "Phone1",
        "cost": 500.0
    },
    {
        "itemId": 1002,
        "name": "Phone2",
        "cost": 1500.0
  ]
```

### Get Item with given Id.
#### Request
```http
  GET /api/v1/items/{itemId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `itemId`      | `string` | Id of item to fetch |

#### Response
```bash
 {
    "itemId": 1001,
    "name": "Phone1",
    "cost": 500.0
  }
```

### Add item
#### Request
```http
  POST /api/v1/items/
```

| Type     | Description                       |
| :------- | :-------------------------------- |
| `Item object in json` | Add items to database. |

#### Response
```bash
  {
    "itemId": 3,
    "name": "Phone5",
    "cost": 4500.0
  }
```

### Delete item
#### Request
```http
  DELETE /api/v1/items/{itemId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `itemId`      | `string` | Deletes items from database with specified Id. |

#### Response
```bash
  [
    {
        "itemId": 3,
        "name": "Phone5",
        "cost": 4500.0
    },
    {
        "itemId": 1002,
        "name": "Phone2",
        "cost": 1500.0
    }
  ]
```

## Orders
### Get all orders
#### Request
```http
  GET /api/v1/orders
```

#### Response
```bash
  [
    {
        "orderId": 1,
        "customerId": 1,
        "dateOfDelivery": "2022-04-05T08:17:41.514+00:00",
        "addressOfDelivery": "Borivali",
        "items": []
    },
    {
        "orderId": 2,
        "customerId": 2,
        "dateOfDelivery": "2022-04-05T08:17:41.583+00:00",
        "addressOfDelivery": "Thane",
        "items": []
    }
]
```

### Get order with given Id.
#### Request
```http
  GET /api/v1/orders/{orderId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId` | `string` | Id of order to fetch. |

#### Response
```bash
  
  {
    "orderId": 2,
    "customerId": 2,
    "dateOfDelivery": "2022-04-05T08:17:41.583+00:00",
    "addressOfDelivery": "Thane",
    "items": []
  }

```

### Add order
#### Request
```http
  POST /api/v1/orders/
```

 | Type     | Description                       |
 | :------- | :-------------------------------- |
 | `OrderedItem object in json` | Add items to database. |

#### Response
```bash
  {
    "orderId": 4,
    "customerId": 3,
    "dateOfDelivery": "2022-04-05T08:17:41.583+00:00",
    "addressOfDelivery": "Andheri",
    "items": []
  }
```

### Delete order
#### Request
```http
  DELETE /api/v1/orders/{orderId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId` | `string` | Deletes order from database with specified Id.|

#### Response
```bash
  [
    {
        "orderId": 1,
        "customerId": 1,
        "dateOfDelivery": "2022-04-05T08:17:41.514+00:00",
        "addressOfDelivery": "Borivali",
        "items": []
    },
    {
        "orderId": 2,
        "customerId": 2,
        "dateOfDelivery": "2022-04-05T08:17:41.583+00:00",
        "addressOfDelivery": "Thane",
        "items": []
    }
  ]
```

### Add items to order
#### Request
```http
  PUT /api/v1/orders/{orderId}/{itemId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId` | `string` | Id of the order.|
| `itemId` | `string` | Id of the item to be added.|

#### Response
```bash
  {
    "orderId": 1,
    "customerId": 1,
    "dateOfDelivery": "2022-04-05T08:17:41.514+00:00",
    "addressOfDelivery": "Borivali",
    "items": [
        {
            "itemId": 1002,
            "name": "Phone2",
            "cost": 1500.0
        }
    ]
  }
```

### Delete items from order
#### Request
```http
  DELETE /api/v1/orders/{orderId}/{itemId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId` | `string` | Id of the order.|
| `itemId` | `string` | Id of the item to be removed.|

#### Response
```bash
  {
    "orderId": 1,
    "customerId": 1,
    "dateOfDelivery": "2022-04-05T08:17:41.514+00:00",
    "addressOfDelivery": "Borivali",
    "items": []
  }
```

### Get cost of order
#### Request
```http
  GET /api/v1/orders/cost/{orderId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId` | `string` | Cost of order with specified Id.|

#### Response
```bash
  2000.0
```