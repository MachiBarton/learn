# java 基本数据类型

### 1. 整型

+ byte:  1个字节  [ -128 , 127 ]
+ short: 2个字节  [ -2^15^ , 2^15^ - 1]
+ int:      4个字节  [ -2^31^ , 2^31^ - 1 ]

 + long:  8个字节  [ -2^63^ , 2^63^ - 1 ]

### 2. 浮点

+ float:      4个字节 32位 IEEE 754单精度
+ double: 8个字节 64位 IEEE 754单精度

### 3. 字符

+ char:  2个字节  [ unicode 0, unicode 2^16^ - 1]

### 4. 布尔

+ boolean: 1bit

```java
//整数
int   num1 = 10; //最常用
byte  num2 = 20;
short num3 = 30;
long  num4 = 30L; //long 类型要在数字后面加L

//浮点数
float num5 = 50.1F; // float类型后面要加F
double num6 = 3.1415926;

// 字符
char name = 'A';
//字符串, String不是关键字是类，不是基本类型
String name1 = "Hello World";

//布尔值：是非
boolean flag = true;
```