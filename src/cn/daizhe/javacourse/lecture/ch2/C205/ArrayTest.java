package cn.daizhe.javacourse.lecture.ch2.C205;

/**
 * 关于数组的声明、使用
 *
 * @author venice
 * @version 2012-03-05
 */
public class ArrayTest {
    public static int aa;

    public static void main(String[] args) {
        // =================================
        // 数组的声明

        // 与C语言的声明不同，前面没有数字，后面有
        // int a[5];

        // 声明数组引用
        int a[] = null;
        // int a[];

        int aaa;

        // 数组引用还未指向任何数组，不能使用
        // 直接输出时是null
        System.out.println(aa);

        // =================================
        // 数组的使用
        // 下面语句运行时将报空指针异常
        // 因为还未将数组引用a指向任何数组，a的值为null，a[0]将空指针异常
        // System.out.println(a[0]);

        // new操作符创建数组并用引用a指向该数组，创建时需给出数组的长度
        a = new int[10];

        // 数组中的数据在new时将自动初始化，下面的代码将输出起默认值
        System.out.println("数组数据的初始化：");
        for (int i = 0; i < a.length; i++)
            // length表示数组长度
            System.out.print("   " + a[i]);

        // 注意下标不能越界，下面输出语句将报越界异常
        // System.out.println(" " + a[10]);

        System.out.println("");

        // 基本数据类型不会自动初始化，下面的输出语句会报错
        int base;
        // System.out.println(base);

        // =================================
        // 为数组元素赋值
        for (int i = 0; i < 5; i++)
            a[i] = i;

        System.out.println("为数组元素赋值：");
        for (int i = 0; i < a.length; i++)
            System.out.print("   " + a[i]);// a.length表示的是数组的实际长度还是占用的空间

        System.out.println("");

        // =================================
        // 数组的复制
        System.out.println("数组的复制：");
        int x[];
        x = a;
        for (int i = 0; i < x.length; i++)
            System.out.print("   " + x[i]);

        System.out.println("");

        // arraycopy函数原型
        // public static void arraycopy(Object src, int srcPos, Object dest,int
        // destPos,int length)
        System.arraycopy(a, 0, x, 1, 4);
        for (int i = 0; i < x.length; i++)
            System.out.print("   " + x[i]);

        // =================================
        // 二维数组
        int mat1[][];
        mat1 = new int[2][3];
        int mat2[][] = new int[3][4];
        int mat3[][] = {{1, 2, 3}, {4, 5, 6}};

        // 可定义不规则二维数组
        int xx[][] = new int[3][];
        xx[0] = new int[3];
        xx[1] = new int[2];

    }
}
