package models;

import java.time.Instant;

public class Transaction {
	private double amount;
	private long timestamp;


	public Transaction(String amount) {
		this.amount = Double.parseDouble(amount);
		this.timestamp = Instant.now().getEpochSecond();
	}

	public double getAmount() {
		return this.amount;
	}
	
	public long getTimestamp() {
		return this.timestamp;
	}
}