package jo.secondstep.demothread;
public class Test {
	public static void main(String[] args) {
		
	  Runnable myThread=new Runnable() {
        @Override
		public void run() {
			for(int i=0;i<100;i++)
				System.out.println(Thread.currentThread().getName()+ i); 
        } };
	 
		Thread t1=new Thread(myThread);
		t1.setName("Thread1 : ");
		t1.start();
		
		Thread t2=new Thread(myThread);
		t2.setName("Thread2 : ");
		t2.start();
		
		Thread t3=new Thread(myThread);
		t3.setName("Thread3 : ");
		t3.start();
		
		
	}

}
