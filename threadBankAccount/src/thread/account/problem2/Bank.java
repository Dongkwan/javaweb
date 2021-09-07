package thread.account.problem2;


public class Bank {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(); //zero account balance
		int slaveCount = 4;
		Thread[] slaves = new Thread[slaveCount];
		for (int i = 0; i < slaveCount; i++) {
			if (i % 4 == 3) {
				slaves[i] = new Producer(account);//array index:3
			} else {
				slaves[i] = new Consumer(account);//array index:0, 1, 2
			}
		}
		for (int i = 0; i < slaveCount; i++) {
			slaves[i].start();
		}
		for (int i = 0; i < slaveCount; i++) {
			try {
				slaves[i].join();
			} catch (InterruptedException ie) {
				System.err.println(ie.getMessage());
			} finally {
				System.out.println("slave " + i + " has died");
			}
		}
		System.out.print("Closing balance = ");
		System.out.println("$" + account.getBalance());
	}
}