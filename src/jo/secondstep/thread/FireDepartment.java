package jo.secondstep.thread;

public class FireDepartment implements  FireSensorObserver{

	@Override
	public void fireDetected() {

	 Runnable myThread = new Runnable(){
	@Override
	public void run() {
		for(int i =0;i<5;i++)
		  System.out.println(Thread.currentThread().getName()+"Calling the fire department 911");
		
		
	}};
	
	Thread t4=new Thread(myThread);
	t4.setName("Thread Fire Department : ");
	t4.start();
	}

}
