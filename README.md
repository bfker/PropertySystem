# PropertySystem



## 接口文档

### 用户相关接口

#### 注册

##### 请求

- **URL**: `/users/register`

- **方法**: `POST`

- 请求体

  ```
  json复制代码{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "securepassword123"
  }
  ```

##### 响应

- 成功响应

  - **状态码**: `200 OK`

  - 响应体

    ```
    {
      "code": 200,
      "message": "success"
    }
    ```

- 错误响应

  - **状态码**: `400 Bad Request`

  - 响应体

    ```
    {
      "code": 400,
      "message": "fail: <error_message>"
    }
    ```

#### 登录

##### 请求

- **URL**: `/users/login`

- **方法**: `POST`

- 请求头

  - `Content-Type: application/json`

- 请求体

  ```
  {
    "email": "john.doe@example.com",
    "password": "securepassword123"
  }
  ```

##### 响应

- 成功响应

  - **状态码**: `200 OK`

  - 响应体

    ```
    {
      "code": 200,
      "message": "success"
    }
    ```

- 错误响应

  - **状态码**: `401 Unauthorized`

  - 响应体

    ```
    {
      "code": 401,
      "message": "Authorization Failed"
    }
    ```

#### 获取所有用户

##### 请求

- **URL**: `/users`
- **方法**: `GET`

##### 响应

- 成功响应

  - **状态码**: `200 OK`

  - 响应体

    ```
    [
      {
        "userID": 1,
        "name": "John Doe",
        "email": "john.doe@example.com",
        "password": "securepassword123"
      },
      ...
    ]
    ```

#### 根据ID获取用户

##### 请求

- **URL**: `/users/{userID}`
- **方法**: `GET`
- 参数
  - `userID`: 用户ID

##### 响应

- 成功响应

  - **状态码**: `200 OK`

  - 响应体

    ```
    {
      "userID": 1,
      "name": "John Doe",
      "email": "john.doe@example.com",
      "password": "securepassword123"
    }
    ```

#### 更新用户信息

##### 请求

- **URL**: `users/{userID}`

- **方法**: `PUT`

- 参数

  - `userID`: 用户ID

- 请求体

  ```
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "securepassword123"
  }
  ```

##### 响应

- 成功响应

  - **状态码**: `200 OK`

  - 响应体

    ```
    {
      "code": 200,
      "message": "User updated successfully."
    }
    ```

#### 删除用户

##### 请求

- **URL**: `users/{userID}`
- **方法**: `DELETE`
- 路径参数
  - `userID`: 用户ID

##### 响应

- 成功响应

  - **状态码**: `200 OK`

  - 响应体

    ```
    {
      "code": 200,
      "message": "User deleted successfully."
    }
    ```