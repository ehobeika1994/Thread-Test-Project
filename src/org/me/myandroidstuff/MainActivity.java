package org.me.myandroidstuff;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements Runnable
{
	private TextView aview;
	private int count = 0;
	private Handler h;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		aview = ((TextView)findViewById(R.id.countLabel));
		// Create a Handler object to allow separate Thread to
		// communicate with the UI Thread
		h = new Handler();
		
		// Now produce a separate Thread of execution 
		// and ask for it to be scheduled		
		new Thread(this).start();
				
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		
		
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		
		
	}

	// Create a separate thread of execution
	@Override
	public void run() 
	{
		count = 0;
		do
		{
			// Use post method of handler  
			// to update the UI Thread
			h.post(new Runnable()
			{
				public void run()
				{
				
					aview.setText("" + count);	
					
					String value = (String) aview.getText();
					// Use Log Class to provide some debug/diagnostic output
					Log.e("MyTag",""+ count);
					Log.e("MyTag value",""+ value);
									
				}
			
			});
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception ae)
			{
				
			}
			// Update the count
			count = count + 1;
			
		} // Repeat for a 1000 seconds
		while (count<1000);
	}

}
