## To Be Better Javaer

![img](./java_img\tobebetterjavaer-map.png)

## 一. java概述

### 1.特性

- 简单性
  剔除了 C++中 少使用、难理解、易混淆的特别，比如 指针运算、操作符重载、内存管理等

  java可以做到 **堆栈分配、垃圾回收和自动内存管理**

- 可移植性

  java先编译生成**字节码**，再由**JVM（java虚拟机）解释执行**，目的：统一的字节码转成OS可以识别的二进制码，不同的OS有相应版本的JVM，实现可移植性。（一个表示在win 和 Linux下二进制可能是不同的）

- 安全性

  java适用 **网络/分布环境**

  ![image-20250428115241053](./java_img\1-安全性.png)

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

![image-20250603123753562](./java_img\jdkjrejvm.png)

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

#### 1.6 抽象类 、接口

- **抽象类 `abstract class 类名 {}`**

  - 类名：“使用 Abstract 或 Base 开头”
  - 类是抽象的，不能实例化。但可以由子类，通过`extends`继承抽象类
  - 如果一个类定义了一个或多个抽象方法，那这个类必须是抽象类

  ```java
  public abstract class AbstractPlayer {
  	abstract void play();
      
      public void sleep(){
          System.out.println("抽象类中的普通方法");
      }
  }
  ```

  - 抽象类的子类必须实现父类中定义的抽象方法。

  ```java
  public class VolleyPlayer extends AbstractPlayer {
  	@override
      void play(){
          System.out.println("排球运动员，玩");
      }
  }
  ```

- **接口 `interface`**

  - 可以包含一些常量和方法 

  ```java
  public interface Electronic {
      // 常量
      String LED = "LED";  // ==> public static final String LED = "LED"
      
      // 抽象方法
      int getElectricityUse();
      // 等价：public abstract int getElectricityUse();
      
      // 静态方法 、 默认方法
      static boolean isEnergyEfficient(String electronicTyepe){
          return electronicType.equals(LED);
      }
      
      default void printDescription(){
          Syetem.out.println("电子");
      }
  }
  ```

  - 接口中的变量 编译时会 自动加上 **`public static final`修饰**
  - 接口中的方法 编译时会 自动加上 **`public abstract`** 修饰（抽象方法）
  -  没有使用`private`、`default`、或`static` 修饰的方法是**隐式抽象**的
  - 接口不允许直接实例化，可以是空的（Serializable接口 `java.io`中）

- Java原则上只支持单一继承，但通过接口可以实现多重继承的目的。

- **多态：**

  - 三个前提：要有继承关系、子类要重写父类的方法、父类引用指向子类对象。

  ```java
  public interface Shape{
      String name();
  }
  
  public class Circle implements Shape {
      @Override
      public String name(){
          return "yuan";
      }
  }
  
  public class Square implements Shape {
      @Override
      public String name(){
          return "fang";
      }
  }
  
  // test:
  List<Shape> shapes = new ArrayList<>();
  Shape cirShape = new Circle();
  Shape squShape = new Square();
  shapes.add(cirShape);
  shapes.add(squShape);
  for (Shape shape : shapes) {
      System.out.println(shape.name());
  }
  // output：yuan \n fang
  ```

- **接口的设计模型：策略模式、适配器模式、工厂模式**

  - **策略模式**：针对一组算法，将每一种算法**封装到具有共同接口的实现类中**，接口的设计者可以在不影响调用者的情况下对算法做出改变。

  ```java
  / 接口：教练
  interface Coach {
      // 方法：防守
      void defend();
  }
  // 何塞·穆里尼奥
  class Hesai implements Coach {
      @Override
      public void defend() {
          System.out.println("防守赢得冠军");
      }
  }
  // 德普·瓜迪奥拉
  class Guatu implements Coach {
      @Override
      public void defend() {
          System.out.println("进攻就是最好的防守");
      }
  }
  // 策略模式： Demo可以理解为实现类
  public class Demo {
      // 参数为接口
      public static void defend(Coach coach) {
          coach.defend();
      }
      public static void main(String[] args) {
          // 为同一个方法传递不同的对象
          defend(new Hesai());
          defend(new Guatu());
      }
  }
  // 或者可以在另一个测试类中，假设Demo test = new Demo(), 那么test.defend(new 对象())；
  ```

  `Demo.defend()`方法可接受不同风格的Coach，并**根据所传递的参数对象不同产生不同的行为**。**策略模式** 

  - **适配器模式**：针对调用者的需求对原有的接口进行转接

  ```java
  interface Coach {
      void defend();
      void attack();
  }
  
  // 抽象类实现接口，并置空方法,抽象类的普通方法：
  abstract class AdapterCoach implements Coach {
      public void defend() {};
      public void attack() {};
  }
  
  // 新类继承适配器
  class Hesai extends AdapterCoach {
      public void defend() {
          System.out.println("防守赢得冠军");
      }
  }
  
  public class Demo {
      public static void main(String[] args) {
          Coach coach = new Hesai();
          coach.defend();
      }
  }
  ```

  Coash接口中定义了两个方法（`defend()`和 `attack()`），如果直接实现该接口，则需要对两个方法进行实现。因此采用 一个**抽象类作为中间件，即适配器**，抽象类实现接口，并 **将方法置空**，这样新的类可以绕开接口，继承抽象类，实现只对需要的方法进行覆盖。**适配器模式**

  - **工厂模式**：什么工厂生产什么

  上文例子：工厂模式：教练接口（用来指挥）、学院接口（产生教练）

  ```java
  public class Demo {
      public static void create(CoachFactory factory) {
          factory.createCoach().command();
      }
      
      public static void main(String[] args) {
          // 对于一支球队来说，需要什么样的教练就去找什么样的学院
          // 学院会介绍球队对应水平的教练。
          create(new ACoachFactory());
          create(new CCoachFactory());
      }
  }
  ```

  需要A教练了，就到A学院去找教练。

#### 1.7 内部类：成员内部类、局部内部类、匿名内部类、静态内部类

- 成员内部类：

  - 内部类可以无限制访问外部类的所有成员属性；
  - 外部类要访问内部类的对象，必须先new一个内部类对象，再通过这个对象来访问。
  - 静态方法中，要访问某个类的内部类，必须先创建一个外部类对象，在通过该对象创建内部类对象

- 局部内部类：定义在一个方法或一个作用域中的类

  - 类似于局部变量，不能被 权限修饰符修饰。

- **匿名内部类**：（用的多，启动多线程的时候经常使用）

  ```java
  public class ThreadDemo{
      public static void mian(String[] args) {
          Thread t = new Thread(new Runnable()) {
              @Override
              public void run(){
                  System.out.println(Thread.currentThread().getName())
              }
          });
          t.start();
      }
  }
  ```

  - 唯一一种没有构造方法的类。
  - 主要作用是用来继承其他类或者实现接口。

- 静态内部类：与成员内部类类似，用`static`修饰

  ```java
  public class Wangsi {
      static int age;
      double money;
      
      static class Wangxxiaosi {
          public Wangxxiaosi (){
              System.out.println(age);
          }
      }
  }
  ```

  - 由于`static` 静态内部类不允许访问外部类中 **非static**的变量和方法

#### 1.8 三大特性：封装、继承、多态

- **封装**

- **继承**

  - java只支持单继承extends，可以通过实现接口达到多继承的目的 （内部类、多层继承、实现接口）

  - 方法重写`@Override` （外壳不变，核心内容重写）；方法重载`@Overload` （方法名形同，但参数不一致）;

  - `Object`类时所有类层次结构的根类，隐式继承Obeject类，有一个无参构造方法；

    像 toString()、equals()、hashCode()、wait()、notify()、getClass()等都是 Object 的方法。

  - 初始化顺序：父类中静态成员变量、静态代码块 =》 子类中静态成员变量、静态代码款 ==》父类普通成员变量和代码块、构造方法 ==》 子类普通成员变量和代码块、构造方法

- **多态** 

  ```java
  public class Wangxiaosan extends Wangsan {
      private int age = 3;
      public Wangxiaosan(int age) {
          this.age = age;
          System.out.println("王小三的年龄：" + this.age);
      }
  
      public void write() { // 子类覆盖父类方法
          System.out.println("我小三上幼儿园的年龄是：" + this.age);
      }
  
      public static void main(String[] args) {
          new Wangxiaosan(4);
      }
  }
  
  class Wangsan {
      Wangsan () {
          System.out.println("上幼儿园之前");
          write();
          System.out.println("上幼儿园之后");
      }
      public void write() {
          System.out.println("老子上幼儿园的年龄是3岁半");
      }
  }
  // out：
  // 上幼儿园之前
  // 我小三上幼儿园的年龄是：0 （父类的构造方法，wirte的方法被子类重写了，但父类中无age，默认值为0）
  // 上幼儿园之后
  // 王小三的年龄：4
  ```

#### 1.9 this和super关键字

**this关键字** 最常用的一个：作为引用变量，指向当前对象此外：

- 调用当前类的方法；

- `this()`调用当前类的构造方法

  `this()`要放在构造方法的第一行；

- 可以作为参数在方法（包括构造方法）中传递；

- 可以作为方法的返回值，返回当前类的对象。

**super关键字** 

- 指向父类对象
- 调用父类对象
- `super()`可以调用父类的构造方法

#### 10. static关键字

**方便在没有创建对象的情况下调用**

- 静态变量：

  只在类加载的时候获取一次内存空间

  ```java
  public class Student {
      String name;
      int age;
      static String school = "郑州大学";
  
      public Student(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public static void main(String[] args) {
          Student s1 = new Student("沉默王二", 18);
          Student s2 = new Student("沉默王三", 16);
      }
  }
  ```

  s1 和 s2 引用变量存放在 **栈（stack）**，两个对象存放在 **堆（heap）**，school静态变量放在静态区。

  **注意**：静态变量 属于一个类，不要通过对象引用来访问，应该**直接通过类名来访问**

- 静态方法：

  （静态方法可以访问静态变量，但不允许访问非静态变量和方法）

- 静态代码块：初始化一些静态变量，优先于`main()`方法致性

#### 11. final 关键字

- final 变量

  final变量一旦初始化，就无法更改；

  final修饰的成员变量必须有一个默认值；

  ```java
  public class Pig {
     private String name;
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  // 定义一个final对象
  final Pig pig = new Pig();
  // 不能对pig重新赋值 pig = new Pig(); // ×
  // 但是仍然可以通过set方法修改pig对象的name
  final Pig pig = new Pig();
  pig.setName("特立独行");
  System.out.println(pig.getName()); // 特立独行
  ```

  final 和 static 一起修饰的成员变量： **常量**，全部大写表示；

- final方法：

  被 final修饰的方法不能被重写； （Thread类的`isAlive()`方法就是final的，用于确认线程是否处于活跃状态）

- final类：

  final类无法被继承；（String类就是final：为了实现字符常量池、线程安全、HashCode的不可变性）

  类是final的 $\neq$ 类的对象是不可变的；  

#### 12. instanceof关键字

`(object) instanceof (type)` 判断对象是否符合制定的类，结果：`true / false`;

```java
class A{ }
class B extends A{}

A a = new A();
System.out.println(A instanceof B);	// true，因为A 继承了B
```

- 当A 继承 B时，A `instanceof `B 即为true；
- 当A 实现接口C时，A `instanceof` C 即为true；

通常这样操作`instanceof`： 先判断类型，再强转

```java
if (obj instanceof String) {
    String s = (String) obj;
}
```

- Tips：JDK16之后: 简洁省略。

  ```java
  if (obj instanceof String s) {
      // 如果类型匹配，直接使用s
  }
  ```

#### 13 Java中不可变对象：

- 不可变类（immutable）：类的对象再通过构造方法创建后状态不会再改变，赋值仅在构造方法中完成，不会提供任何setter方法供外部修改。
  - 确保类是final的，不允许被继承；
  - 确保所有成员变量（字段）是final的，只能在构造方法中初始化值，并不能被修改；
  - 不提供setter方法；
  - 如果要修改类的状态，必须返回一个新的对象。
- String类：1）常量池的需要；2）hashCode的需要；3）线程安全。（Integer、Long等也是不可变类）

```java
public class Book {
    private String name;
    private int price;
    
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
		return "Book{" + "name= '" + name + '\'' + ", price= " + price + '}';	
    }
}

public final class Writer {
    private final String name;
    private final int age;
    private final Book book;

    public Writer(String name, int age, Book book){
        this.name = name;
        this.age = age;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Book getBook() {
        Book clone = new Book();
        clone.setPrice(this.book.getPrice());
        clone.setName(this.book.getName());
        return clone;
    }
}

    public static void main(String[] agrs) {
        Book book = new Book();
        book.setName("二哥的 Java 进阶之路");
        book.setPrice(79);

        Writer writer = new Writer("王二", 22, book);
        System.out.println("定价：" + writer.getBook());
        Book b2 = writer.getBook();
        b2.setPrice(59);
        System.out.println("促销价：" + writer.getBook());
        System.out.println("促销价：" + b2);
    }
//定价：Book{name= '二哥的 Java 进阶之路', price= 79}
//促销价：Book{name= '二哥的 Java 进阶之路', price= 79}
//促销价：Book{name= '二哥的 Java 进阶之路', price= 59}
```

#### 14. @Override 方法重写  和 @Overload 方法重载的区别

一个类中 有多个**名字相同但参数个数不同的方法**==》**方法重载**

子类具有和父类一样的方法（**参数、返回类型、方法名相同**）==》**方法重写**

- 方法重载：

  如果参数类型相同的话，java提供了**可变参数**的方式

  ```java
  static int add(int ... args) {
      int sum = 0;
      for (int a : args) {
  		sum += a;
      }
      return sum;
  }
  ```

- 方法重写

  必须和父类中的方法有相同的名字和参数、必须是继承关系；

  final方法无法被继承，意味着无法被子类重写；static也不能被重写

  要是子类和父类中**相同方法名中参数不同** ==》 既不属于方法重写、也不属于方法重载；

  一个类继承了抽象类，那么抽象类中的方法必须在子类中被重写；

#### 15. 枚举（enum）

```java
public enum PlayerType {
    TENNIS,
    FOOTBALL,
    BASKETBALL
}
public enum PlayerType {
    TENNIS("网球"),
    FOOTBALL("足球"),
    BASKETBALL("篮球");

    private String name;

    PlayerType(String name) {
        this.name = name;
    }
}
```

EnumSet 针对枚举类型的Set接口，是一个抽象类，创建时不能使用new关键字。

```java
public static void main(String[] args) {
    EnumSet<PlayerTyep> enumSetNone = EnumSet.noneOf(PlayerType.class);		// 创建了一个空的PlayerType
    System.out.println(enumSetNone);
    EnumSet<PlayerType> enumSetAll = EnumSet.allOf(PlayerTyepe.class);		// 创建了包含所有playertype类型的set
    System.out.println(enumSetAll);
}

// 结果
[]
[TENNIS, FOOTBALL, BASKETBALL]
```

EnumMap<PlayerTyepe, String> 可以new

```java
EnumMap<PlayerType, String> enumMap = new EnumMap<>(PlayerType.class);
enumMap.put(PlayerType.BASKETBALL,"篮球运动员");
enumMap.put(PlayerType.FOOTBALL,"足球运动员");
enumMap.put(PlayerType.TENNIS,"网球运动员");
System.out.println(enumMap);

System.out.println(enumMap.get(PlayerType.BASKETBALL));
System.out.println(enumMap.containsKey(PlayerType.BASKETBALL));
System.out.println(enumMap.remove(PlayerType.BASKETBALL));
```



## 五、集合框架（容器）

### 1. List 、Set、Queue、Map

- Collection 主要 List Set Queue组成：
  - List：有序、可重复的集合；（**ArrayList**（封装了动态数组）、**LinkedList**（封装了链表））
  - Set：无序、不可重复的集合；（HashSet 和 TreeSet）
  - Queue：队列，双端队列（ArrayDeque）、优先级队列（PriorityQueue）
- Map 代表键值对的集合，HashMap；

#### 1.1 List

存取有序，可以存放重复的元素，用下标对元素进行操作。

- **ArrayList**

  ```java
  ArrayList<String> list = new ArrayList<String>();
  
  // 增
  list.add("啦啦啦");
  list.add("拉拉");
  list.add("立");
  // 指定位置添加 list.add(int index, E e);
  // 遍历
  for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      System.out.println(s);
  }
  for (String s : list) {
      System.out.println(s);
  }
  // 删 list.remove("立")
  list.remove(1);
  // 改
  list.set(1, "lala");
  // 查 倒序查
  list.indexOf("啦啦啦");
  list.lastIndexOf("啦啦啦");
  // collections类的sort()可以对ArrayList进行排序
  // 1111：collections.sort(list);
  // 排序后，即可进行二分查找
  // 2222：collections.binarySearch(list,"b");
  ```
  
  - ArrayList是由数组实现的，支持随机存取（下标）；
  
  - 从尾部插入和删除元素快捷，但中间插入或删除低效；（涉及数组元素的复制和移动）
  
  - 内部数组容量不足时会自动扩容；（元素庞大时，效率低）`int newCapacity = oldCapacity + (oldCapacity >> 1);` 随后比较容量和指定容量的大小）
  
    第一次扩容=10，第二次扩容发生在添加第11个元素时
  
  - `System.arraycopy(源数组，索引，目标数组，索引，元素个数)` 来进行add或remove操作。（删除操作时，最后一位被设置为null，便于垃圾回收机制回收该空间）

- **LinkedList**

  ```java
  LinkedList<String> list = new LinkedList<String>();
  //增
  list.add("啦啦啦");
  list.add("拉拉");
  list.add("立");
  // 遍历 同上
  // 删 remove(1);
  // 改 set(1, "lala");
  ```

  - LinkedList是由双向链表实现的，不支持随机存取，只能从一端开始遍历，直到找到需要的元素；
  - 插入和删除任意位置元素方便；
  - 占用内存空间比ArrayList多一些；（每个元素存储 前一个和后一个节点的引用）

#### 1.2 Set

特点是存取无序，不可以存放重复元素，不可以用下标对元素进行操作

- **HashSet** （由HashMap实现的，值由一个固定的Object填充，键用于操作）

  ```java
  HashSet<String> set = new HashSet<>();
  //增
  set.add("啦啦啦");
  set.add("拉拉");
  set.add("立");
  System.out.println("元素个数：" + set.size());
  
  // 查
  boolean contain = set.contains("lala");
  System.out.println("?:" + contain);
  
  // 删
  boolean removeOk = set.remove("立");
  System.out.println("remove li?: " + removeOk);
  
  // 修改元素：~！！！需要先删除后添加；
  boolean removeFlag = set.remove("拉拉");
  boolean addLaLa = set.add("lala");
  System.out.println("Modified set？ :" + (removeFlag && addLaLa));
  
  // 输出修改后的HashSet
  System.out.println("HashSet after modification: " + set);
  ```

  - HashSet主要用于去重，比如统计一篇文章中有多少个不重复的单词；(因为它是用HashMap实现的，HashMap的键是唯一的，相同的键值会覆盖掉原来的，第二次`set.add("xx")`会覆盖上一次的`set.add("xx")`。)

- **LinkedHashSet**

- **TreeSet** 基于红黑树实现的有序集合，实现了SortedSet接口，可以自动对集合中的元素进行排序，按照键的自然顺序或指定的比较器顺序进行排序。

  - 不允许插入null元素

#### 1.3 [15. 三数之和 - 力扣（LeetCode）](https://leetcode.cn/problems/3sum/)

给你一个整数数组 `nums` ，判断是否存在三元组 `[nums[i], nums[j], nums[k]]` 满足 `i != j`、`i != k` 且 `j != k` ，同时还满足 `nums[i] + nums[j] + nums[k] == 0` 。请你返回所有和为 `0` 且不重复的三元组。

```java
public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i : nums)
            System.out.print(i + " ");
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1, k = nums.length-1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < k -1 && (nums[i] + nums[j] + nums[k-1] >= 0))
                    k--;            // 末尾的探测过程
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }
```



#### 1.4 Queue

队列，通常遵循**先进先出**的原则，新元素插入队列的尾部，访问元素返回队列的头部。

- ArrayDeque

  **基于数组实现的双端队列**，满足同时在数组两端插入或删除元素的需求，数组必须是循环的。

  `deque.add()`, `deque.remove()`

- **LinkedList** (!!!与作为List有很大不同！！！) 

  选择使用 LinkedList 还是 ArrayDeque 时，需要根据具体的业务场景和需求来选择。如果需要在**双向队列的两端**进行频繁的插入和删除操作，并且**需要随机访问元素**，可以考虑使用 ArrayDeque；如果需要在**队列中间**进行频繁的插入和删除操作，可以考虑使用 LinkedList。

  ```java
  LinkedList<String> queue = new LinkedList<>();
  // 增
  queue.offer("啦啦啦");
  queue.offer("拉拉");
  queue.offer("啦");
  // out(queue)
  // 删， 队列，先进先出
  queue.poll();
  // out(queue)
  // 不支持直接修改，需要先删除，再修改
  queue.poll();
  queu.offer("啦啦");
  // 查
  queue.get(0);
  queue.contains("啦啦");
  
  // 查 适用迭代器方式遍历元素
  Iterator<String> iterator = queue.iterator();
  while (iterator.hasNext()) {
      String ele = iterator.next();
     	System.out.println(ele);
  }
  ```
  
  - 作为队列时：`offer()`将元素添加到队列的尾部；`poll()`从队列的头部删除元素
  - LinkedList是链表结构，不支持随机访问元素，需要使用迭代器或者poll()方法依次遍历元素
  
- **PriorityQueue**

  优先队列，它的出队顺序与元素的优先级有关，执行`remove()`或`poll()`方法，返回的总是**优先级最高**的元素

  ```java
  PriorityQueue<String> queue = new PriorityQueue<>();
  // 增
  queue.offer("啦啦啦");
  queue.offer("拉拉");
  queue.offer("啦");
  // out  [啦，拉拉，啦啦啦]
  // 删
  queue.poll();
  // out	[啦啦啦, 拉拉]
  // 改：不支持直接修改，需要先删除再修改
  String first = queue.poll();
  queue.offer("改");
  // out [拉拉, 改]
  // 不支持随机访问元素，只能访问队首元素
  // out (queue.peek()); // 拉拉
  // for (String ele ： queue)
  ```

  - 通过实现Comparator接口按照总分的优先队列：

  ```java
  public class Student{
      private String name;
      private int score1;
      private int score2;
  
      public Student(String name, int score1, int score2){
          this.name = name;
          this.score1 = score1;
          this.score2 = score2;
      }
      public String getName(){
          return  name;
      }
      public int getScore1(){
          return score1;
      }
      public int getScore2(){
          return score2;
      }
  
      @Override
      public String toString(){
          return "Student{" + "name='" + name + '\'' + ", 总成绩=" + (score1 + score2) + '}';
      }
  }
  class StudentComparator implements Comparator<Student> {
  
      @Override
      public int compare(Student o1, Student o2) {
          return Integer.compare(o2.getScore1() + o2.getScore2(), o1.getScore1() + o1.getScore2());
      }
  }
  
  public class Collection2_PriorityQueue {
  
      public static void main(String[] args) {
          // !!!!!!
          PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());
  
          pq.offer(new Student("王二", 80, 90));
          System.out.println(pq);
          pq.offer(new Student("小1", 95, 95));
          System.out.println(pq);
          pq.offer(new Student("肖佳琦", 90, 95));
          System.out.println(pq);
          pq.offer(new Student("沉默", 90, 80));
          System.out.println(pq);
          while(!pq.isEmpty()) {
              System.out.println(pq.poll());
          }
      }
  }
  /*
  [Student{name='王二', 总成绩=170}]
  [Student{name='小1', 总成绩=190}, Student{name='王二', 总成绩=170}]
  [Student{name='小1', 总成绩=190}, Student{name='王二', 总成绩=170}, Student{name='肖佳琦', 总成绩=185}]
  [Student{name='小1', 总成绩=190}, Student{name='王二', 总成绩=170}, Student{name='肖佳琦', 总成绩=185}, Student{name='沉默', 总成绩=170}]
  Student{name='小1', 总成绩=190} Student{name='肖佳琦', 总成绩=185} Student{name='沉默', 总成绩=170} Student{name='王二', 总成绩=170} 
  */
  ```

#### 1.5 Map

保存的是键值对，键要求保持唯一性，值可以重复

- **HashMap**

  - HashMap中的键和值都可以为null。如果键为null，那么该键映射到哈希表的第一个位置

  - 可以使用迭代器或forEach方法遍历 HashMap中的键值对；

  - HashMap有一个初始容量和一个负载因子。（通过数组形式实现， 初始大小，默认16，扩容前可以存储的键值对数量与表大小的比例，默认0.75）
  ```java
  HashMap<String, String> hashMap = new HashMap<>();
  
  // 增
  hashMap.put("啦啦啦", "lalala");
  hashMap.put("啦啦", "lala");
  hashMap.put("啦", "la");
  
  // 获取指定键的值
  String value1 = hashMap.get("啦啦");
  
  // 修改键对应的值
  hashMap.put("啦", "LA");
  String value2 = hashMap.get("啦");
  
  // 删
  hashMap.remove("啦啦");
  
  for (String key : hashMap.keySet()) {
      String value = hashMap.get(key);
      System.out.println(key + "对应值：" + value);
  }
  ```

- 初始大小 或者 数组的长度 是2的n次方时，`hash & (length - 1) = hash % length` （计算26%8， 11010 >>3  保留n位，即3位 010 =2）**`&`运算 比`%`运算更高效**

  - $2^n$正好是偶数，-1后是奇数，且二进制最后一位是1，使得&运算后结果可能为偶数或奇数，保证哈希值的均匀分布。（同时，将哈希值的高位全部归零，只保留低位值

  - **hash方法是用来做哈希值优化的**（h=hashCode(); h^h>>>16; (n-1)&hash）;为了增强随机性，让数据元素更加均衡的分布，减少碰撞。

  ```java
  int h,n = 16;
  int hash = (key == null) ? 0 : (h=key.hashCode()) ^ (h >>>16);
  int i = (n - 1) & hash;
  // hash值 和 索引i
  System.out.println(key + "的hash值 : " + hash +" 的索引 : " + i);
  ```

- **HashMap的扩容机制**

  - JDK7 与JDK8的差异主要在hash方法上，7采用头插法（当哈希冲突采用拉链法时）

  - JDK8：假设length=16，key1 = 5， key2 = 21；key & (length-1)哈希冲突（均为5）;

    扩容，变为原来2倍32； key1 = 5 ==》 5；key2 = 21 ==》 5+16（扩容前位置+原数组长度）

- **HashMap线程不安全**

  - 多线程下扩容会死循环
  - 多线程下put会导致元素丢失
  - put和get并发时会导致get到null

- **遍历HashMap**

  - ```java
    for (Map.Entry<String, String> entry : map.entrySet()) {
        // out entry.getKey();
        // out entry.getValue();
    }
    
    // 迭代 键或值
    for (String key : map.keySet()) {
        // out key
    }
    for (String value: map.values()) {
        // out value
    }
    ```

  - 


- **LinkedHashMap**

  HashMap 是无序的。LinkedHashMap是HashMap的子类，它使用链表来记录插入/访问**元素的顺序**。 （使用哈希表来存储数据，又用了双向链表来维持顺序）

  - 访问顺序：`Map<String, String> linkedHashMap = new LinkedHashMap<>(16, .75f, true)`

    参数分别表示，初始容量和负载因子，第三个参数为true表示要维护访问顺序；否则维护插入顺序，默认为false。（即最不经常访问的放在头部，get后的会放在尾部）

  - 使用LinedHashMap来实现 LRU缓存（Least Recently Used）选择最近最久未被使用的页面淘汰

- TreeSet

  实现了SortedMap接口，自动将键按照自然顺序或指定的比较器顺序排序，并保证其元素顺序。（内部，使用红黑树来实现键的排序和查找）

  ```java
  Map<String, String> treeMap = new TreeMap<>();
  // <>(Comparator.reverseOrder()); 反转顺序
  ```

  - `lastKey(), firstKey()`获取最后一个key和第一个key的方法
  - `headMap(), tailMap()`获取指定key之前（不包含指定）和之后（包含指定）的key
  - `subMap(n1, n2)`获取[n1, n2)的键值对


####  TreeMap、HashMap、LinkedHashMap

| 特性     | TreeMap  | HashMap  | LinkedHashMap    |
| -------- | -------- | -------- | ---------------- |
| 排序     | 支持     | 不支持   | 不支持           |
| 插入顺序 | 不保证   | 不保证   | 保证             |
| 查找效率 | O(lgn)   | O(1)     | O(1)             |
| 空间占用 | 通常较大 | 通常较小 | 通常较大         |
| 适用场景 | 需要排序 | 无需排序 | 需要保持插入顺序 |

####  1.6 [2. 两数相加 - 力扣（LeetCode）](https://leetcode.cn/problems/add-two-numbers/)

```java
public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            temp += num1;
            temp += num2;
            ListNode newNode = new ListNode(temp % 10);
            cur.next = newNode;
            cur = cur.next;
            temp = temp / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
            return head;
    }
```



#### 1.7 [19. 删除链表的倒数第 N 个结点 - 力扣（LeetCode）](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/)

 ```java 
 public static ListNode removeNFromEnd(ListNode head, int n) {
         ListNode dummyNode = new ListNode(0, head);
 //        dummyNode.next = head;
         ListNode cur = dummyNode;
         // 双指针：
         ListNode first = head;
         for(int i = 0; i < n; i++) {
             first = first.next;
         }
         while(first != null) {
             first = first.next;
             cur = cur.next;
         }
         cur.next = cur.next.next;
         return dummyNode.next;
     }
 ```























