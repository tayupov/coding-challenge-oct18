// @GENERATOR:play-routes-compiler
// @SOURCE:/home/roman/dev/play-java-seed/conf/routes
// @DATE:Tue Aug 14 11:41:32 CEST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTransactionsController TransactionsController = new controllers.ReverseTransactionsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseStatisticsController StatisticsController = new controllers.ReverseStatisticsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTransactionsController TransactionsController = new controllers.javascript.ReverseTransactionsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseStatisticsController StatisticsController = new controllers.javascript.ReverseStatisticsController(RoutesPrefix.byNamePrefix());
  }

}
