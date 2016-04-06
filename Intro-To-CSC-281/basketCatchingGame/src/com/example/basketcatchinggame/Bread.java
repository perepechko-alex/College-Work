package com.example.basketcatchinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.TextView;

public class Bread implements Runnable
{
	
	float x,y;
	float scale;
	MainActivity mainactivity;

	public Bread(float x, float y) {
		
		this.x = x;
		this.y = y;
		new Thread(this).start();
		//super();
		//this.mainactivity=(MainActivity)context; // takes everything from the bread class to the mainactivity class
	}
	

	// thread for bread generation
	
	@Override
	public void run()
	{
		
		while (true)
		{
		 // thread that generates bread x number of times;
			y+=250;
			if((Math.abs(y-6500)<=116) && (Math.abs(x-MainActivity.x) <= 400))
			{
				MainActivity.score+=1;
				//MainActivity.textView.setText("Bread Caught: " + MainActivity.score);
				System.out.println(MainActivity.score);
				System.out.println("This is x: " + x);
				System.out.println("This is MainActivity X: " + MainActivity.x);
				y=10000000;
				break;
//				MainActivity.plotview.invalidate();

			}
			
			if(y == 7500)
			{
				MainActivity.breadNotCaught+=1;
				if(MainActivity.breadNotCaught == 10)
					System.exit(0);
				
			}
			MainActivity.plotview.postInvalidate();

			try
			{
				Thread.sleep(300);  // delay of thread refreshing
			}
			
			catch(InterruptedException e)
			{
				e.printStackTrace();  
			
			}
			
		}
		
	}
}
