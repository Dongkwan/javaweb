package thread.account.problem2;


class Producer extends Thread {
	private BankAccount account;

	public Producer(BankAccount acct) {
		account = acct;
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			synchronized (account) {
				account.deposit(10);
			}
		}
	}
}