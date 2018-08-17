package models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Arrays;

import models.Transaction;
import models.Statistic;
import models.StatisticSummary;

public class TransactionStore {

	private static TransactionStore instance;
	private static final int SECONDS = 60;
	private static final Statistic[] statistics = new Statistic[SECONDS];

	public static TransactionStore getInstance() {
		if (instance == null) {
				instance = new TransactionStore();
		}
		return instance;
	}

	// Store incoming transaction(s) in respective slot
	// Create new statistic in slot if empty or if slot is stale
	// For multiple statistics in same slot increase count and sum transaction amount
	public Transaction addTransaction(Transaction transaction) {
		int slot = LocalDateTime.ofInstant(Instant.ofEpochMilli(transaction.getTimestamp()*1000), ZoneId.systemDefault()).getSecond();
		if (statistics[slot] == null || (System.currentTimeMillis()/1000) - statistics[slot].getTimestamp() >= SECONDS)
		{
			statistics[slot] = new Statistic();
			statistics[slot].setTimestamp(transaction.getTimestamp());
			statistics[slot].setAmount(transaction.getAmount());
			statistics[slot].setCount(1);
		} 
		else
		{
			statistics[slot].setAmount(statistics[slot].getAmount() + transaction.getAmount());
			statistics[slot].setCount(statistics[slot].getCount() + 1);
		}
		return transaction;
	}

	// Make sure to get only latest transactions and sum count/amount
	public StatisticSummary getStatistics() {
		StatisticSummary summary = 
			Arrays.stream(statistics)
				.filter(s -> {
					if (s != null) {
						boolean isStale = (System.currentTimeMillis()/1000 - s.getTimestamp()) < SECONDS; 
						return isStale;
					}
					return false;
				})
				.map(StatisticSummary::new)
				.reduce(new StatisticSummary(), (s1, s2) -> {
					s1.setAmount(s1.getAmount() + s2.getAmount());
					s1.setCount(s1.getCount() + s2.getCount());
					return s1;
				});
		return summary;
	}

}
