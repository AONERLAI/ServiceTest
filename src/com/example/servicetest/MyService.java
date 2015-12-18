package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{

	private IBinder binder=new TestOpBinder();
	

	public MyService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(getApplicationContext(), "onBind", Toast.LENGTH_LONG).show();
		return binder;
	}

	@Override
	public void onCreate() {
		Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

	@Override
	public void onRebind(Intent intent) {
		Toast.makeText(getApplicationContext(), "onRebind", Toast.LENGTH_LONG).show();
		super.onRebind(intent);
	}

	

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "onStartCommand", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Toast.makeText(getApplicationContext(), "onUnbind", Toast.LENGTH_LONG).show();
		return super.onUnbind(intent);
	}

	public void method(){
		Toast.makeText(getApplicationContext(), "这是服务里的方法", Toast.LENGTH_LONG).show();
	}
	
	private class TestOpBinder extends Binder implements ITestOp{

		@Override
		public int testOpService() {
			method();
			return 0;
		}
		
		
	}
	
}
