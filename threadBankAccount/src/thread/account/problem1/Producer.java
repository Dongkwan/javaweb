package thread.account.problem1;

class Producer extends Thread {
	private BankAccount account;

	public Producer(BankAccount acct) {
		account = acct;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			account.deposit(10);
		}
	}
}