package cn.daizhe.javacourse.lecture.ch4.C404;

/**
 * //关于内部类
 * 
 * @author venice
 * @version 2013
 */

// 库存接口
interface Stock {
	int getNumber();

	void setNumber(int i);
}

// 目的地接口
interface Destination {
	String getLabel();

	void setLabel(String Label);
}

// 货物类
class Goods {
	private int rate = 2;

	// 内部类，实现库存接口
	class IStock implements Stock {
		// private int num = 11;// 内部类的成员变量

		// 内部类中定义与外部类同名变量时，内部类中默认访问内部类的变量，但可以使用Outer.this.的形式访问外部类的成员
		private int rate = 3;

		// 访问内部类的rate
		// private int num = 11 * rate;
		// 访问外部类的rate
		private int num = 11 * Goods.this.rate;

		// 实现库存接口的两个方法，注意必须是public的
		// 因为接口中的方法默认是public的，实现该方法不能降低访问权限
		public int getNumber() {
			return num;
		}

		public void setNumber(int num) {
			this.num = num;
		}
	}

	IStock i;

	// 内部类，实现目的地接口
	class IDestination implements Destination {
		private String label;// 内部类的成员变量

		IDestination i;

		// public IDestination getInstance(){
		// if(i==null){
		// i=new IDestination("aa");
		// }
		// return i;
		// }

		// 内部类的构造方法，可以是private的，此时只被Goods类内的方法访问
		IDestination(String whereTo) {
			// private IDestination(String whereTo) {
			// IDestination(String whereTo) {
			label = whereTo;
		}

		// 实现目的地接口的方法，必须是public的
		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
	}

	// Goods类的两个方法，分别创建库存内部类和目的地内部类的实例，
	// 并返回其引用，注意返回值类型是库存和目的地接口
	public Destination dest(String s) {
		return new IDestination(s);
	}

	public Stock sto() {
		return new IStock();
	}
	
	public void printDest(Destination d){
		System.out.println(d.getLabel());
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		Goods good = new Goods();// 货物类的实例，引用为good
		Stock s = good.sto();// 通过Goods类的方法返回库存接口类型的库存内部类实例
		Destination d = good.dest("Beijing");
		System.out.println("Stock number: " + s.getNumber());
		s.setNumber(19);
		System.out.println("Stock number: " + s.getNumber());
		System.out.println("destination: " + d.getLabel());
		
		Goods.IDestination dd=good.new IDestination("aaa");
//		good.printDest(new ID implements Destination{
//		}());
		
		// /*
		// 在外部类作用范围之外得到内部类实例方法之二
		Goods good2 = new Goods();
		Goods.IStock s2 = good2.new IStock();
		Goods.IDestination d2 = good2.new IDestination("fuxin");
		System.out.println("destination: " + d2.getLabel());
		// */
	}
}
