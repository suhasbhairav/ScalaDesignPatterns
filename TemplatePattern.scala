abstract class Game{
  def init(){
   play()
  }

  def play()

}


class Cricket extends Game{

   override def play(){
    println("Playing");

   }

}

class Football extends Game{

    override def play(){
      println("Football...")

    }


}

object TemplatePattern extends App{
   var game = new Cricket()
   game.init()
   
   var game1 = new Football()
   game1.init()

}
