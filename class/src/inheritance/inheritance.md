# 派生类能够继承基类中的哪些内容？

## 1. 构造函数

无论基类的构造函数是私有的（在定义时使用修饰符 ```private```）还是公有的（在定义时使用修饰符 ```public```），派生类都不能继承基类的构造函数.

### 假设基类可以继承父类的构造函数

如果我们有一个类:

```java
public class Parent {
    String dataInParent;
    
    public Parent() {}
    public Parent(String dataInParent) {
        this.dataInParent = dataInParent;
    }
}
```

并且存在另一个继承了 ```Parent``` 类的派生类:

```java
public class Child extends Parent {
    String dataInChild;
    
    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }
}
```

如果派生类 ```Child``` 能够继承基类 ```Parent``` 的构造函数，那么这等价于:

```java
public class Child extends Parent {
    String dataInChild;

    public Parent() {}
    public Parent(String dataInParent) {
        this.dataInParent = dataInParent;
    }
    
    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }
}
```

然而根据构造函数的定义，一个类的构造函数的名字必须与类名相同，而这时 ```Child``` 类中出现了函数名为 ```Parent``` 的构造函数，因此这时非法的.

从而基类不能继承父类的构造函数.

## 2. 成员变量

无论基类中的成员变量是私有的（变量在定义时使用修饰符 ```private```）还是公有的（变量在定义时使用修饰符 ```public```），派生类都能够继承基类的成员变量.

### 2.1 基类的成员变量是公有的

如果我们有一个类，其中存在一个公有的成员变量:

```java
public class Parent {
    String dataInParent;
    
    public Parent() {}
    public Parent(String dataInParent) {
        this.dataInParent = dataInParent;
    }
}
```

并且存在另一个类继承了 ```Parent``` 类:

```java
public class Child extends Parent{
    String dataInChild;
    
    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }
}
```

那么派生类 ```Child``` 的成员方法可以直接访问基类的公共属性 ```dataInParent```:

```java
public class Child extends Parent{
    String dataInChild;
    
    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }
    
    public void displayDataInParent() {
        System.out.println(dataInParent);
    }
}
```

### 2.2 基类的成员变量是私有的

如果我们有一个类，其中存在一个私有的成员变量及其对应的 ```setter``` 和 ```getter``` 方法:

```java
public class Parent {
    private String dataInParent;
    
    public Parent() {}
    public Parent(String dataInParent) {
        this.dataInParent = dataInParent;
    }
    
    public void setDataInParent(String dataInParent) {
        this.dataInParent = dataInParent;
    }
    
    public String getDataInParent() {
        return dataInParent;
    }
}
```

并且存在另外一类继承了 ```Parent``` 类:

```java
public class Child extends Parent{
    String dataInChild;
    
    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }
}
```

那么派生类 ```Child``` 不能直接访问 ```Parent``` 类的私有属性 ```dataInParent```，但是可以通过该属性的 ```getter``` 方法（```getDataInParent``` 方法）和该属性的 ```setter``` 方法（```setDataInParent``` 方法）间接地访问该私有属性:

```java
public class Child extends Parent{
    String dataInChild;
    
    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }
    
    public void changeDataInParent(String newDataInParent) {
        setDataInParent(newDataInParent);
    }
    
    public void displayDataInParent() {
        System.out.println(dataInParent);
    }
}
```

### 2.3 基类与派生类的内存图

如果存在 2 个类 ```Parent``` 类和 ```Child``` 类, 其中后者继承了前者:

```java
class Parent {
    String dataInParent;
}

class Child extends Parent {
    String dataInChild;
}
```

以及一个测试类:

```java
public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        
        child.dataInChild = "data in child";
        child.dataInParent = "data in parent";
        
        System.out.println(child.dataInChild + child.dataInParent);
    }
}
```

那么当测试类的代码开始被执行时，虚拟机首先将 ```main``` 方法的字节码加载到 ```方法区``` 中:

```mermaid
```

之后虚拟机将 ```main``` 方法的栈帧加载到 ```栈内存``` 中，用于保存 ```main``` 方法的局部变量:

```mermaid
```