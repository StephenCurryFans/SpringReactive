# spring Reactive R2DBC 

###  1.  响应式编程
```java
// 1.1 Lambda表达式
int sum = (x,y) -> x + y;
```


```java
// 1.2 函数式接口

/**
 *  函数式接口定义， 函数式接口只允许有一个抽象方法
 *
 */
@FunctionalInterface
interface Function<T,R> {
    R apply(T t);
}
class Test{
   public static void main(String[] args){
       Function<int,int> sum = (x,y) -> x + y;
       System.out.println(sum.apply(1,2)); // 3
   } 
}

```

### 2.  R2DBC

### 3.  Spring Data R2DBC

### 4.  Spring WebFlux

