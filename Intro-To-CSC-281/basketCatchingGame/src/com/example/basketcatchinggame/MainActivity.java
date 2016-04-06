package com.example.basketcatchinggame;

import java.util.ArrayList;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup;

public class MainActivity extends Activity implements Runnable
{

	static PlotView plotview;
	
	static float x = 3000;
	static float y = 0;
	static int score = 0;
	static ArrayList<Bread>bready = new ArrayList<Bread>();
	static int breadNotCaught = 0;
	
	static TextView textView;
	/* // we're trying to get the bread to drop at random intervals
	Bread breads[]; // array of bread
	for (int i = 0, i < 100; i++)
	{
		Bread breadpaint = new Bread();
		x changes to random position 
	}
	*/
	
	
	
	boolean isMoving = false;
	static Bitmap basket, bread;

	public class PlotView extends View
	{
		float scale;
		
	public PlotView(Context context) // passing in 'context'. It allows you to access other resources and classes.
	{
			super(context);  // superclass
			
			// the bottom two create the bitmap images on the screen
			basket = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
					getResources(), R.drawable.basket), 1000, 1000, false);	
			
			
			bread = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
					getResources(), R.drawable.bread), 1000, 1000, false);  // 1000 is height and width of bread. 
	}
	
		protected void onDraw(Canvas g) // scaling the bitmap
	{
		if (g.getWidth() < g.getHeight())
			scale = (float) g.getWidth() / 7000;
		else
			scale = (float) g.getHeight() / 7000;
		
		g.scale(scale, scale);
		Paint paint = new Paint();  // creating new instance of paint. 
		paint.setColor(Color.WHITE);
		paint.setTextSize(700);
		
		String scoreString = "Score: " + Integer.toString(score);
		g.drawText(scoreString, 0, 1000, paint);
		String breadLost = "Lost Bread: " + Integer.toString(breadNotCaught);
		g.drawText(breadLost,0,1500,paint);
		g.drawBitmap(basket, x, 6500, paint);  // paint is called and this creates a bitmap of the basket and further on, of the bread.
		
		for(int i = 0; i < bready.size(); i++)
			g.drawBitmap(bread, bready.get(i).x, bready.get(i).y, paint);  // draws the bread on the bitmap; already scaled on the bread class.
			
	}
		
	
	}
	
	// this deals with the buttons
	// plotview is the actual screen
	// gameLayout is the buttons on plotview
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		
		// !!!!!!!!!!!!!!!!!! CHOOSE ONE OF THESE FOR THE PROJECT SINCE BOTH DO SIMILAR THINGS
		
		//bready= new ArrayList<Bread>();  // linkedlist of bready
			
		
		setContentView(R.layout.activity_main);  // shows the layout of activity_main on the android. Always place in android.
		plotview = new PlotView(this);  // now show everything at its correct place
		ViewGroup gameLayout = (ViewGroup) findViewById(R.id.gameLayout);
		gameLayout.addView(plotview);
		
		
		setContentView(gameLayout);
		
		
		//textView = (TextView) findViewById(R.id.textView1);
		//textView.setText("Bread Caught: " + score); // shows the amount of bread caught ON the screen of the tablet
		
		
		new Thread(this).start();  // it starts the thread before you paint the objects in the thread, meaning no delays would occur if this was not included.

		
		findViewById(R.id.leftButton).setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
					
				if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
				{
					isMoving = true;
					new Thread()
					{
						public void run()
						{
							while(isMoving)
							{
								x-=50;
								try
								{
									Thread.sleep(100);  // delay of thread refreshing
								}
								catch(InterruptedException e)
								{
									e.printStackTrace();  
								
								}
							}
						}
					}.start();
					
					//plotview.postInvalidate();
					
					
				}
	
				else if(event.getAction() == MotionEvent.ACTION_UP)  // finger lifted up from button --> basket stops moving
					
				{
					isMoving = false;
					
				}
		
				plotview.postInvalidate();					
				return true;			
				}
			
		});
		
		findViewById(R.id.rightButton).setOnTouchListener(new OnTouchListener(){

	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
				{
					isMoving = true;
					new Thread()
					{
						public void run()
						{
							while(isMoving)
							{
								x+=50;
								
								try
								{
									Thread.sleep(100);  // delay of thread refreshing
								}
								catch(InterruptedException e)
								{
									e.printStackTrace();  
								
								}
							}
						}
					}.start();
					
					//plotview.postInvalidate();
					
					
				}
				
				else if(event.getAction() == MotionEvent.ACTION_UP)
				{
					isMoving = false;
					
				}
		
				plotview.postInvalidate();					
				return true;			
				}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// this is the thread for generating the y coordinates of the bread
	@Override
	public void run() 
	{
		while(true)
		{
			bready.add(new Bread((float) Math.random()*6250, (float) y));
			plotview.postInvalidate();  // postInvalidate is like repaint in regular java;
			
			try
			{
				Thread.sleep(4000);  // delay of thread refreshing
			}
			
			catch(InterruptedException e)
			{
				e.printStackTrace();  
			
			}
		}		
	}
	

	}
