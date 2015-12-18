package com.example.servicetest;


import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;


public class MainActivity extends Activity {

	private static String TAG="com.example.actiontest";
	Intent intent ;
	private ITestOp binder;
	private Conn conn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,MyService.class);
        conn=new Conn();
    }

    public void start(View view){
    	startService(intent);
    }
    public void stop(View view){
    	stopService(intent);
    }
    public void exit(View view){
    	this.finish();
    }
    public void bind(View view){
    	bindService(intent, conn, BIND_AUTO_CREATE);
    }
    public void unbind(View view){
    	unbindService(conn);
    }
    public void method(View view){
    	binder.testOpService();
    }
    @Override
	protected void onDestroy() {
		Log.i(TAG, "MainActivity:onDestroy");
		Toast.makeText(getApplicationContext(), "MainActivity:onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, "MainActivity:onPause");
		Toast.makeText(getApplicationContext(), "MainActivity:onPause", Toast.LENGTH_LONG).show();
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, "MainActivity:onPause");
		Toast.makeText(getApplicationContext(), "MainActivity:onRestart", Toast.LENGTH_LONG).show();
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, "MainActivity:onResume");
		Toast.makeText(getApplicationContext(), "MainActivity:onResume", Toast.LENGTH_LONG).show();
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(TAG, "MainActivity:onStart");
		Toast.makeText(getApplicationContext(), "MainActivity:onStart", Toast.LENGTH_LONG).show();
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, "MainActivity:onStop");
		Toast.makeText(getApplicationContext(), "MainActivity:onStop", Toast.LENGTH_LONG).show();
		super.onStop();
	}

	private class Conn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {//绑定服务时调用
			binder=(ITestOp) service;
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {//解绑定服务时调用
			binder=null;
			
		}
		
	}
	
	
    
}
