package controllers;

import play.mvc.*;
import play.libs.Json;
import models.TransactionStore;
import models.StatisticSummary;

public class StatisticsController extends Controller {
	
	public Result get() {
		StatisticSummary summary = TransactionStore.getInstance().getStatistics();
		ObjectNode result = Json.newObject();
		System.out.println(summary.getAverage());
		System.out.println(summary.getAmount());
		return ok("ok");
	}

}