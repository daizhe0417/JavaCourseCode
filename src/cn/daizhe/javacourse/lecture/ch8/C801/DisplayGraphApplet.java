package cn.daizhe.javacourse.lecture.ch8.C801;

import java.awt.*;
import java.applet.*;

public class DisplayGraphApplet extends Applet
{
    private Image image;                                   //图像对象
    private int g_width,g_height;                          //图像大小
    private AudioClip audioclip;                           //音频对象
    
    public void init()
    {
        this.image = this.getImage(this.getDocumentBase(),"IMAGES/fruit.jpg");       //装载图像文件
        this.g_width = this.image.getWidth(this) / 2;
        this.g_height = this.image.getHeight(this) / 2;
        this.audioclip = this.getAudioClip(this.getDocumentBase(),"WAV/Sound.wav");  //装载音频文件
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(image,0,0,this.g_width,this.g_height,this);      //显示图像文件
        g.drawString("getDocumentBase()="+this.getDocumentBase().toString(),20,this.g_height+20);
    }

    public void start()
    {
        this.audioclip.play();                             //播放音频
//        this.play(this.getDocumentBase(),"Wav/Sound.wav"); 
    }
    
    public void stop()
    {
        this.audioclip.stop();                             //停止播放音频
    }
    
}