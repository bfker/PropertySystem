# PropertySystem



## 接口文档

### User相关接口

#### 1. 注册用户

- **URL:** `/users/register`
- **Method:** `POST`
- **Request Body:**

```
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "roles": ["USER"]
}
```

- **Response:**

```
{
  "code": 200,
  "message": "User registered successfully",
  "data": {
    "userID": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "roles": ["USER"]
  },
  "success": true
}
```

#### 2. 用户登录

- **URL:** `/users/login`
- **Method:** `POST`
- **Request Body:**

```
{
  "email": "john.doe@example.com",
  "password": "password123"
}
```

- **Response:**

```
{
  "code": 200,
  "message": "Login successful",
  "data": {
    "token": "jwt_token_here"
  },
  "success": true
}
```

#### 3. 获取所有用户

- **URL:** `/users/all`
- **Method:** `GET`
- **Response:**

```
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "userID": 1,
      "name": "John Doe",
      "email": "john.doe@example.com",
      "roles": ["USER"]
    },
    {
      "userID": 2,
      "name": "Jane Smith",
      "email": "jane.smith@example.com",
      "roles": ["ADMIN"]
    }
  ],
  "success": true
}
```

#### 4. 根据ID获取用户

- **URL:** `/users/{userID}`
- **Method:** `GET`
- Path Variable:
  - `userID` (int): 用户ID
- **Response:**

```
{
  "code": 200,
  "message": "success",
  "data": {
    "userID": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "roles": ["USER"]
  },
  "success": true
}
```

#### 5. 更新用户信息

- **URL:** `/users/update`
- **Method:** `PUT`
- **Request Body:**

```
{
  "userID": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "newpassword123"
}
```

- **Response:**

```
{
  "code": 200,
  "message": "User updated successfully",
  "data": {
    "userID": 1,
    "name": "John Doe",
    "email": "john.doe@example.com"
  },
  "success": true
}
```

#### 6. 删除用户

- **URL:** `/users/delete/{userID}`
- **Method:** `DELETE`
- Path Variable:
  - `userID` (int): 用户ID
- **Response:**

```
{
  "code": 200,
  "message": "User deleted successfully",
  "success": true
}
```

### Role相关接口

#### 1. 添加角色

- **URL:** `/roles/add`
- **Method:** `POST`
- **Request Body:**

```
{
  "roleName": "Admin"
}
```

- **Response:**

```
{
  "code": 200,
  "message": "success",
  "data": {
    "roleID": 1,
    "roleName": "Admin"
  },
  "success": true
}
```

#### 2. 获取所有角色

- **URL:** `/roles/all`
- **Method:** `GET`
- **Response:**

```
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "roleID": 1,
      "roleName": "Admin"
    },
    {
      "roleID": 2,
      "roleName": "User"
    }
  ],
  "success": true
}
```

#### 3. 根据ID获取角色

- **URL:** `/roles/{roleID}`
- **Method:** `GET`
- Path Variable:
  - `roleID` (int): 角色ID
- **Response:**

```
{
  "code": 200,
  "message": "success",
  "data": {
    "roleID": 1,
    "roleName": "Admin"
  },
  "success": true
}
```

#### 4. 更新角色

- **URL:** `/roles/update`
- **Method:** `PUT`
- **Request Body:**

```
{
  "roleID": 1,
  "roleName": "Super Admin"
}
```

- **Response:**

```
{
  "code": 200,
  "message": "success",
  "data": {
    "roleID": 1,
    "roleName": "Super Admin"
  },
  "success": true
}
```

#### 5. 删除角色

- **URL:** `/roles/delete/{roleID}`
- **Method:** `DELETE`
- Path Variable:
  - `roleID` (int): 角色ID
- **Response:**

```
{
  "code": 200,
  "message": "success",
  "success": true
}
```
