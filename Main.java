import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Main extends JFrame implements ActionListener,Runnable
{//threads
	private JPanel mainp,btnp;
	private JButton start;
	int x,y;
	public Main()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setLayout(new BorderLayout());
		mainp=new JPanel();
		btnp=new JPanel();
		start=new JButton("Start");
		btnp.add(start);
		start.addActionListener(this);
		this.add(mainp,BorderLayout.CENTER);
		this.add(btnp,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public static void main(String[] args) 
	{
		Main fr=new Main();


	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String s=e.getActionCommand();
		Thread t1=new Thread(this);
		t1.start();


	}
	public void run()
	{
		Graphics g= mainp.getGraphics();
		for(y=0;y<190;y+=11){
			for( x=0;x<290;x+=11)

			{
				g.fillOval(x, y, 10, 10);
				try 
				{
					Thread.sleep(100);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

}
