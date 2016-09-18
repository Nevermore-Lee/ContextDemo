# ContextDemo
一，参考自郭霖的博客http://blog.csdn.net/guolin_blog/article/details/47028975
1.getApplication（）适用于Activity和Service中获取Application
2. getApplicationContext（）适用于Broadcast中获取Application
3.Context数量 = Activity数量 + Service数量 + 1
4.ContextWrapper中的attachBaseContext()方法由系统调用，把ContextImpl对象作为参数传递到attachBaseContext()方法中，从而给mBase赋值，之后ContextWrapper中的所有方法其实都是通过这种委托机智交由ContextImpl去具体实现。

 5.由上图可以得到的结论是，要在attachBaseContext（）方法之后调用ContextWrapper中提供的各种方法。
否则会遇到空指针的错误。
6.不要把Application和单例模式混用，例如以下情况
public class MyApplication extends Application {  
      
    private static MyApplication app;  
      
    public static MyApplication getInstance() {  
        if (app == null) {  
            app = new MyApplication();  
        }  
        return app;  
    }  
      
}  
Application是系统组件，是由系统创建的，此处的app只是一个简单的java对象，不具备任何Context的能力。
那么如果真的想要提供一个获取MyApplication实例的方法，比较标准的写法又是什么样的呢？其实这里我们只需谨记一点，Application全局只有一个，它本身就已经是单例了，无需再用单例模式去为它做多重实例保护了。
public class MyApplication extends Application {  
      
    private static MyApplication app;  
      
    public static MyApplication getInstance() {  
        return app;  
    }  
      
    @Override  
    public void onCreate() {  
        super.onCreate();  
        app = this;  
    }  
      
}  
