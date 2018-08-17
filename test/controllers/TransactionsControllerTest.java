package controllers;

import org.junit.Test;
import java.util.Map;
import java.util.HashMap;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Http;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.ACCEPTED;
import static play.mvc.Http.Status.BAD_REQUEST;
import static play.test.Helpers.POST;
import static play.test.Helpers.route;

public class TransactionsControllerTest extends WithApplication {
	@Override
	protected Application provideApplication() {
			return new GuiceApplicationBuilder().build();
	}

	@Test
	public void testAddTransasction() {
			Map<String, String> body = new HashMap<String, String>();
			body.put("sales_amount", "10.00");

			Http.RequestBuilder request = new Http.RequestBuilder()
							.bodyForm(body)
							.method(POST)
							.uri("/sales");

			Result result = route(app, request);
			assertEquals(ACCEPTED, result.status());
	}

	@Test
	public void testAddTransasctionEmpty() {
			Map<String, String> body = new HashMap<String, String>();
			Http.RequestBuilder request = new Http.RequestBuilder()
							.bodyForm(body)
							.method(POST)
							.uri("/sales");

			Result result = route(app, request);
			assertEquals(BAD_REQUEST, result.status());
	}
}