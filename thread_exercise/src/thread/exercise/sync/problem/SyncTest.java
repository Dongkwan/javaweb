package thread.exercise.sync.problem;


import java.util.ArrayList;

public class SyncTest {
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		input.add("A");
		input.add("B");
		input.add("C");
		input.add("D");

		Thread th1 = new MyThread(input, "th1");
		th1.start();
		
		Thread th2 = new MyThread(input, "th2");	
		th2.start();
	}
}
