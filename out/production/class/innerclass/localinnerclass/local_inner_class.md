# 局部内部类

如果一个类的内部类是在一个类的成员方法中被定义的（即处于局部作用域中），那么该类被称为局部内部类. 在局部内部类中可以直接访问它的外部类的成员变量和方法，以及它所处的成员方法中的局部变量.

如果我们有两个类 ```Car``` 和 ```Engine```，其中后者是前者的成员内部类，它们的定义分别为:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    class Engine {
        String brand;
        String operatingTime;
    }
    
    public void display() {
        String info = "info";
        
        System.out.println(info);
    }
}
```

如果我们将 ```Engine``` 类的定义移动到 ```Car``` 类的成员方法 ```display``` 中，那么 ```Engine``` 类就成为了 ```Car``` 类的局部内部类:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    public void display() {
        String info = "info";

        class Engine {
            String brand;
            String operatingTime;
        }
        
        System.out.println(info);
    }
}
```

在 ```Engine``` 类中可以访问 ```Car``` 类的属性 ```name```、```operatingTime``` 和 ```automotivePaintColor``` 以及它所处的成员方法 ```display``` 中的局部变量 ```info```:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    public void display() {
        String info = "info";

        class Engine {
            String brand;
            String operatingTime;
            
            public void displayEngineInfo() {
                System.out.println(Car.this.name);
                System.out.println(Car.this.operatingTime);
                System.out.println(info);
            }
        }
        
        System.out.println(info);
    }
}
```

## 1. 局部内部类的修饰符

由于局部内部类的地位与方法中一般的局部变量相同，因此我们不能使用任何可见性修饰符（```private```、```默认```、```protected``` 和 ```public```）以及修饰符 ```static``` 修饰局部内部类的定义，类似于我们不能使用可见性修饰符或者静态修饰符 ```static``` 修饰普通的局部变量.

## 2. 访问局部内部类的成员

局部内部类的作用域位于其所在的方法内，因此对于 ```Engine``` 类，只有在 ```Car``` 类的成员方法 ```display``` 中，我们才能访问 ```Engine``` 类.

### 2.1 访问局部内部类的实例成员

如果要访问局部内部类的实例成员，那么必须要先创建该内部类的对象，并且通过该对象访问内部类的成员.

比如我们可以在 ```Car``` 类的成员方法 ```display``` 中直接创建 ```Engine``` 类的实例，并通过它访问 ```Engine``` 类的成员变量 ```brand``` 和 ```operatingTime``` 以及成员方法 ```displayEngineInfo```:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;
    
    public void display() {
        String info = "info";

        class Engine {
            String brand;
            String operatingTime;
            
            public void displayEngineInfo() {
                System.out.println(Car.this.name);
                System.out.println(Car.this.operatingTime);
                System.out.println(info);
            }
        }
        
        Engine engine = new Engine();
        
        System.out.println(engine.brand);
        System.out.println(engine.operatingTime);
        engine.displayEngineInfo();
        
        System.out.println(info);
    }
}
```

### 2.2 访问局部内部类的静态成员

我们可以在局部内部类所处的方法中，通过 ```局部内部类的类名.静态成员``` 的方式进行访问（该静态成员必须是非私有的）.

如果 ```Engine``` 类中具有静态属性 ```staticProperty``` 和静态方法 ```staticMethod```，那么我们可以通过 ```Engine.staticProperty``` 和 ```Engine.staticMethod``` 的方式在 ```Car``` 类的成员方法 ```display``` 中访问 ```Engine``` 的静态成员:

```java
public class Car {
    String name;
    int operatingTime;
    int automotivePaintColor;

    public void display() {
        String info = "info";

        class Engine {
            String brand;
            String operatingTime;
            static String staticProperty;

            public void displayEngineInfo() {
                System.out.println(Car.this.name);
                System.out.println(Car.this.operatingTime);
                System.out.println(info);
            }

            public static void staticMethod() {
                System.out.println(staticProperty);
            }
        }

        Engine engine = new Engine();

        System.out.println(engine.brand);
        System.out.println(engine.operatingTime);
        engine.displayEngineInfo();

        Engine.staticProperty = "static property";
        Engine.staticMethod();

        System.out.println(info);
    }
}
```


