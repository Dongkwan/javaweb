package thread.exercise.sync.problem;


import java.util.ArrayList;
import java.util.Iterator;


class MyThread extends Thread{
	ArrayList<String> str;
	String thName;
	
	MyThread(ArrayList<String> str, String thName){
		this.str = str;
		this.thName = thName;
	}

	synchronized public void print(){
		Iterator<String> it = str.iterator();
		while(it.hasNext()){
			try {
				Thread.sleep(500);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(thName + ": " + it.next());
		}
	}

	@Override
	public void run(){
		print();
		System.out.println();
	}
}