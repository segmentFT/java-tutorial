# 继承中成员变量的访问特点

在类的成员方法的方法体中使用某个变量，虚拟机会按照如下的优先级搜索该变量的定义:
    
1. 在局部作用域（在方法体中）搜索该变量的定义.
2. 如果在局部作用域中没有找到该变量的定义，那么在成员变量作用域（在类中）搜索该变量的定义.
3. 如果在成员变量作用域中没有找到该变量的定义，那么虚拟机会按照继承顺序，在类的所有基类各自的成员方法作用域中，寻找该变量的定义.
4. 如果在所有的基类的成员变量的定义中，都没有该变量的定义，那么虚拟机报错.

如果我们有两个类 ```Parent``` 和 ```Child```，其中后者继承前者，它们的定义为:

```java
class Parent {
    String data = "member variable in parent";
}

class Child extends Parent {
    String data = "member variable in child";

    public void display() {
        String data = "local variable";

        System.out.println(data);
    }
}
```

并且我们有对应于 ```Parent``` 类和 ```Child``` 类的测试类:

```java
class Test {
    public static void main(String[] args) {
        Child child = new Child();
        
        child.display();
    }
}
```

那么当虚拟机执行到 ```Test``` 类的 ```main``` 方法的语句 ```child.display()``` 时，虚拟机开始进入 ```display``` 方法. 当 ```System.out.println(data)``` 语句被执行时，虚拟机首先会在 ```display``` 方法的方法体中寻找变量 ```data``` 的定义. 因此这时控制台的输出结果为:

```text
local variable
```

如果我们将 ```Child``` 类的 ```display``` 方法的局部变量 ```data``` 的名字修改为 ```localData```:

```java
class Parent {
    String data = "member variable in parent";
}

class Child extends Parent {
    String data = "member variable in child";
    
    public void display() {
        String localData = "local variable";
        
        System.out.println(data);
    }
}
```

那么当 ```display``` 方法再次被调用时，虚拟机首先会在 ```display``` 的方法体中寻找变量 ```data``` 的定义，这时 ```display``` 方法中没有名字为 ```data``` 的局部变量，因此虚拟机会在 ```Child``` 类的类体中寻找变量 ```data``` 的定义. 因此这时控制台的输出结果为:

```text
member variable in child
```

如果我们将 ```Child``` 类的成员变量 ```data``` 的名字修改为 ```dataInChild```:

```java
class Parent {
    String data = "member variable in parent";
}

class Child extends Parent {
    String dataInChild = "member variable in child";
    
    public void display() {
        String localData = "local variable";
        
        System.out.println(data);
    }
}
```

那么当 ```display``` 方法再次被调用时，同理，虚拟机会依次在 ```display``` 方法的方法体和 ```Child``` 类的类体中寻找变量 ```data``` 的定义. 当这些寻找尝试都失败后，虚拟机会在 ```Child``` 类的基类 ```Parent``` 中寻找变量 ```data``` 的定义. 因此这时控制台的输出结果为:

```text
member variable in parent
```

## 1. ```super``` 关键字

在派生类中，可以在派生类的成员方法中，通过 ```supor``` 关键字访问它的基类的成员变量（非私有的）. 因此如果我们将 ```Parent``` 类和 ```Child``` 类的定义修改为:

```java
class Parent {
    String data = "member variable in parent";
}

class Child extends Parent {
    String data = "member variable in child";
    
    public void display() {
        String data = "local variable";
        
        System.out.println(data);
        System.out.println(this.data);
        System.out.println(super.data);
    }
}
```

那么当 ```display``` 方法被调用时，虚拟机能够区分 ```display``` 方法的方法体中的 ```data```，```this.data``` 和 ```super.data``` 分别为 ```display``` 方法中的局部变量，```Child``` 类的成员变量和 ```Parent``` 类的成员变量. 因此这时控制台的输出为:

```text
local variable
member variable in child
member variable in parent
```

### 1.2 通过 ```super``` 关键字直接访问基类的成员变量

如果我们有 3 个类 ```Ancestor```，```Parent``` 和 ```Child```，它们之间的继承关系为，```Child``` 继承 ```Parent```，```Parent``` 继承 ```Ancestor```. 它们的定义分别为:

```java
class Ancestor {
    String data = "member variable in ancestor";
}

class Parent extends Ancestor {
    String data = "member variable in parent";
}

class Child extends Parent {
    String data = "member variable in child";
    
    public void display() {
        String data = "local variable";
        
        System.out.println(data);
        System.out.println(this.data);
        System.out.println(super.data);
        System.out.println(super.super.data);
    }
}
```
其中 ```Child``` 类的成员方法 ```display``` 的方法体中 ```super``` 关键字的使用方式 ```super.super.data``` 是非法的.

在类的成员方法中，通过关键字 ```super``` 访问该类的基类的成员变量（公共的）时，虚拟机会首先在直接基类的类体中寻找成员变量的定义，如果没有找到，那么虚拟机会自动沿着继承关系，在该类的间接基类的类体中寻找该成员变量的定义.

由于在 ```display``` 方法中通过关键字 ```super``` 访问基类的公共成员变量 ```data``` 时，虚拟机会首先在 ```Child``` 类的直接基类 ```Parent``` 的类体中寻找变量 ```data``` 定义. 由于 ```Parent``` 类中存在名字为 ```data``` 的公共属性，因此虚拟机不会继续在 ```Child``` 的间接基类（这里是 ```Ancestor``` 类）的类体中继续寻找变量 ```data``` 的定义.
