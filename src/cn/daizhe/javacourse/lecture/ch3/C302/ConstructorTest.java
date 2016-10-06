package cn.daizhe.javacourse.lecture.ch3.C302;

/**
 * 关于构造方法、构造方法重载、析构方法
 *
 * @author venice
 * @version 2013
 */
public class ConstructorTest {
    public static void main(String args[]) {

        // =================================
        // 使用构造方法

        // 这样的写法错误，必须用new操作符创建对象
        // Tdate t = Tdate(6, 2, 2007);

        // 若类中定义了任意参数形式的构造方法，默认的无参的构造方法将不能使用，除非自己定义了无参的构造方法
        // 下面对无参构造方法的调用，尝试在Tdate类的构造方法不同情况下，是否有效
        // Tdate t=new Tdate();

        // 下面直接访问类成员变量的做法虽然符合语法，但违反封装性原则
        // Tdate t1=new Tdate();
        // t1.m=6;t1.d=2;t1.y=2007;

        // 利用构造方法创建对象的正确方法
        // 创建对象时使用的构造方法必须与类中已有的构造方法对应
        Tdate t1 = new Tdate();
        Tdate t2 = new Tdate(3, 8, 2012);

        // 通过getter和setter方法访问类的成员变量，是封装的基本形式
        System.out.println("" + t1.getY() + "年" + t1.getM() + "月" + t1.getD() + "日");
        System.out.println("" + t2.getY() + "年" + t2.getM() + "月" + t2.getD() + "日");

        // 只能通过setter修改成员变量
        t1.setM(9);
        System.out.println("" + t1.getY() + "年" + t1.getM() + "月" + t1.getD() + "日");

        // =================================
        // 析构方法

        // 析构方法，在垃圾回收时调用，无以下两句时不会被显式调用
        t1 = null;// 使t1所指向的对象无人引用，即t1所指对象占用的空间成为垃圾
        System.gc();// 通知java虚拟机执行垃圾回收

        // =================================
        // 构造方法的重载

        // 下面创建对象时调用哪个构造方法，编译时根据参数确定
        Tdate t3 = new Tdate(5, 1);
        Tdate t4 = new Tdate(6, 2, 2012);

        // 拷贝构造方法
        Tdate t5 = new Tdate(t4);

        System.out.println("" + t1.getY() + "年" + t1.getM() + "月" + t1.getD() + "日");
        System.out.println("" + t2.getY() + "年" + t2.getM() + "月" + t2.getD() + "日");
        System.out.println("" + t3.getY() + "年" + t3.getM() + "月" + t3.getD() + "日");
        System.out.println("" + t4.getY() + "年" + t4.getM() + "月" + t4.getD() + "日");
        System.out.println("" + t5.getY() + "年" + t5.getM() + "月" + t5.getD() + "日");
    }
}

class Tdate {
    // 私有成员变量
    private int m, d, y;

    // 构造方法，public的，无返回值类型
    public Tdate(int m, int d, int y) {
        System.out.println("public Tdate(int m,int d,int y)");
        // Tdate类的成员变量m被构造方法的局部变量m隐藏
        // 使用this关键字引用成员变量m
        if (m >= 1 && m <= 12) {
            this.m = m;
        }
        this.d = d;
        this.y = y;
    }

    // 重载构造方法
    public Tdate(int m, int d) {
        System.out.println("public Tdate(int m,int d)");
        if (m >= 1 && m <= 12) {
            this.m = m;
        }
        this.d = d;
        y = 2007;
    }

    // 下面的声明不符合重载的规则，这样声明会编译错
    // public Tdate(int a, int b){
    //
    // }
    // 下面的声明不符合重载的规则，这样声明会编译错
    // public Tdate(int m,float d){
    //
    // }

    // 上面的方法不符合重载要求，因为他们的方法名实际上的形式都是：Tdate(int,int)

    // 重载构造方法
    public Tdate(int m) {
        System.out.println("public Tdate(int m)");
        this.m = m;
        d = 20;
        y = 2007;
    }

    // 重载构造方法
    public Tdate() {
        System.out.println("public Tdate()");
        m = 3;
        d = 20;
        y = 2007;
    }

    // 拷贝构造方法
    public Tdate(Tdate date) {
        System.out.println("public Tdate(Tdate date)");
        m = date.m;
        d = date.d;
        y = date.y;
    }

    // 访问私有成员变量的共有方法作为接口
    public int getM() {
        return m;
    }

    public int getD() {
        return d;
    }

    public int getY() {
        return y;
    }

    // 设置私有成员变量的值
    public void setM(int m) {
        this.m = m;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setY(int y) {
        this.y = y;
    }

    // 析构方法
    protected void finalize() {
        System.out.println("i'm finalized");
    }
}
