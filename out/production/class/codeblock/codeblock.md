# 代码块

一个代码块是用一对花括号 ```{}``` 包围的语句，比如:

```java
public class Test {
    public static void main(String[] args) {
        {
            int x = 10;
            System.out.println(x);
        }
    }
}
```

中的语句 ```int x = 10``` 和 ```System.out.println(x)```  以及包围它们的花括号构成了一个代码块. 代码块可以分为 ```局部代码块```，```构造代码块``` 和 ```静态代码块```.

## 1. 局部代码块

如果一个代码块位于一个类的成员方法中，那么该代码块被称为局部代码块，比如:

```java
public class Test {
    public static void main(String[] args) {
        {
            int x = 10;
            System.out.println(x);
        }
    }
}
```

中的代码块（使用 ```{}``` 包围的部分）就是一个局部代码块，因为它出现在 ```Test``` 类的成员方法 ```main``` 中. **局部代码块内部定义的变量的生命周期从它被定义开始，到该变量所处的代码块结束为止**.

因此，在变量 ```x``` 所处的代码块之外无法访问该变量. 比如:

```java
public class Test {
    public static void main(String[] args) {
        {
            int x = 10;
        }
        System.out.println(x);
    }
}
```

中的语句 ```System.out.println(x)``` 是非法的.

## 2. 构造代码块

如果一个代码块处于一个类的类体中，那么我们称该代码块为构造代码块，比如:

```java
class Example {
    String data;

    {
        System.out.println("instance initialization block");
    }
    
    public Example() {}
    
    public Example(String data) {
        this.data = data;
    }
}
```

中的代码块

```text
{
    System.out.println("instance initialization block");
}
```

就是构造代码块. 当我们通过 ```new``` 关键字创建 ```Example``` 类的对象时，```Example``` 类中的构造代码块中的语句先于 ```Example``` 类的构造方法被执行.

## 3. 静态代码块

如果一个类的构造代码块被修饰符 ```static``` 修饰，那么它就是一个静态代码块，比如:

```java
class Example {
    String data;

    static {
        System.out.println("static block");
    }
    
    public Example() {}
    
    public Example(String data) {
        this.data = data;
    }
}
```

```Example``` 类的类体中的:

```text
static {
    System.out.println("static block");
}
```

就是一个静态代码块. 当 ```Example``` 类的字节码被虚拟机加载到方法区中，静态代码块中的语句就会被执行.

因此即使通过 ```new``` 关键字创建多个 ```Example``` 类的对象，```Example``` 类的静态代码块中的语句也只会被执行一次.

由于静态代码块的语句在类的对象被创建之前就被调用，因此我们不能在静态代码块中访问实例变量或方法，比如:

```java
class Example {
    String data;

    static {
        System.out.println(data);
        display();
    }
    
    public Example() {}
    
    public Example(String data) {
        this.data = data;
    }
    
    public void display() {
        System.out.println(data);
    }
}
```

中的静态代码块中的语句就是非法的.

但是在静态代码块中可以访问同一个类的静态变量和方法，比如:

```java
class Example {
    String data;
    static String staticData;

    static {
        System.out.println(staticData);
        staticDisplay();
    }
    
    public Example() {}
    
    public Example(String data) {
        this.data = data;
    }
    
    public void display() {
        System.out.println(data);
    }
    
    public static void staticDisplay() {
        System.out.println(staticData);
    }
}
```
