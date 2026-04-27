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

#### 3.1.2 私有内部类的任何属性不能在外部类之外的位置被访问

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

### 3.2 默认修饰符

如果使用包私有修饰符（即不显式地使用任何可见性修饰符）修饰成员内部类，那么该内部类可以在外部类中以及与外部类处于同一个包的类中被访问，比如:

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

其中的 ```Engine``` 类可以在与外部类 ```Car``` 处于同于一个包中的 ```Test``` 类中被访问，因此下面的创建 ```Engine``` 对象的语句是合法的:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car().new Engine();
    }
}
```

#### 3.2.1 在外部类的外部（处于内部类的非私有属性的可见性范围内）可以通过内部类的实例访问该内部类的非私有属性

因为 ```Engine``` 类中的成员属性 ```brand``` 和 ```operatingTime``` 是通过默认可见性修饰符修饰的，并且 ```Test``` 类与 ```Engine``` 类的外部类 ```Car``` 处于同一个包中，因此我们可以在 ```Test``` 类中直接通过 ```Engine``` 类的引用变量 ```engine``` 访问 ```Engine``` 类的属性. 因此下面的语句是合法的:

```java
public class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car().new Engine();
        
        System.out.println(engine.brand);
        System.out.println(engine.operatingTime);
    }
}
```

### 3.3 ```protected``` 修饰符

如果使用 ```protected``` 修饰符修饰成员内部类，那么该内部类可以在外部类中、与外部类处于同一个包中的类、以及其他包中该 ```内部类的子类``` 中被访问.

并且在外部类的外部（处于内部类以及内部类的属性的可见性范围内），可以通过内部类的对象，访问内部类的非私有属性.

### 3.4 ```public``` 修饰符

如果使用 ```public``` 修饰符修饰成员内部类，那么在任意位置该内部类都能被访问.

并且在任意位置（处于内部类的属性的可见性范围内），都可以通过该内部类的实例，访问内部类的非私有属性.

## 4. 成员内部类访问外部类的成员变量和方法

Java 编译器在编译时会为成员内部类隐式地添加一个新的成员变量，该变量的变量名为 ```this```，它是一个引用类型变量，具体的类型为外部类，并且存储调用内部类的构造方法的外部类对象的地址值.

比如，内部类 ```Engine```:

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

会被隐式的添加一个 ```Car``` 类型的名字为 ```this``` 的成员变量. 为了与 ```Engine``` 类的实例方法的第一个参数 ```this``` 进行区分，虚拟机通常会使用 ```this$n``` 的格式进行命名，其中 ```n``` 是序号:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    class Engine {
        Car this$0;
        String brand;
        String operatingTime;
    }
}
```

并且因为成员内部类的对象需要通过外部类的实例进行创建，即需要一个 ```Car``` 类的对象调用 ```Engine``` 类的构造方法:

```java
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        
        System.out.println(engine.brand);
        System.out.println(engine.operatingTime);
    }
}
```

因此这时变量 ```engine``` 指向的 ```Engine``` 对象的成员变量 ```this$0``` 存储的地址值就是变量 ```car``` 存储的地址值.

我们可以通过 ```外部类名.this``` 的方式访问 ```Engine``` 类中被隐式添加的成员变量 ```this$0```:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    class Engine {
        String brand;
        String operatingTime;
        
        public void display() {
            int operatingTime = 0;
            
            System.out.println(operatingTime);
            System.out.println(this.operatingTime);
            System.out.println(Car.this.operatingTime);
        }
    }
}
```
