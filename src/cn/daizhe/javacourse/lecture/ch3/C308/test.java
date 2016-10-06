package cn.daizhe.javacourse.lecture.ch3.C308;

class creature{
	protected int i =2;
	public creature(){
		System.out.println("creature constructor before i:"+i);
		this.display();
		System.out.println("creature constructor after i:"+i);
	};
	public void display(){
		System.out.println(i);
	};
};

class animal extends creature{
	private int i = 4;
	public animal(){
		System.out.println("animal constructor before i:"+i+"super i:"+super.i);
		i = 5;
		System.out.println("animal constructor after i:"+i+"super i:"+super.i);
	};
	public void display(){
		System.out.println("animal display :"+i+"super i:"+super.i);
	};
};

public class test{
	public static void main(String[] args){
		new animal();
		
		new creature();
	};
};