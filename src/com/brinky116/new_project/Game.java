
/*
 * Evan Davies
 * 3 October 2015
 */

package com.brinky116.new_project;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = 169;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	public Game()
	{
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}//Ends Game constructor
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}//Ends start
	
	public synchronized void stop()
	{
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}//Ends try/catch block
	}//Ends stop

	public void run()
	{
		while(running)
		{
			System.out.println("Running");
		}//Ends while loop
	}//Ends run
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Reference.GAME_TITLE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}//Ends main
}//Ends class