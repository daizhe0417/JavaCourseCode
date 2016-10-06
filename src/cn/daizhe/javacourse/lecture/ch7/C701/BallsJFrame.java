package cn.daizhe.javacourse.lecture.ch7.C701;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class BallsCanvas extends Canvas implements ActionListener,FocusListener{
	private Ball balls[];
	private Timer timer;
	
	private static class Ball{
		int x,y;
		Color color;
		boolean up,left;
		Ball(int x,int y,Color color){
			this.x=x;
			this.y=y;
			this.color=color;
			up=false;
			left=false;
		}
	}
	public BallsCanvas(Color colors[],int delay){
		this.balls=new Ball[colors.length];
		for(int i=0,x=40;i<colors.length;i++,x+=40){
			balls[i]=new Ball(x,x,colors[i]);
		}
		this.addFocusListener(this);
		timer=new Timer(delay,this);
		timer.start();
	}
	public void setDelay(int delay){
		timer.setDelay(delay);
	}
	public void paint(Graphics g){
		for(int i=0;i<balls.length;i++){
			g.setColor(balls[i].color);
			balls[i].x=balls[i].left?balls[i].x-10:balls[i].x+10;
			if(balls[i].x<=0||balls[i].x>this.getWidth()){
				balls[i].left=!balls[i].left;
			}
			balls[i].y=balls[i].up?balls[i].y-10:balls[i].y+10;
			if(balls[i].y<=0||balls[i].y>this.getHeight()){
				balls[i].up=!balls[i].up;
			}
			g.fillOval(balls[i].x, balls[i].y, 20,20);
		}
	}
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	public void focusGained(FocusEvent e){
		timer.stop();
	}
	public void focusLost(FocusEvent e){
		timer.restart();
	}
}


public class BallsJFrame extends JFrame implements ChangeListener {

	private BallsCanvas ball;
	private JSpinner spinner;
	
	public BallsJFrame(){
		super("弹弹球");
		this.setBounds(300,200,480,360);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color colors[]={Color.red,Color.green,Color.blue,Color.magenta,Color.cyan};
		ball = new BallsCanvas(colors,100);
		this.getContentPane().add(ball);
		
		JPanel panel=new JPanel();
		this.getContentPane().add(panel,"South");
		panel.add(new JLabel("Delay"));
		spinner=new JSpinner();
		spinner.setValue(100);
		panel.add(spinner);
		spinner.addChangeListener(this);
		this.setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		ball.setDelay(Integer.parseInt(spinner.getValue().toString()));
	}
	public static void main(String args[]){
		new BallsJFrame();
	}
}
