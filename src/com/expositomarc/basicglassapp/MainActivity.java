package com.expositomarc.basicglassapp;

// Basic Android libraries
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

// Specific Glass libraries for gesture detection
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;


public class MainActivity extends Activity {

	// Gesture detector for tapping
	private GestureDetector mGestureDetector;
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        
    	// Register gesture detector
        mGestureDetector = createGestureDetector(this);

        setContentView(R.layout.activity_main);    
    }


    private GestureDetector createGestureDetector(Context context) {
    	
    	// Register gesture detector from context
        GestureDetector gdDetector = new GestureDetector(context);
        
        // Create a base listener for generic gestures
        gdDetector.setBaseListener( new GestureDetector.BaseListener() {
            
        	@Override
            public boolean onGesture(Gesture gesture) 
            {
        		// If we detect TAP (choose whatever gesture you want for your menu)
                if (gesture == Gesture.TAP) 
                {
                    // Call to open the menu
                    openOptionsMenu();
                    
                    return true;
                } 

                return false;
            }
        });

        return gdDetector;
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	// Create options from "/res/menu/main.xml"
    	getMenuInflater().inflate(R.menu.main, menu);
    	
    	return super.onCreateOptionsMenu(menu);
    }

    
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
    	
        if (mGestureDetector != null) 
            return mGestureDetector.onMotionEvent(event);

        return false;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        
    	// Get id for detect what item was selected
    	int id = item.getItemId();
        
    	switch (id) {
    		
    		case R.id.settings_1 : // Do something for setting 1
    			break;
    		
    		case R.id.settings_2 : // Do something for setting 2
    			break;
    		
    		default : // Something went wrong?
    			break;
    	
    	}
       
        return super.onOptionsItemSelected(item);
    }
    
}
