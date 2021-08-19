package jo.secondstep.thread;

import java.util.ArrayList;
import java.util.List;
public class FireSensor{
	 private List<FireSensorObserver>  Oserver= new ArrayList<>();
	 
	 public   void addAction(FireSensorObserver fireSensorObserver)
	 {
		synchronized(FireSensor.class) 
		 {Oserver.add(fireSensorObserver);}
	 }
	 public   void RemoveAction(FireSensorObserver fireSensorObserver)
	 {    synchronized(FireSensor.class)
		 { 
		 Oserver.remove(fireSensorObserver);
		 
		 }
	 }
	 
	 public void fireDetected() {
		  
		Thread t2 = new Thread(new Runnable()
		{  
		      @Override
		      public void run() {
		    	
		    synchronized(FireSensor.class) { 
		   for(FireSensorObserver fireSensorObserver :Oserver) 
		   {     
			   
		  	 System.out.println(Thread.currentThread().getName());
		       fireSensorObserver.fireDetected();
		        
		   }
			 } }
		      
		 
	});

	 t2.setName("*  Thread Class  * ");
	 t2.start();
	 }


}
