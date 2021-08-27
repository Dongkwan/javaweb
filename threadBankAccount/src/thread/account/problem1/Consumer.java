package thread.account.problem1;

class Consumer extends Thread {
	private BankAccount account;

	public Consumer(BankAccount acct) {
		account = acct;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			account.withdraw(10);
		}
	}
}