# 构造方法的访问特点

## 1. ```Super``` 关键字

派生类在初始化时一定会调用它的直接基类的构造方法（可以是```无参的```，也可以是```有参的```），因为派生类在初始化时，可能会使用它的基类的成员变量，因此在派生类的成员变量被初始化之前，它的基类的成员变量一定要被初始化.

如果派生类的直接基类也继承了其他类，那么直接基类的构造方法也要调用它自身的直接基类的构造方法.

在派生类中调用它的直接基类的构造方法的方法为:

1. 在派生类的构造方法中不显式地调用直接基类的构造方法，那么虚拟机会自动在派生类的构造方法中插入调用直接基类的无参构造方法的语句 ```super()```，并且它是派生类的构造方法的第一个语句.
    > 如果我们有两个类 ```Parent``` 和 ```Child```, 其中后者继承前者，它们的定义分别为:
   > ```java
   > class Parent {
   >    String data;
   >    
   >    public Parent() {}
   >    public Parent(String data) {
   >        this.data = data;
   >    }
   > }
   > 
   > class Child extends Parent{
   >    String data;
   >    
   >    public Child() {}
   >    public Child(String data) {
   >        this.data = data;
   >    }
   > }
   > ```
   >
   > 那么 ```Child``` 类中的无参构造方法 ```Child()``` 和有参构造方法 ```Child(String data)``` 的方法体等价于:
   > ```java
   > class Child extends Parent {
   >    String data;
   >    
   >    public Child() {
   >        super();
   >    }
   >    
   >    public Child(String data) {
   >        super();
   >        this.data = data;
   >    }
   > }
   > ```

2. 在派生类的构造方法中显式地调用直接接类的构造方法，如果调用无参构造方法，那么需要通过语句 ```super()```，如果调用有参构造方法，那么需要通过语句 ```super(参数列表)```. 并且调用直接基类的构造方法的语句必须是派生类的构造方法的第一个被执行的语句.
   
   1. 在 ```Child``` 类中显示的调用 ```Parent``` 类的无参构造方法:

      > ```java
      > class Child extends Parent {
      >     String data;
      >     
      >     public Child() {
      >         super();
      >         System.out.println("constructor without parameters");
      >     }
      >     
      >     public Child(String data) {
      >         super();
      >         this.data = data;
      >         System.out.println("constructor with parameters");
      >     }   
      > }
      > ```
   
   2. 在 ```Child``` 类中显示的调用 ```Parent``` 类的有参构造方法:

      > ```java
      > class Child extends Parent {
      >     String data;
      >     
      >     public Child() {
      >         super("default");
      >         System.out.println("constructor without parameters");
      >     }
      >     
      >     public Child(String data) {
      >         super(data);
      >         this.data = data;
      >         System.out.println("constructor with parameters");
      >     }   
      > }
      > ``` 
   
   3. 下面的 ```Child``` 类的构造方法的方法体是非法的，因为其中的 ```super()``` 和 ```super(参数列表)``` 语句不是构造方法中的第一个语句:

      > ```java
      > class Child extends Parent {
      >     String data;
      >     
      >     public Child() {
      >         System.out.println("constructor without parameters");
      >         super("default");
      >     }
      >     
      >     public Child(String data) {
      >         this.data = data;
      >         super(data);
      >         System.out.println("constructor with parameters");
      >     }   
      > }
      > ``` 

## 2. ```this``` 关键字

在类的构造函数中可以调用该类的其他重载的构造函数，调用的方法如下:

1. 在无参构造函数中，通过语句 ```this(参数列表)``` 调用该类自身的其他有参构造函数. 并且 ```this(参数列表)``` 语句必须是无参构造函数的第一个语句，因此这时不能在无参构造函数中使用 ```super``` 或 ```super(参数列表)``` 语句:

   > ```java
   > class Child extends Parent {
   >     String data;
   >     
   >     public Child() {
   >         this("default");
   >     }
   >     
   >     public Child(String data) {
   >         this.data = data;
   >         System.out.println("constructor with parameters");
   >     }   
   > }
   > ```

2. 在有参构造函数中，通过语句 ```this()``` 或 ```this(参数列表)``` 调用该类自身的无参构造函数或者其他的有参构造函数，并且 ```this()``` 或 ```this(参数列表)``` 语句也必须是构造函数的第一个语句，同理，这时不能在构造函数中使用 ```super()``` 和 ```super(参数列表)``` 语句:

   > ```java
   > class Child extends Parent {
   >     String data;
   >     
   >     public Child() {
   >         this("default");
   >     }
   >     
   >     public Child(String data) {
   >         this();
   > 
   >         this.data = data;
   >         System.out.println("constructor with parameters");
   >     }
   > 
   >     public Child(String data, String data) {
   >        this(data + ", " + data);
   >     }  
   > }
   > ```