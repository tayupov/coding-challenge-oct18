package models;

import java.sql.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.DoubleSummaryStatistics;

import models.Transaction;
import models.Statistic;

public class TransactionStore {

	private static TransactionStore instance;
	private static final int SECONDS = 60;
	private static final Map<Integer, Statistic> lastMinuteStatistics = new ConcurrentHashMap<>(SECONDS);

	public static TransactionStore getInstance() {
		if (instance == null) {
				instance = new TransactionStore();
		}
		return instance;
	}

	public Transaction addTransaction(Transaction transaction) {
		int slot = LocalDateTime.ofInstant(Instant.ofEpochMilli(transaction.getTimestamp()*1000), ZoneId.systemDefault()).getSecond();
		lastMinuteStatistics.compute(slot, (key, statistic) -> {
			// if slot is not occupied or if slot is stale (older than 60 seconds)
			if (statistic == null || (System.currentTimeMillis()/1000) - statistic.getTimestamp() >= SECONDS) {
				statistic = new Statistic();
				statistic.setTimestamp(transaction.getTimestamp());
				statistic.setAmount(transaction.getAmount());
				statistic.setCount(1);
				return statistic;
			}
			statistic.setAmount(statistic.getAmount() + transaction.getAmount());
			statistic.setCount(statistic.getCount() + 1);
			return statistic;
			
		});
		return transaction;
	}

	public DoubleSummaryStatistics getStatistics() {
		DoubleSummaryStatistics summary = lastMinuteStatistics.values().stream()
																			.filter(statistic -> (System.currentTimeMillis()/1000 - statistic.getTimestamp()) < SECONDS)
																			.mapToDouble(s -> s.getAmount())
																			.summaryStatistics();
		return summary;
	}

}
