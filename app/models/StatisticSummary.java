package models;
import models.Statistic;

public class StatisticSummary {
	private long count;
	private double amount;

	public StatisticSummary() {
		this.count = 0;
		this.amount = 0;
	}

	public double getAverage() {
		if (this.amount == 0 && this.count == 0) {
			return 0.0;
		}
		return this.amount/this.count;
	}

	public StatisticSummary(Statistic statistic) {
		this.count = statistic.getCount();
		this.amount = statistic.getAmount();
	}

	public long getCount() {
		return this.count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}