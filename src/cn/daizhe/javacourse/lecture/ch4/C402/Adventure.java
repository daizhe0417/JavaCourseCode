package cn.daizhe.javacourse.lecture.ch4.C402;

/**
 * c08:Adventure.java
 * Extending an interface with inheritance.
 * @author Bruce Eckel *
 */

interface CanFight extends CanSwim{
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	private String name;
	public void fight() {
	}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {
	public void fight() {
	}
	public void swim() {
	}

	public void fly() {
	}
}

public class Adventure {
	static void t(CanFight x) {
		x.fight();
	}

	static void u(CanSwim x) {
		x.swim();
	}

	static void v(CanFly x) {
		x.fly();
	}

	static void w(ActionCharacter x) {
		x.fight();
	}

	public static void main(String[] args) {
		CanFight h = new Hero();
		CanFly f=new Hero();
		t(h); // Treat it as a CanFight
		u(h); // Treat it as a CanSwim
//		v(h); // Treat it as a CanFly
//		w(h); // Treat it as an ActionCharacter
	}
} // /:~