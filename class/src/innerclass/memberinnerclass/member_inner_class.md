# 成员内部类

## 1. 成员内部类的定义

处于类的成员方法之外的类体中（即处于类的成员位置的类）被称为成员内部类. 比如:

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

其中的 ```Engine``` 类就是 ```Car``` 类的成员内部类，因为:
    
1. ```Engine``` 类被定义在 ```Car``` 的类体中.
2. ```Engine``` 类的定义的位置与 ```Car``` 的其他成员方法和变量（比如 ```Car``` 类的属性 ```name```、```operatingTime``` 等）同级.

内部类会被编译为一个独立的字节码文件，该文件的命名格式为:

```text
外部类名$内部类名.class
```

因此 ```Engine``` 类被编译得到的字节码文件的名字为:

```text
Car$Engine.class
```

## 2. 在外部类之外创建内部类的对象

成员内部类（非静态的）与类的实例方法和变量类似，需要通过它所处的类的实例（对象）来创建它自身的对象.

因此为了创建 ```Car``` 类的内部类 ```Engine```，我们需要先创建 ```Car``` 类的对象:

```java
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
    }
}
```

再通过 ```Car``` 类的对象来创建 ```Engine``` 类的对象:

```java
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine engine = Car.new Engine();
    }
}
```

我们也可以不使用中间变量 ```car```，而直接使用匿名的 ```Car``` 对象将创建 ```Engine``` 类的对象的过程简化为:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car().new Engine();
    }
}
```

如果一个内部类可以在它的外部类之外的位置被访问，那么我们可以通过 ```外部类名.内部类名``` 的方式访问，比如 ```Car.Engine``` 表示 ```Car``` 类的内部类 ```Engine```.

## 3. 作用于成员内部类定义的修饰符

一个类的成员内部类与该类的成员方法、变量等的地位相同，都是类的成员的一种. 因此类似于类的成员方法和变量，成员内部类也可以被 ```修饰符``` 修饰.

### 3.1 ```private``` 修饰符

如果使用修饰符 ```private``` 修饰成员内部类，那么该内部类的对象只能在它所处的类中被创建，而不能在它所处的类之外被创建. 比如:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    private class Engine {
        String brand;
        String operatingTime;
    }
}
```

中的内部类 ```Engine``` 是 ```Car``` 类的一个私有成员，因此下面的创建 ```Engine``` 类对象的语句:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car().new Engine();
    }
}
```

是非法的，因为我们无法通过成员访问操作符访问 ```Car``` 类的私有成员，因此通过 ```Car``` 类访问 ```Engine``` 类:

```
Car.Engine
```

以及通过 ```Car``` 类的对象调用 ```Engine``` 类的构造函数:

```
new Car().new Engine()
```

会导致编译错误.

#### 3.1.1 通过外部类的成员方法获得私有内部类的对象

我们可以在 ```Car``` 类中定义一个非私有的成员方法，它返回 ```Engine``` 类的对象:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    private class Engine {
        String brand;
        String operatingTime;
    }
    
    public Engine getEngineInstance() {
        return new Engine();
    }
}
```

并且在 ```Car``` 类的外部通过调用成员方法 ```getEngineInstance``` 获得 ```Engine``` 对象的地址值:

```java
public class Test {
    public static void main(String[] args) {
        Object engine = new Car().getEngineInstance();
    }
}
```

注意到因为 ```Engine``` 类是 ```Car``` 的私有成员，因此我们不能在 ```Car``` 类的外部通过 ```Car``` 类或它的对象访问 ```Engine``` 类，因此下面的语句是非法的:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car().getEngineInstance();
    }
}
```

但是我们可以将一个类的对象的地址值安全地赋值给一个该类的父类的引用变量，由于 ```Engine``` 类没有显式地继承其他类，因此它的父类只能是 ```Object``` 类.

#### 3.1.2 私有内部类的任何对象不能在外部类之外的位置被访问

即使 ```Engine``` 类的成员变量被修饰符 ```public``` 修饰:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    private class Engine {
        public String brand;
        public String operatingTime;
    }
    
    public Engine getEngineInstance() {
        return new Engine();
    }
}
```

那么在 ```Test``` 类（位于 ```Car``` 类的外部的类）的成员方法 ```main``` 中也无法访问 ```Engine``` 类的成员变量 ```brand``` 和 ```operatingTime```，因此下面的语句是非法的:

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(new Car().getEngineInstance().brand);
        System.out.println(new Car().getEngineInstance().operatingTime);
    }
}
```

但是我们可以在外部类的方法中创建内部类的对象，并且访问内部类中的非私有成员，比如:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    private class Engine {
        public String brand;
        public String operatingTime;
    }
    
    public Engine getEngineInstance() {
        return new Engine();
    }
    
    public void displayEngineInfo() {
        Engine engine = new Engine();
        
        System.out.println(engine.brand);
        System.out.println(engine.operatingTime);
    }
}
```

是合法的.
