package cn.daizhe.javacourse.lecture.ch4.C403;

/*
//接口和抽象类的用法
//一个带报警功能的门，从门类得到，选择接口还是抽象类？
abstract class Door 
{
	abstract void open();
	abstract void close();
}
interface Alarm
{
	void alarm(); 
} 

interface Door
{
	void open();
	void close();
	void alarm();
}
class alarmdoor inmplements Door
{
	open
	close
	alarm
}

abstract class Door
{
	abstract void open();
	abstract void close();
} 
//带报警的门应该继承门类实现报警接口
//因为报警门本质上还是门，报警只是一个必须实现的功能
//继承表示“…是…”的关系，接口用于说明必须实现的功能
class AlarmDoor extends Door implements Alarm
//class AlarmDoor extends Alarm implements Door
{
	void open() {  }
	void close() {  }
	void alarm() {  } 
} 
*/