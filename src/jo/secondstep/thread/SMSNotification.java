package jo.secondstep.thread;

public class SMSNotification implements  FireSensorObserver {
    final private String phoneNumber;
    public SMSNotification(String phone)
    {
    	this.phoneNumber=phone;
    }
	@Override
	public void fireDetected() {
	 Runnable myThread = new Runnable(){
			@Override
			public void run() {
				for(int i =0;i<5;i++)
				  System.out.println(Thread.currentThread().getName()+"Send SMS message to "+phoneNumber);
				
			}};
			
			Thread t4=new Thread(myThread);
			t4.setName("Thread SMS Notification : ");
			t4.start();
			}

}
