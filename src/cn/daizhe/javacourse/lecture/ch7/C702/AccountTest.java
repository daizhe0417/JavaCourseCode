package cn.daizhe.javacourse.lecture.ch7.C702;

class Account {
	private String name; // 储户姓名
	private double balance; // 账户余额

	public Account(String name) {
		this.name = name;
		this.balance = 0;
	}

	public String getName() // 返回账户名
	{
		return name;
	}

	public double balance() // 查看账户余额
	{
		return balance;
	}

	public void put(double value) // 存款操作，参数为存入金额
	{
		if (value > 0)
			this.balance += value; // 存款操作使余额值增加
	}

	public double get(double value) // 取款操作，参数为取款金额，返回实际取到金额
	{
		if (value > 0) {
			if (value <= this.balance)
				this.balance -= value; // 取款操作使余额值减少
			else // 账户余额不够所取时
			{
				value = this.balance; // 取走全部余额
				this.balance = 0;
			}
			return value; // 返回实际取款额
		}
		return 0;
	}
}

class Save extends Thread // 存款线程类
{
	private Account account; // 账户
	private double value; // 存款金额

	public Save(Account a1, double value) {
		this.account = a1;
		this.value = value;
	}

	public void run() {
		synchronized (this.account) {
			double howmatch = this.account.balance();// 查看账户余额

			try {
				sleep(1); // 花费时间，线程执行被打断
			} catch (InterruptedException e) {
			}

			this.account.put(this.value);
			System.out.println(this.account.getName() + "账户：现有" + howmatch
					+ ", 存入" + this.value + ", 余额" + this.account.balance());
		}
	}
}

class Fetch extends Thread // 取款线程类
{
	private Account account; // 账户
	private double value; // 取款金额

	public Fetch(Account a1, double value) {
		this.account = a1;
		this.value = value;
	}

	public void run() {
		synchronized (this.account) {
			double howmatch = this.account.balance();// 查看账户余额

			try {
				sleep(1); // 花费时间，线程执行被打断
			} catch (InterruptedException e) {
			}

			System.out.println(this.account.getName() + "账户：现有" + howmatch
					+ ", 取走" + this.account.get(this.value) + ", 余额"
					+ this.account.balance());
		}
	}

}

public class AccountTest {
	public static void main(String args[]) {
		Account wang = new Account("Wang");
		(new Save(wang, 100)).start();
		(new Save(wang, 200)).start();
		(new Fetch(wang, 300)).start();

		(new Save(new Account("Li"), 100)).start();
	}
}

/*
 * 实际取走300元。程序运行结果如下： Wang账户：现有0.0, 存入100.0, 余额100.0 Wang账户：现有0.0, 存入200.0,
 * 余额300.0 //有错，三者数据不符 Wang账户：现有0.0, 取走300.0, 余额0.0 //有错，三者数据不符 Li账户：现有0.0,
 * 存入100.0, 余额100.0
 * 
 * 没有sleep语句时，程序设计运行结果与线程调度有关。可能为
 * 
 * Wang账户：现有0.0, 存入100.0, 余额100.0 Wang账户：现有100.0, 取走100.0, 余额0.0 Wang账户：现有0.0,
 * 存入200.0, 余额200.0
 * 
 * Wang账户：现有0.0, 存入100.0, 余额100.0 Wang账户：现有100.0, 存入200.0, 余额300.0
 * Wang账户：现有300.0, 取走300.0, 余额0.0
 * 
 * 
 * 扩充功能： 明细表 static int count; static final double overdraft=0.0; //透支
 * 
 * 自动分配账户号？
 * 
 * consume//消费
 * 
 * remainder
 * 
 * public int get(int i) throws EmptyException //欲取金额i,返回实际取到金额 { if (i>0 &&
 * i<=balance) { value -= i; //取款，value值减少 return i; //返回取款额 } else //账户余额不够所取时
 * { throw EmptyException("余额不满，取款操作未完成!"); //抛出异常 return 0; } }
 */