# LearnNote
learn from video [<JavaSE零基础入门到入土（idea版）>](https://www.bilibili.com/video/BV1Yb411z7PG) ##2021-8-14 

## IDE 配置与操作

### 1.编译&运行

>   javac MoveToJava.java
>   java  MoveToJava

### 2. 快捷操作

1. `psvm`  =>   public static void main(String[] args) {}
2. `sout` =>  System.out.println()
3. `alt +insent`  => 快速生成 (Code-Generate ) 可以生成setter and getter 很像C#的 get set
4. for
   -  `array.fori`  => for (int i = 0; i < a.length; i++) {}
   - `100.fori`  => for (int i = 0; i < 100; i++) {}

### 3. jshell 脚本模式

在cmd里输入jshell 进入，可应用于快速验证java语句~~

### 4. 快捷键

- 格式化代码：先Ctrl+A选择全部代码 然后 Ctrl+Alt+L
  American Standard Code for Information Interchange
- 搜索： Ctrl+Shift+F 如有按键冲突一般检查：输入法快捷键
- 其他： https://zhuanlan.zhihu.com/p/106607955

##  Java SE

### 1. 基本数据类型转换

 - char、short、byte
   - +-*/% 运算时会被隐式转为int 
   - `char += int` 、`char = 45` 、`char = 45-8` 都会强制帮你转char。但是 `char = 6+int` 会报错
 - int
   - int + double会被隐式转为double
   - int + string会被隐式转为string
 - double、float 小数转int会向下取整
 - boolean 不能转为 1

### 2. static 静态修饰符 

static是java中非常重要的一个关键字，而且它的用法也很丰富，主要有四种用法：

1. 用来修饰成员变量，将其变为类的成员，从而实现所有对象对于该成员的共享；
2. 用来修饰成员方法，将其变为类方法，可以直接使用“类名.方法名”的方式调用，常用于工具类；
3. 静态块用法，将多个类成员放在一起初始化，使得程序更加规整，其中理解对象的初始化过程非常关键；
4. 静态导包用法，将类的方法直接导入到当前类中，从而直接使用“方法名”即可调用类方法，更加方便。

### 3. ArrayList<>

ArrayList 是非线程安全的、CopyOnWriteArrayList是安全的。 https://blog.csdn.net/lp20103021/article/details/80303665

### 4. 字符串常量池

字符串通过 `String con1,con2 = "XXXX"`建立时，会将常量建立在字符串常量池中。因此

 - 相同的常量字符串（对象）会复用。 因此`con1 == con2` (地址值相同) 
 - 但用构造函数构造的字符串`String con3 = new String(new char []{'a','b'});`,则不会进入字符串常量池 `con1 ！= con3`  
 - String内容比较用 equals

## Spring &Spring boot 

 - Spring Boot 2.2.8 中使用的是 Maven
 - 最新发布的 Spring Boot 2.3.1 已经是切换到 Gradle 
 - 我的上手demo:[SpringBoot + Mysql](https://github.com/PlagueCat-Miao/JavaSpringBoot-MySqlDemo)
 - [参考1]( https://blog.csdn.net/weixin_30950075/article/details/114030357?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control)
 - [参考2](https://blog.csdn.net/weixin_30849591/article/details/95536112?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control&dist_request_id=1328641.25339.16156287741257537&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control)
 - [参考3](https://blog.csdn.net/weixin_30950075/article/details/114030357?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.contro)

### 注解用法 

- [注解大战](./注解大战.md)





## Java 理论

### 1.五大内存

|              名称              | 作用                             | 备注                                                         |
| :----------------------------: | :------------------------------- | ------------------------------------------------------------ |
|            栈 Stack            | 存放的都是方法中的局部变量       | 一旦超出作用域，立从栈内存当中消失                           |
|            堆 Heap             | new出来的东西，都在堆当中        |                                                              |
|       方法区 Method Area       | 保存在着被加载过的每一个类的信息 | [方法区中都保存什么](https://blog.csdn.net/dshf_1/article/details/87171171) |
| 本地方法栈 Native Method Stack | 与操作系统相关                   |                                                              |
|       寄存器 pc Register       | 与cpu相关。                      | 在内存中的寄存器区域是由编译器根据需要来分配的               |
 - [整体结构](https://www.zhihu.com/question/19748817)

### 2. 

