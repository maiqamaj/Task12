package jo.secondstep.practiceoddeven;

//import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;

public class OddEvenSplit {
	// private Key keydata = new Key();
	final private List<Integer> data = new ArrayList<>();
	final private List<Integer> listOdd = new ArrayList<>();
	final private List<Integer> listEven = new ArrayList<>();
	private boolean active = true;
	private Thread T1, T2, T3;

	public OddEvenSplit(List<Integer> list) {
		this.data.clear();
		this.data.addAll(list);
		T1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Started");
				while (active) {
					// data.clear();
					// data.addAll(list);
					synchronized (data) {
						// System.out.println(Thread.currentThread().getName());
						if (data.isEmpty()) {
							try {
								data.wait(2000000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							for (Integer i : data) {
								if (i % 2 == 0) {
									synchronized (listEven) //
									{
										listEven.add(i);

										listEven.notify();
									}

								} else if (i % 2 != 0) {
									synchronized (listOdd) {
										listOdd.add(i);
										listOdd.notify();
									} //
								}
							}
							data.clear();
						}

					}
				}
			}

		});

		T2 = new Thread(new Runnable()

		{
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				while (active) {
					synchronized (listOdd) {
						System.out.println(Thread.currentThread().getName());

						if (listOdd.isEmpty()) {
							try {
								listOdd.wait();
							} catch (InterruptedException e) {
								System.out.println(e);
							}
						} else {

							for (Integer i : listOdd) {
								for (int j = 0; j < i; j++)
									System.out.print("#");
								System.out.println();
							}
							System.out.println();
							listOdd.clear();
						}
					}
				}
			}

		});

		T3 = new Thread(new Runnable()

		{
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				while (active) {
					synchronized (listEven) {
						System.out.println(Thread.currentThread().getName());
						if (listEven.isEmpty()) {
							try {
								listEven.wait();
							} catch (InterruptedException e) {
								System.out.println(e);
							}
						} else {

							for (Integer i : listEven) {
								for (int j = 0; j < i; j++)
									System.out.print("*");
								System.out.println();
							}
							System.out.println();
							listEven.clear();

						}
					}
				}
			}

		});

	}

	public void execute() {
		active = true;
		T1.setName("Thread List");
		T2.setName("Thread Odd List");
		T3.setName("Thread Even List");
		T1.start();
		T2.start();
		T3.start();
	}

	public void stop() {
		active = false;
	}

}
