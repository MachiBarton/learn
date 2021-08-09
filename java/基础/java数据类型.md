# java 基本数据类型

## 一.  基本类型(primitive type)

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

## 二.  基本类型(reference type)

+ 非基本类型均为引用类型

## <!--什么是字节-->

+ <!--位（bit）：是计算机内部数据存储最小单位。 如：11001100是一个八位二进制数。-->

+ <!--字节（byte）：是计算机数据处理中的基本单位，习惯上用大B来表示。-->

+ <!--字符：是指计算机中使用的字母、数字、字和符号-->

## 三.  数据类型扩展

### 1. 整数拓展

+ 二进制 ：0b10 （2）
+ 八进制 ：010 （8）
+ 十进制 ：10 （10）
+ 十六进制 ：0x10 （16）

```java
 int i  = 0b10;
 int i2 = 010;
 int i3 = 10;
 int i4 = 0x10;

 System.out.println(i);  //2
 System.out.println(i2); //8
 System.out.println(i3); //10
 System.out.println(i4); //16
```
### 2. 浮点数拓展

+ float、double 长度有限 存在舍入误差  接近但不等于。 最好完全避免浮点数比较

### 3. 字符拓展

+ 所有字符本质还是数字，通过Unicode表查找

```java
char c1 = 'A';
char c2 = '吃';
System.out.println((int)c1); //65
System.out.println((int)c2); //21507
```
+ 转义字符：\t 制表符、\n 换行

## 四. 类型转换
低-------------------------------->高（浮点型高于整型）
byte、short 、char --> int --> long --> float --> double
注意点：
1. 不能对布尔值进行转换
2. 不能把对象类型转换为不相干的类型
3. 把高容量转换到低容量的时候，使用强制转换
4. 转换时候可能会存在内存溢出，或者精度问题

```java
        //强制转换 (类型)变量名  高---低
        int i = 128;
        Byte i1 = (byte)128; //内存溢出
        System.out.println(i1);

        // 自动转换  低---高
        int a1 = 1024;
        double d1 = a1;

        System.out.println(d1);
```
