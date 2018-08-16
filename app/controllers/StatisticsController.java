package controllers;

import play.mvc.*;
import models.TransactionStore;

import java.util.DoubleSummaryStatistics;

public class StatisticsController extends Controller {
	
	public Result get() {
		DoubleSummaryStatistics stats = TransactionStore.getInstance().getStatistics();
		System.out.println(Long.toString(stats.getCount()));
		System.out.println(Double.toString(stats.getAverage()));
		return ok("ok");
	}

}