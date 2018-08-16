// @GENERATOR:play-routes-compiler
// @SOURCE:/home/roman/dev/play-java-seed/conf/routes
// @DATE:Tue Aug 14 11:41:32 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
