trait Strategy{

  def run(){

   algorithm()

  }
  def algorithm()

}


class DefaultStrategy extends Strategy{

  def algorithm(){

    println("Default Strategy...")
   }


}


class Strategy1 extends Strategy{
  def algorithm(){

    println("Strategy1")

  }



}


class Strategy2 extends Strategy{

  def algorithm(){

    println("Strategy2")
  }


}

class SimpleApplication(var strategy: Strategy){

  def simplyCall(){
   strategy.run()
  }


}

object StrategyPattern extends App{

   var arg = "a"
   var strategy: Strategy = _
  arg match{
    case "a" => strategy = new Strategy1()
    case "b" => strategy = new Strategy2()
    case _ => strategy = new DefaultStrategy()
   }

  var simpleApp = new SimpleApplication(strategy)
   simpleApp.simplyCall()
  simpleApp.strategy = new Strategy2()
  simpleApp.simplyCall()

}
