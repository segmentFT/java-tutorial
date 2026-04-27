# 静态内部类

## 1. 静态内部类的定义

如果我们将成员内部类的定义使用修饰符 ```public``` 进行修饰，那么该成员内部类就成为了静态内部类.

比如如果我们有两个类 ```Car``` 和 ```Engine```，其中后者是前者的成员内部类，它们的定义分别为:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    class Engine {
        String brand;
        String operatingTime;
    }
}
```

那么如果 ```Engine``` 类在定义时被修饰符 ```static``` 修饰，那么 ```Engine``` 类就是 ```Car``` 类的静态内部类:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    static class Engine {
        String brand;
        String operatingTime;
    }
}
```

在静态内部类中，只能直接访问外部类的静态变量和静态方法，如果要访问外部类的实例方法和实例属性，那么就需要在静态内部类中先创建外部类的实例.

## 2. 在外部类之外创建静态内部类的对象

类似于类的静态方法和静态变量，当 ```Car``` 类的字节码被加载到方法区中，```Engine``` 类的字节码也会随之被加载到内存区中. 因此在 ```Car``` 类的外部，在 ```Car``` 类的实例被创建之前, ```Engine``` 类就可以通过 ```Car``` 类的类名被访问.

因此如果要创建 ```Engine``` 类的对象，我们可以直接通过 ```外部类.内部类``` 的方式调用 ```Engine``` 类的构造方法:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine();
    }
}
```

## 3. 在外部类之外访问静态内部类的成员

### 3.1 访问静态内部类的实例成员

在静态内部类的成员的可见性范围内，内部类的实例变量和方法需要通过内部类的实例进行访问. 因此如果要访问 ```Engine``` 类的属性 ```brand``` 和 ```operatingTime```，我们需要先创建 ```Engine``` 类的对象，再通过它访问 ```Engine``` 的属性:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine();
        
        System.out.println(engine.brand);
        System.out.println(engine.operatingTime);
    }
}
```

### 3.2 访问静态内部类的静态成员

再静态内部类的静态成员的可见性范围内，我们可以直接通过静态内部类的类型访问它的静态属性和方法. 如果 ```Engine``` 类具有静态变量 ```staticProperty``` 和静态方法 ```staticMethod```:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    static class Engine {
        String brand;
        String operatingTime;
        static String staticProperty;
        
        public static void staticMethod() {
            System.out.println("static method");
        }
    }
}
```

那么我们可以通过 ```外部类.静态内部类.静态成员``` 的方法访问 ```Engine``` 的静态成员 ```staticProperty``` 和 ```staticMethod```:

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Car.Engine.staticProperty);
        Car.Engine.staticMethod();
    }
}
```
