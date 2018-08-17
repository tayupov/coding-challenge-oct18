package controllers;

import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.TransactionStore;
import models.StatisticSummary;

public class StatisticsController extends Controller {
	
	public Result get() {
		StatisticSummary summary = TransactionStore.getInstance().getStatistics();
		ObjectNode result = Json.newObject();
		result.put("total_sales_amount:", summary.getAmount());
    result.put("average_amount_per_order:", summary.getAverage());
		return ok(result);
	}

}