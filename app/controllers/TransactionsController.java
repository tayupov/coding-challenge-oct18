package controllers;

import play.mvc.*;
import play.mvc.Http.*;

import java.util.Map;
import models.Transaction;
import models.TransactionStore;

public class TransactionsController extends Controller {
	
	public Result create() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();
		String[] paramsValue = params.get("sales_amount");

		if (paramsValue != null && !paramsValue[0].isEmpty()) {
			TransactionStore.getInstance().addTransaction(new Transaction(paramsValue[0]));
			return status(202);
		} else {
			return status(422, "No sales amount provided.");
		}

	}

}