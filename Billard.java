import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;
public class Billard extends JFrame
{

	private int onex=7,oney=7;
	private boolean up=false,down=true,left=false,right=true;
	private DrawPanel pan;
	private Random r=new Random();
	public Billard()
	{
		super("Pool");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,400);
		pan=new DrawPanel();
		this.add(pan,BorderLayout.CENTER);
		this.setVisible(true);
		playIt();
		
	}
	public void playIt()
	{
		while(true)
		{
			if(onex>=290)
			{
				right=false;
				left=true;
			}
			if(oney>=370)
			{
				down=false;
				up=true;
			}
			if(onex<=10)
			{
				right=true;
				left=false;
			}
			if(oney<=10)
			{
				down=true;
				up=false;
			}
			if(up)oney-=r.nextInt(100);
			if(down)oney+=r.nextInt(100);
			if(left)onex-=r.nextInt(100);
			if(right)onex+=r.nextInt(100);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			pan.repaint();
		}
		
	}
	class DrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.fillOval(onex, oney, r.nextInt(25)+5, r.nextInt(25)+5);
		}
		
	}
	public static void main(String[] args) 
	{
	 Billard b1=new Billard();

	}

}
