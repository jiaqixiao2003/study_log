## To Be Better Javaer

![img](java_img\tobebetterjavaer-map.png)

## 一. java概述

### 1.特性

- 简单性
  剔除了 C++中 少使用、难理解、易混淆的特别，比如 指针运算、操作符重载、内存管理等

  java可以做到 **堆栈分配、垃圾回收和自动内存管理**

- 可移植性

  java先编译生成**字节码**，再由**JVM（java虚拟机）解释执行**，目的：统一的字节码转成OS可以识别的二进制码，不同的OS有相应版本的JVM，实现可移植性。（一个表示在win 和 Linux下二进制可能是不同的）

- 安全性

  java适用 **网络/分布环境**

  ![image-20250428115241053](java_img\1-安全性.png)

- 并发性

  线程可以利用多个处理器，带来给好的**交互响应和实时行为**

### 2.应用领域

这里只写了下web

- java Web 主流开发框架多：

  Spring框架、Spring MVC、MyBatis、JavaServer Faces、Spring Boot、Spring Cloud；

- 应用：

  桌面应用、Web应用、企业应用（安全性、负载均衡和集群的优势）、移动端应用（主要安卓）

### 3.安装JDK IDEA

（java程序必须允许在JVM之上）

![image-20250603123753562](java_img\jdkjrejvm.png)

#### 3.1 JVM、JRE、JDK之间的关系

- **JDK（Java Development Kit）**用于**开发** Java 应用程序的软件环境。包含运行环境（JRE）和其他java开发所需工具，解释器（java）、编译器（javac）、文档生成器（javadoc）等；
- **JRE（Java Runtime Environment）**用于**运行** Java 应用程序的软件环境。（只运行java程序 只需要JRE即可）；
- **JVM（Jave Virtual Machine），java虚拟机**，由一套字节码指令集、一组寄存器、一个栈、一个垃圾回收堆和一个存储方法域等组成。屏蔽了不同操作系统（macOS、Windows、Linux）的差异性，使得 Java 能够“**一次编译，到处运行**”。



***

## 二. Java 语法基础

### 1. 关键字和保留字 (看一看，见~[关键字]([5000字速通Java的48个关键字及2个保留字 | 二哥的Java进阶之路](https://javabetter.cn/basic-extra-meal/48-keywords.html#_1、abstract)))

#### 1.1 abstract：声明抽象类，和抽象方法

```java
abstract class Animal {
    abstract void makeSound();
    
    public void sleep() {
        System.out.println("The animal is sleeping");
    }
}
// 创建了 Animal的抽象类，包含一个抽象方法makeSound()和具体方法sleep()

class Dog extends Animal {
    void makeSound() {
        Sysout ("The dog barks");
    }
}
```

boolean、bread、continue

`byte`: 表示一个8位（1字节）有符号整数，取值范围：-128~127 （`byte minByte = -128`,  `byte maxByte = 127`）

`short`: 表示短整型，占用2个字节（16位）的内存空间

`long`: bioassay长整数值； `long x = 100000000000L;` 后面要加 L 或 l

try-catch-finally（捕获异常，finally表示无论是否处理异常，总是执行finally块中的代码）

`char c = 'A'`

#### 1.2 final

- **final 变量**：`final double PI = 3.14159265359`: 一旦被赋值，其值不能再被修改
- **final方法**：不能被子类重写的方法
- **final类**：不能被继承的类

#### 1.3 extends & implements 、 super； instanceof

都可以用来继承，且java所有类都继承于`java.lang.Object`

- extends: 类的继承是单一继承，一个子类只能拥有一个父类

- implements：类继承接口的情况，可以同时继承多个接口(`interface`)

  ```java
  public interface A {
      public void eat();
      public void sleep();
  }
  
  public interface B {
      public void show();
  }
  
  public class C implements A,B {
  }
  ```

- super：调用父类的方法或字段 （构造方法）

  ```java
  class Animal {
  	protected String name;
  	public Animal (String name) {
          this.name = name;	// this 在方法或构造方法中引用当前对象
      }
      public void eat() {
          sysout (name + "is eating");
      }
  }
  
  public class Dog extends Animal {
      public Dog(String name) {
  		super(name); //调用父类的构造方法
      }
      
      public void eat() {
          super.eat(); //调用父类的eat方法
          sysout (name + "is eating lalalal.");
      }
  }
  ```

  

`p instanceof A` :判断对象p是否属于某个类型A（class）

#### 1.4 访问权限修饰符public、protected、private

- public：可以声明类、方法、变量 （main()方法必须声明为public）；类中的方法和变量，可以被任何类访问和调用
- protected：表示方法或变量 对同一个package的类和所有子类可见
- private：表示方法或变量只对当前类可见

`static` 静态变量或静态方法：这些属于类的成员，可以通过类名直接访问，不需要创建对象。

#### 1.5 synchronized

指定多线程代码中的同步方法、变量、或代码块

```java
public class MyClass {
    private int count;
    
    public synchronized void increment() {
        count++; // 同步方法
    }
    
    public void doSomething() {
        synchronized(this) { // 同步代码块
            // do
        }
    }
}
```

#### 1.6 transient

修饰的字段不会被序列化

```java
public class MyClass implements Serializable {
    private int id;
    private String name;
    private transient String password;

    public MyClass(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // 省略 getter 和 setter 方法

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

password 成员变量 会被标记为 **transient**， 表示在序列化中**忽略**这个成员变量。（//MyClass 继承了序列化Serializable接口，那么这个对象就可以被序列化，password的**生命周期仅存于调用者的内存中而不会写到磁盘里持久化**）

### 2. 数据类型

#### 2.1 自动类型转换

Tips：自动类型转换只发生在兼容类型之间。（从较小的数据类型到较大的数据类型是安全的）

```markdown
byte -> short -> int -> long -> float -> double
char -> int -> long -> float -> double
```

"**表达式中类型的自动提升**" （int * float * double ==》结果为double类型）

```java
byte b = 50;
b = b * 2;	// error: Type mismatch: cannot convert from int to byte

byte b = 50;
b = (byte)(b * 2); 	// √

byte b = 50;
b *= 2;	// √  等价于 上面
```

#### 2.2 强制类型转换

显示转为，可能会导致数据丢失或精度降低

```markdown
double -> float -> long -> int -> char -> short -> byte		
```

#### 2.3 基本数据类型缓存池

`new Integer(18)` vs `Interger.valueOf(18)`

- `new Integer(18)`：每次创建一个新的对象；
- `Integer.valueOf(18)`：使用缓存池中的对象，多次调用只会取同一一个对象的引用。

```java
Integer x = new Integer(18);
Integer y = new Integer(18);
System.out.println(x == y);		// false

Integer z = Integer.valueOf(18);
Integer k = Integer.valueOf(18);
System.out.println(z == k); 	// true

Integer m = Integer.valueOf(300);
Integer p = Integer.valueOf(300);
System.out.println(m == p);		// false ????????? 
```

**解释**：Integer类内部内置了 256个 integer类型的缓存数据，（-128~127），在该范围内会直接返回常量池中数据的引用，当超过该范围时，会**创建新的对象**(范围内)。 

使用`Integer.valueOf()`方法获取整数对象时，会先检查该整数，是否在IntegerCache中，从而决定是否创建一个新的对象并缓存起来；

使用`new Integer()`创建对象，不会被缓存，每次都会创建新的对象。推荐`Integer.valueOf()`方法获取整数。

**”Tips“：终端命令 `java -ea`启用断言`assert`**

### 3. 运算符 流程控制

- +、- 、* 、/、% ；

Tips：浮点数 除以0的时候，结果为**Infinity（无穷大，10.0/0.0）或 NaN （Not a Number，0.0/0.0**）；

整数 除以 0 时 会报错；

- 前自增（自减）++x（--x），先加（减）再计算；后自增（自减）x++（x--），先计算再自加（自减）

- 关系运算符

#### 3.2  **位运算符** 

  - ```java
    // 转换为二进制
    Integer.toBinaryString(60); 	// 111100
    Integer.toBinaryString(13);		// 1101
    ```

  - ![img](https://cdn.tobebetterjavaer.com/tobebetterjavaer/images/core-grammar/eleven-03.png)

  - 与&；或|；非~；异或^;

```java
int a = 60, b = 13;
System.out.println("a 的二进制：" + Integer.toBinaryString(a)); // 111100
System.out.println("b 的二进制：" + Integer.toBinaryString(b)); // 1101

int c = a & b;	// 12 1100
System.out.println("a & b：" + c + "，二进制是：" + Integer.toBinaryString(c));

c = a | b;		// 61 111101
System.out.println("a | b：" + c + "，二进制是：" + Integer.toBinaryString(c));

c = a ^ b;		// 49 110001
System.out.println("a ^ b：" + c + "，二进制是：" + Integer.toBinaryString(c));

c = ~a;			// -61，二进制是：11111111111111111111111111000011
System.out.println("~a：" + c + "，二进制是：" + Integer.toBinaryString(c));

c = a << 2;		//	11110000
System.out.println("a << 2：" + c + "，二进制是：" + Integer.toBinaryString(c));

c = a >> 2;		// 15 1111
System.out.println("a >> 2：" + c + "，二进制是：" + Integer.toBinaryString(c));

c = a >>> 2;	// 15 00111100
System.out.println("a >>> 2：" + c + "，二进制是：" + Integer.toBinaryString(c));
```

- **按位左移运算符号**：<<

  `x << 2` ==> x * 2 ^ 2; `x << 3` ==> x * 2 ^ 3

- **按位右移运算符号**：>>

  `x >> 2` ==> x / 2 ^ 2; `x >> 3` ==> x / 2 ^ 3

#### 3.3 **逻辑运算符**

逻辑与（&&）；逻辑或（||）； ==》 **判定结束后，不会再检查后面的结果；**

逻辑非（！）；逻辑异或（^）,相异为true，相同为fasle；

单逻辑与（&）；单逻辑或（|）（**也会检查第二个条件**）；==》 **先运算，再判断结果**



赋值运算符：主要，类型 short计算时注意强转；边界问题；

#### 3.4 for-each

普遍用于遍历**数组和集合**；

```java
for(元素类型 元素 : 数组或集合){
    //
}
```

### 4. 语法基础练习题：

#### 4.1 整数翻转 ~([7. 整数反转 - 力扣（LeetCode）](https://leetcode.cn/problems/reverse-integer/description/))：

给定一个32位有符号整数，将整数终端数字进行反转 （LeetCode 7：）

如果反转后整数超过 32 位的有符号整数的范围 `[−231, 231 − 1]` ，就返回 0。

sample1：

```
输入：123
输出：321
```

sample2：

```
输入：-123
输出：-321
```

Tips：**Integer溢出判断：**

```java
//判断int 减法 是否溢出
x = Integer.MIN_VALUE;
if(x > Integer.MAX_VALUE + 1 || x<Integer.MIN_VALUE + 1){
     System.out.println("x = " + x);
     System.out.println("x - 1溢出");
}
//判断int 乘法 是否溢出
x = Integer.MAX_VALUE;
if(x > Integer.MAX_VALUE / x || x<Integer.MIN_VALUE / x){
     System.out.println("x = " + x);
     System.out.println("x * x溢出");
}
```

**Answer:**

```java
public static int ReverseInt(int x) {
    int res = 0;
    // 需要检查边界条件
    while (x != 0 ) {
        int temp = x % 10;
        x = x /10;


        // 这里只检查了 * 10 是否溢出，还未检查temp
        if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
            return 0;
        // 检查temp
        if ((res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10 )
            || (res == Integer.MIN_VALUE / 10) && temp < Integer.MIN_VALUE % 10)
            return 0;
        res = res * 10 + temp;
    }
    return res;
}
```

#### 4.2 字符串转换整数（atoi）[8. 字符串转换整数 (atoi) - 力扣（LeetCode）](https://leetcode.cn/problems/string-to-integer-atoi/description/)

请你来实现一个 parseInt 方法，使其能将字符串转换成整数

要求：

- 示例1：`input: "42"; output: 42`
- 示例2：`input: "  -42"; output: 42`
- 示例3：`input: "4193 with words"; output: 4193`
- 示例4：`input: "912834723332"; output: 2147483647`(超出Integer.MAX_VALUE)
- 示例4：`input: "words and 987"; output: 0`

Tips: 获取当前数字：`int num = str.charAt(now) - '0';`

**Answer:**

```java
public static int parseInt(String s) {
    int res = 0;
    // 遍历字符串；标记符号；
    int index = 0;
    int sign = 1;

    // 避开空格
    while(index < s.length() && s.charAt(index) == ' ')
        index ++;
    // 判断正负, 并注意index位置，str可能为空“”或“ ”
    if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
        sign = s.charAt(index) == '+' ? 1 : -1;
        index++;
    }

    while(index < s.length()) {
        int num = s.charAt(index) - '0';
        if (num < 0 || num > 9)
            break;
        //检查溢出 要考虑正负；
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10))

            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        res = res*10 + num;
        index++;
    }
    res *= sign;
    return res;
}
```



## 三. 数组 & 字符串

### 1. 数组

```java
// 声明方式
int[] anArray; 		//推荐
int otherArray[];
// 初始化
int[] anArray = new int[10];	//指定长度，默认值 int为0
int[] anArray = new int[] {1,2,3};	//直接初始化元素

// 遍历数组 ①
for(int i = 0; i < anArray.length(); i++) {
    System.out.println(anOtherArray[i]);
}
// 遍历数组 ②
for (int arr : anArray) {
    System.out.println(arr);
}
```

#### 1.1 可变参数与数组

可将任意任意数量的参数传递给方法

```java
public class VarargsDemo {
    public VarargsDemo() {}
    
    transient void varargsMethod(String as[]) {
        
    }
}

VarargsDemo demo = new VarargsDemo();
String[] anArray = new String[] {"111", "2222"};
demo.varargsMethod(anArray);
// 也可以直接传递多个字符串
demo.varagsMethod("111", "2222");
```

#### 1.2 数组与List

List封装了很多常用方法，方便对集合进行操作；often 需要，数组==》List

- 方式1：遍历数组，一个个添加到List中

  ```java
  int[] array = new int[] {1, 2, 3, 4, 5};
  
  List<Integer> aList = new ArrayList<>();
  for (int num: array) {
      aList.add(num);
  }
  ```

- 方式2：Arrays类 的`asList()`方法

  ```java
  List<Integer> aList = Arrays.asList(array);		// int 会报错
  Integer[] arr = new Integer[] {1, 2, 3};
  List<Integer> list = Arrays.asList(arr);		// Integer √
  ```

  注意：`Arrays.asList()`的参数需要的 **Integer** 数组，而不是 int[]：可以采用下面的方式：

  ```java
  // 方式1
  List<Integer> aList = Arrays.asList(1, 2, 3, 4, 5);
  // 方式2
  List<Integer> aList = Arrays.strem(array).boxed().collect(Collectors.toList());
  ```

  **注：**方式2涉及到java流的知识；

  **注：**Arrays.asList方法返回的ArrayList并不是 `java.util.ArrayList`,而是Arrays类的一个内部类；如果要添加元素或删除元素，需要把它转成 `java.util.ArrayList`

  ```java
  new ArrayList<>(Arrays.asList(anArray));
  
  // java8 新增 Steam流的概念，可以将数组转成Steam进行操作
  String[] array = new String[]{"111", "dasd", "lalala"};
  Stream<String> aStream = Arrays.stream(array);
  ```


#### 1.3 数组的排序与查找

Arrays类 提供了 `sort()`方法

- 基本数据类型按照**升序排列**
- 实现了 Comparable接口的 对象按照 `compareTo()`的排序

```java
int[] array = new int[] {5, 2, 1, 4, 8};
Arrays.sort(array);
// out:[1, 2, 4, 5, 8]

String[] array2 = new String[] {"A", "E", "Z", "B", "C"};
Arrays.sort(array2, 1, 3, Comparator.comparing(String::toString).reversed());
// out: [A, Z, E, B, C];
// 对1-3位置上的元素进行反序
// 不需要后面这些 Comparator。。。。也ok
```

- **查找：**遍历 or 二分（需有序数组）

```java
int[] array = new int[] {5, 2, 1, 4, 8};
for (int i = 0; i < array.length; i++) {
    if (array[i] == 4) {
        System.out.println(array[i] + "位置：" + i);
        break;
    }
}
// out：4位置：3；
```

若数组有序，就可以使用二分法查找，这样效率会刚高一些；`Arrays.binarySearch()`

```java
Arrays.sort(array);
int index = Arrays.binarSearch(array, 4);
// 输入： 一个数组 和 要查找的元素； 输出：index
// 若没有，则index是负数
```

- 复制数组

```java
int[] array1 = {1, 2, 3};
int[] array2 = {4, 5, 6};

int[] mergeArray = new int[array1.length + array2.length];

// 复制方式1：System.arraycopy
System.arraycopy(array1, 0, mergeArray, 0, array1.length);
System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
// out: 1,2,3,4,5,6

// 复制方式2： 循环
int index = 0;
for (int num : array1) {
    mergeArray[index++] = num;
}
for (int num : array2) {
    mereArray[index++] = num;
}
```

#### 1.4 杨辉三角

```java
import java.util.Scanner;

public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);		// 键盘输入
        System.out.print("请输入要打印的行数： ");
        int n = scan.nextInt();
        printTraiangle(n);
}

public static void printTraiangle(int n) {
    int[][] yanghui = new int[n][n];
    for (int i = 0; i < n; i++) {
        // 第一行和最后一行均为0
        yanghui[i][0] = 1;
        yanghui[i][i] = 1;
        for (int j = 1; j < i; j++) {
            yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int k = 0; k < n - i - 1; k++) {
            System.out.print(" "); 
        }
        for (int j = 0; j <= i; j++) {
            System.out.print(yanghui[i][j] + " ");
        }
        System.out.println();
    }
}
```

out：

```java
请输入要打印的行数： 6
     1 
    1 1 
   1 2 1 
  1 3 3 1 
 1 4 6 4 1 
1 5 10 10 5 1 
```

#### 1.5 打印数组

- stream流打印（查资料吧，有些没见过）

- for 循环

- Arrays工具类打印

  - 一维数组：`Arrays.toString()`方法

    ```java
    String [] cmowers = {"沉默","王二","一枚有趣的程序员"};
    System.out.println(Arrays.toString(cmowers));
    
    // [沉默, 王二, 一枚有趣的程序员]
    ```

  - 二维数组：`Arrays.deepToString()`方法

    ```java
    String[][] deepArray = new String[][] {{"沉默", "王二"}, {"一枚有趣的程序员"}};
    System.out.println(Arrays.deepToString(deepArray));
    
    // [[沉默, 王二], [一枚有趣的程序员]]
    ```

### 2. 字符串

#### 2.1 字符串源码 [深入解读String类的源码 ](https://javabetter.cn/string/string-source.html#string-类的-hashcode-方法)

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
```

- String类是final的，意味着它不能被子类继承；

- String类实现了 `Serializable`接口，意味着可以 序列化

- String类实现了 `Comparable` 接口，意味着 最好不要用 `==` 来比较两个字符串是否相等，而应该用`compareTo()` 方法去比较；

  （`==` 比较两个对象的地址，若要比较字符串内容，可以使用String类的`equals()`方法==》String转换为char[]，挨个比较；）

- String类实现了 `CharSequence` 接口，由于String是不可变的，遇到字符串拼接的时候，可以考虑 `StringBuffer, StringBuilder`，这两个是可变的，也实现了`CharSequence`接口

Tips：**String的底层由char数组优化为byte数组（Java9开始）**

java9之前：`private final char value[]`, ,之后改成 byte型数组，并增加了coder来表示编码，在节省内存的同时引入了编码检测的开销。

```java
// java9 之后的方式； 单字节字符集 内存减少一半
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    @Stable
    private final byte[] value;
    private final byte coder;
    private int hash;
}
```

同时：**GC** 次数也会减少，即**垃圾回收**

注： `char[], byte[]` 会进行区分，**中文是两个字节，英文是一个字节**；（java9之前均用char数组，两个字节）

#### 2.2 前面hash等等“31倍哈希法”见链接，substring()方法

```java
public String substring(int beginIndex) {
    // 检查启示索引是否小于0
    if (beginIndex < 0) {
        throw new StringIndexOutOfBoundsException(beginIdx);
    }
    // 计算子穿长度
    int subLen = value.length - beginIndex;
    if(subLen < 0){
        throw new StringIndexOutOfBoundsException(subLen);
    }
    return (begin == 0) ? this : new String(value, beginIndex, subLen);
}
```

- 提取一段字段：

  ```java
  String str = "Hello, world";
  String subStr = str.substring(7,12); // "world"
  
  String preStr = str.substring(0, 5); // "Hello"
  String sufStr = str.substring(7); // world
  ```

- 处理空格和分隔符

  ```java
  String str = "   Hello,   world!  ";
  String trimmed = str.trim();                  // Hello,   world! （去开头和结尾空格）
  String[] words = trimmed.split("\\s+");       // Hello, world! 将字符串按照空格分隔成单词数组
  String firstWord = words[0].substring(0, 1);  // 提取第一个单词的首字母
  System.out.println(firstWord);                // 输出 "H"
  ```

  **\\\s+表示匹配一个或多个 空格**

  ```java
  String str = "1234-5678-9012-3456";
  String[] parts = str.split("-");
  ```

#### 2.3 indexOf() 方法

查找一个子字符串在原串中第一次出现的位置，返回该位置索引

```java
String str = "Hello, world!";
int index1 = str.indexOf("o");    // 查找 "o" 子字符串在 str 中第一次出现的位置
int index2 = str.indexOf("o", 5); // 从索引为5的位置开始查找 "o" 子字符串在 str 中第一次出现的位置
System.out.println(index1);       // 输出 4
System.out.println(index2);       // 输出 8
```

#### 2.4 其他方法

- `length()`，返回字符串长度；

- `isEmpty()`，判断字符串是否为空；

- `charAt()`，返回指定索引处的字符；

- `valueOf()`，将其他类型的数据转换为字符串;（底层调用的是 包装器的toString方法）

  ```java
  String str = String.valueOf(123); // 底层调用的是Integer类的toString方法
  ```

- `getBytes()`，返回字符串的字节数据，可以指定编码方式：

  ```java
  String text = "沉默王二";
  System.out.println(Arrays.toString(text.getBytes(StandardCharsets.UTF_8)));
  ```

- `trim()`方法去除字符串两侧空白字符

- `toCharArray()` 将字符串转换为字符数组

  ```java
  String name = "肖佳琦";
  char[] arr = name.toCharArray();
  for (char a:arr){
      System.out.println(a);
  }
  ```

#### 2.5 无重复字符的最长字串[3. 无重复字符的最长子串 - 力扣（LeetCode）](https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/)

- 暴力解法

  ```java
  public static int solutin(String str) {
      int length = 0;
      if (str.length() == 1) {
          return 1;
      }
      for (int i = 0; i < str.length()-1; i++) {
          boolean[] judge = new boolean[128];
          judge[str.charAt(i)] = true;
          for (int j = i+1; j < str.length(); j++) {
              if (judge[str.charAt(j)]) {
                  length = Math.max(length, j-i);
                  break;
              }
              judge[str.charAt(j)] = true;
              length = Math.max(length, j - i+1);
          }
      }
      return length;
  }
  
  // 暴力二，从当前位置往前
  public static int solutin(String str) {
      int length = 0;
      for (int i = 0; i < str.length(); i++) {
          boolean[] judge = new boolean[128];
          for (int j = i; j >= 0; j--) {
              if (judge[str.charAt(j)]) {
                  break;
              }
              judge[str.charAt(j)] = true;
              length = Math.max(length, i - j + 1);
          }
      }
      return length;
  }
  ```

- 双指针 （可以+哈希）

  遇到重复的，要从左边收缩窗口

  ```java
  public static int solutin(String str) {
      if (str == null || str.length() == 0) return 0;
      boolean[] arr = new boolean[128];
      int length = 0;
      int start = 0, end = 0;
      while(end < str.length()) {
          // 如果已经存在，则处理start
          while (arr[str.charAt(end)]) {
              arr[str.charAt(start++)] = false;
          }
  
          arr[str.charAt(end++)] = true;
          length = Math.max(length, end - start);
      }
  
      return length;
  }
  ```

#### 2.6 字符串不可变；字符串常量池

值是被`final`修饰的，String不会有子类；Sting的数据存储在 `char[]` 数组中，这个数组也在final修饰，表示String对象也没办法修改，只要初始化一次，值就确定了； == 》 **安全性，保证哈希值不会频繁变更，实现字符常量池** （具有相同内容的字符串可以指向同一个String对象，节省内内存空间）

```java
String text1 = "沉默王二";
String text2 = "沉默王二";

// 计算字符串 text1 的哈希值，此时会进行计算并缓存哈希值
int hashCode1 = text1.hashCode();
System.out.println("第一次计算 text1 的哈希值: " + hashCode1);

// 再次计算字符串 text1 的哈希值，此时直接返回缓存的哈希值
int hashCode1Cached = text1.hashCode();
System.out.println("第二次计算: " + hashCode1Cached);

// 计算字符串 text2 的哈希值，由于字符串常量池的存在，实际上 text1 和 text2 指向同一个字符串对象
// 所以这里直接返回缓存的哈希值
int hashCode2 = text2.hashCode();
System.out.println("text2 直接使用缓存: " + hashCode2);


// output：
第一次计算 text1 的哈希值: 867758096
第二次计算: 867758096
text2 直接使用缓存: 867758096
```

- `substring(), concat(), repalce()`: 都不是在原有的字符串上进行的，结构都返回一个新的String对象。（原字符串对象没有发生改变）

**Q：下行代码创建了几个对象：**

`String s = new String("啦啦啦");`

使用 new 创建字符串对象时，**JVM**首先会在**字符串常量池**中查找是否存在 ”啦啦啦“，如果有，就不会再字符串常量池中创建 该对象，直接在**堆** 中创建该字符串对象，将堆中”啦啦啦“对象地址赋值给变量s；**（创建一次）**

如果 字符串常量池 中没有，则现在 字符串常量池中创建  ”啦啦啦“ 字符串对象，然后再在 堆中创建一个 ”啦啦啦“, 将堆中的对象 赋值给 s；**（创建2次）**

![String s = new String("二哥")](../java_test\java_img\字符串常量池.png)

Tips：**栈上存储的是基本数据类型的变量和对象的引用，对象本身存储在堆上**

所以，通常情况下，采样双引号的方式来创建字符串对象，而不通过new的方式（字符串使用频率高，因此JVM特意为字符串开辟了新的空间 --  字符串常量池）

`String s = "lalala";`这种方式会直接避开 堆， 在字符串常量池中进行查找，没有在常量池中创建，然后将地址赋值给s；

```java
String s = new String("lalala");
String s1 = new String("lalala");
// 创建3个对象，常量池1个，堆中两个
String s2 = "lala";
String s3 = "lala";
// 创建一个对象，常量池中
```

#### 2.7 String.intern()、StringBuilder、StringBuffer

**1.String.intern()**

 Java 7 之后呢，由于字符串常量池放在了堆中，执行 `String.intern()` 方法的时候，**如果对象在堆中已经创建了，字符串常量池中就不需要再创建新的对象了**，而是**直接保存堆中对象的引用**，也就节省了一部分的内存空间。

```java
String s1 = new String("啦啦啦");
String s2 = s1.intern();
System.out.println(s1 == s2);
// False
```

上述代码：

- 首先，字符串常量池创建 ”啦啦啦“对象，然后堆中创建 ”啦啦啦“对象，`s1`的引用是堆中的对象；
- 第二行，`s1.intern()`，该方法从**字符串常量池查找字符串之后存在**，此时是存在的，所以`s2`引用的是字符串常量池中的对象

```java
String s1 = new String("二哥") + new String("三妹");
String s2 = s1.intern();
System.out.println(s1 == s2);
// True
```

- 首先， 字符串常量池 创建 ”二哥“ ”三妹“，然后堆中创建两个**匿名对象**，以及”二哥三妹“，s1引用的是 堆中 ”二哥三妹“这个对象
- 第二行，`s1.intern()`，该方法从常量池 查找”二哥三妹“，此时是不存在的，但是堆中已经存在，所以**字符串常量池中保存的是 堆中 ”二哥三妹“的引用**
- 执行 `new String("二哥") + new String("三妹")` 会创建一个 `StringBuilder`对象，并将两个字符串追加到其中，然后调用`StringBuilder.toString()`将其转换为一个新的字符串对象，即”二哥三妹“
- **`+`操作符：** `new StringBuilder().append("二哥").append("三妹").toString();`

**2.StringBuilder 和 StringBuffer**

StringBuilder的reverse方法：

```java
public AbstractStringBuilder reverse() {
    int n = count - 1; // 字符序列的最后一个字符的索引
    // 遍历字符串的前半部分
    for (int j = (n-1) >> 1; j >= 0; j--) {	// (n-1)>>1 ==> (n-1)/2
        int k = n - j; // 计算相对于 j 对称的字符的索引
        char cj = value[j]; // 获取当前位置的字符
        char ck = value[k]; // 获取对称位置的字符
        value[j] = ck; // 交换字符
        value[k] = cj; // 交换字符
    }
    return this; // 返回反转后的字符串构建器对象
}
```

#### 2.8 N字形变换 [6. Z 字形变换 - 力扣（LeetCode）](https://leetcode.cn/problems/zigzag-conversion/)

将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"PAYPALISHIRING"` 行数为 `3` 时，排列如下：

```
P   A   H   N
A P L S I I G
Y   I   R
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"PAHNAPLSIIGYIR"`。

**示例 1：**

```
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
```

**示例 2：**

```
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```

**示例 3：**

```
输入：s = "A", numRows = 1
输出："A"
```

**提示：**

- `1 <= s.length <= 1000`
- `s` 由英文字母（小写和大写）、`','` 和 `'.'` 组成
- `1 <= numRows <= 1000`

**A1:二维数组模拟**

```java
public static String convert1(String s, int numRows) {
    if (numRows < 2)
        return s;
    char[][] map = new char[numRows][512];
    // 周期：
    int t = 2 * numRows - 2;
    for(int i = 0, x = 0, y = 0 ; i < s.length(); i++) {
        map[x][y] = s.charAt(i);
        if (i % t < numRows - 1) {
            x++;
        } else {
            x--;
            y++;
        }
    }

    StringBuilder res = new StringBuilder();
    for(char[] chars : map) {
        for (char c : chars) {
            if(c != 0)
                res.append(c);
        }
    }
    return res.toString();
}
```

**A2: flag**

```java
public static String convert(String s, int numRows) {
    if (numRows < 2)
        return s;
    List<StringBuilder> rows = new ArrayList<StringBuilder>();
    for (int i = 0; i < numRows; i++) {
        rows.add(new StringBuilder());
    }
    int i = 0, flag = -1;
    for (char c : s.toCharArray()) {
        rows.get(i).append(c);
        if (i == 0 || i == numRows - 1) flag = -flag;
        i += flag;
    }
    StringBuilder res = new StringBuilder();
    for (StringBuilder row : rows) {
        res.append(row);
    }
    return res.toString();
}
```

#### 2.9 字符串相等判断、拼接、拆分

1.相等判断：

等价为`.equals()` 和 `==` 操作符有什么区别

- `==` 用于比较两个对象的**地址是否相等**
- `euqals()` 用于比较两个对象的**内容是否相等** 

```java
String alita = new String("小萝莉");
String luolita = new String("小萝莉");

System.out.println(alita.equals(luolita)); // true
System.out.println(alita == luolita); // false
```

`Objects.equals(a, b)`舒服好用,不需要判断字符串是否为空，上述方法，字符串为空时 会抛出异常；

2.拼接：

- `StringBuilder.append()`方法，而不是 `+`;

  循环体中， `+` 会大量产生StringBuilder对象，不仅占用了更多的内存空间，还会让 Java虚拟机 不停的进行垃圾回收，降低程序性能。

  ```java
  String chenmo = "沉默";
  String wanger = "王二";
  System.out.println((new StringBuilder(chenmo)).append(wanger).toString());
  ```

- `String.concat`拼接字符串

- 类似StringBuilder的`append()`方法

  ```java
  String chenmo = "沉默";
  String wanger = "王二";
  System.out.println(chenmo.concat(wanger));
  ```

  与 `+` 不同，`concat()`遇到字符串为null的时候，会抛出 空指针异常；`+` 会把null当作是“null”来处理

- `String.join()` String类的静态方法

  `String message = String.join("-", "王二", "太特么", "有趣了");`

  第一个参数是 **字符串连接符**，上述结果：王二-太特么-有趣了

3.拆分字符串

- `String.split()`

  注意 一些符号需要正则化表示：`\\.` “.”做分隔符 or `[.]` "[]"来包裹任意字符

  ```java
  String cmower = "沉默王二，一枚有趣的程序员";
  if (cmower.contains("，")) {
      String[] parts = cmower.split("，");
      String[] parts = cmower.split("(?<=，)");  
      String[] parts = cmower.split("(?=，)"); 
  }
  // 第一种：第一部分：沉默王二  第二部分：一枚有趣的程序员
  // 第二种：第一部分：沉默王二， 第二部分：一枚有趣的程序员
  // 第三种：第一部分：沉默王二 第二部分：，一枚有趣的程序员
  ```

  `split("分隔符", num)`，这个num表示 拆分的字符串个数。

## 四. 面向对象编程

### 1. Java中类和对象

#### 1.1 类

- `protected native Object clone() throws CloneNotSupportedException`：naitive 方法，返回此对象的一个副本。默认实现只做浅拷贝，且类必须实现 Cloneable 接口。

  Object 本身没有实现 Cloneable 接口，所以在不重写 clone 方法的情况下直接直接调用该方法会发生 CloneNotSupportedException 异常。

- 多线程调度

  每个对象 都可以调用 Object的 **wait/notify方法来实现等待/通知**机制

  ```java
  public class WaitNotifyDemo {
      public static void main(String[] args) {
          Object lock = new Object();
          new Thread(() -> {
              synchronized (lock) {
                  System.out.println("线程1：我要等待");
                  try {
                      lock.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("线程1：我被唤醒了");
              }
          }).start();
          new Thread(() -> {
              synchronized (lock) {
                  System.out.println("线程2：我要唤醒");
                  lock.notify();
                  System.out.println("线程2：我已经唤醒了");
              }
          }).start();
      }
  }
  ```

- 解释：

  首先，线程1先执行，它调用`lock.wait()`方法，然后进入了等待状态；
  
  随后，线程2后执行，它调用了`lock.notify()`方法，然后线程1被唤醒了
  
  `wait(timeout)`方法会导致当前线程等待（timeout毫秒，如果timeout内没被唤醒，会自己唤醒），直到另一个线程调用此对象的`notify()`或`notifyAll()`方法

#### 1.2 包 package

- 导入一个类的静态字段和静态方法 `import static` （很少用）

  ```java
  import static java long.System.*;
  public class Main {
      public static void main(String[] args) {
          out.println("lalal");
      }
  }
  ```

#### 1.3 变量和方法

- 局部变量

- 成员变量（或称为实例变量、字段）

  在类内部但在方法体外声明的变量；只能通过 **类的实例（对象）**来访问；一个对象实例化后，成员变量的值就确定了，在对象创建时创建，对象销毁时销毁

- 静态变量 `static`

  可以直接被类访问；通常被声明为**常量**外很少使用；存储在静态存储区；

- 常量`final`
  
  常量名通常大写；

**方法：**

访问权限：public（可以被所有类访问）、private（只能在定义它的类中访问）、proteced（可以被同一个包种类，或者不同包中的子类访问）、default（无任何访问权限修饰符，那么它是 **package-private**：该方法只能被同一个包中的类可见）

**实例方法：**

没有static关键字，在类中声明的方法，在调用实例方法前，必须创建类的对象。（相应的 有static的方法成为静态方法）

`getter(),setter()`

**抽象方法**：

没有方法体的方法，总是在抽象类中声明。 `abstract`关键字修饰

#### 1.4 可变参数  `...`；native方法

允许方法使用任意多个、类型相同（is-a）的值作为参数。

```java
public static void main(String[] args) {
    print("沉");
    print("沉", "默");
    print("沉", "默", "王");
    print("沉", "默", "王", "二");
}
// 可变参数
public static void print(String... strs) {
    for (String s : strs)
        System.out.print(s);
    System.out.println();
}
```

- 尽量避免重载带有可变参数的方法；

本地方法（native方法）

**Java Native Interface (JNI)**：允许java代码和其他语言编写的代码进行交互。可以通过JNI，可以通过java调用到os相关的技术实现的库函数上。 （了解一下 没看懂）

`    // 定义本地方法    private native void helloJNI();`  

#### 1.5 构造方法

当类被实例化（new 对象）的时候，就会调用 构造方法。只有当构造方法被调用时，对象才会被分配内存空间。

- 构造方法必须和类名一样
- 构造方法无返回类型
- 不能时abstract、static、final、synchronized
- 可以存在多个构造方法（重载），编译器会通过参数的数量来决定调用哪一个

Tips：**复制一个对象** 

- 通过构造方法

  ```java
  public class CopyPerson() {
      private String name;
      private int age;
      
      public CopyPerson(String name, int age) {
          this.name = name;
          this.age = age;
      }
      
      // 通过构造方法复制对象
      public CopyPerson(CopyPerson person) {
          this.name = person.name;
          this.age = person.age;
      }
  }
  ```

- 通过对象的值 （p2赋值p1）

- 通过Object类的`clone()`方法

  ```java
  // 实现 Cloneable接口的clone()方法
  public class ClonePerson implements Cloneable {
  	private String name;
      private int age;
      
      public ClonePerson(String name, int age) {
          this.name = name;
          this.age = age;
      }
      
      // 实现clone()
      @Override
      protected Object clone() throws CloneNotSupportedException {
          return super.clone();
      }
      
   	public static void main(String[] args) throws CloneNotSupportedException {
          ClonePerson p1 = new ClonePerson("啦啦啦", 22);
          
          ClonePerson p2 = (ClonePerson)p1.clone();
      }
  }
  ```

Tips: 类实例化的时候执行**代码初始化块**，（是放在构造方法中执行的）

Tips：**静态初始化块**会在类 加载时执行，只会执行一次，优先于实例初始化和构造方法

#### 1.6 抽象方法



















