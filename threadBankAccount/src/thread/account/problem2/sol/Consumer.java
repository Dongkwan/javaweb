package thread.account.problem2.sol;

class Consumer extends Thread {
	private BankAccount account;

	public Consumer(BankAccount acct) {
		account = acct;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized (account) {
				while (account.getBalance() < 10) {
					try {
						account.wait();
					} catch (InterruptedException ie) {
						System.err.println(ie.getMessage());
					}
				}
				account.withdraw(10);
			}
		}
	}
}