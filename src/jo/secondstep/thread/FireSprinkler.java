package jo.secondstep.thread;

public class FireSprinkler implements  FireSensorObserver{

	@Override
	public void fireDetected() {

	 Runnable myThread = new Runnable(){
	@Override
	public void run() {
		for(int i =0;i<5;i++)
		  System.out.println(Thread.currentThread().getName()+" Turn on the water sprinklers");
		
	}};
	
	Thread t5=new Thread(myThread);
	t5.setName("Thread Fire Sprinkler : ");
	t5.start();
	}

}
