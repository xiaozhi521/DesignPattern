# 一、Lambda 表达式
# 二、函数式（Functional）接口
 java 内置4大核心函数式接口
 - 消费型接口 Consumer<T> void accept(T t)
 - 供给型接口 Supplier<T> T get()
 - 函数型接口 Function<T, R> R apply(T t)
 - 断定型接口 Predicate<T> boolean test(T t)
# 三、方法引用与构造引用
# 四、强大的Sream API
    并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
    相比较串行的流，`并行流可以很大程度上提高程序的执行效率`。
    java8中将并行进行了优化，我们可以很容易的对数据进行并行操作。
    Stream API 可以声明性的通过parallel()与sequential()在并行流与顺序流之间进行切换。
## 1、并行流
## 2、串行流
# 五、Optional 类
# 六、新的时间和日期API
# 七、其它新特性
## 1、重复注解
## 2、类型注解
## 3、通用目标类型注解
## 4、JDK更新
- 集合的流式操作
- 并发
- Arrays
- Number 和 Math
- IO/NIO的改进
- Reflection获取形参名
- String：join()
- Files
## 5、编译新工具
## 6、JVM中的Metaspace取代PermGen空间