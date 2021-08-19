package jo.secondstep.thread;



public class TestCase {
	
	public static void main(String[] args)
	{   FireSensor fireSensor=new FireSensor(); 
	FireDepartment fireDepartment=new FireDepartment();
	FireSprinkler fireSprinkler=new FireSprinkler();
	   SMSNotification smsNotification=new SMSNotification("0779228301");
	   SMSNotification smsNotification1=new SMSNotification("0778000000");
	  
	   fireSensor.addAction(fireDepartment);
	   fireSensor.addAction(smsNotification);
	   fireSensor.addAction(fireSprinkler);
	 
	   fireSensor.addAction(smsNotification1);

  Runnable myThread = new Runnable(){
      @Override
      public void run() { 
    	  System.out.println(Thread.currentThread().getName());
    	   fireSensor.fireDetected();
      }
};

Thread t1=new Thread(myThread);
t1.setName("*  Thread Main  *");
t1.start();

	}

}
