package thread.account.problem1.sol;

import thread.account.problem1.BankAccount;

class Producer extends Thread {
	private BankAccount account;

	public Producer(BankAccount acct) {
		account = acct;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized (account) {
				account.deposit(10);
			}
		}
	}
}