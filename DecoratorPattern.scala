//https://gist.github.com/kencoba/1875983

trait Coffee{
    def cost : Double
    def ingredients : String

}


class SimpleCoffee extends Coffee{
   override def cost = 1
   override def ingredients = "Coffee"


}

abstract class CoffeeDecorator(decoratedCoffee: Coffee) extends Coffee{
    val sep = ", "
    override def cost = decoratedCoffee.cost
    override def ingredients = decoratedCoffee.ingredients

}

class Milk(decoratedCoffee: Coffee) extends CoffeeDecorator(decoratedCoffee){
    override def cost = super.cost + 0.5
    override def ingredients = super.ingredients + sep + "Milk"

}

class Whip(decoratedCoffee: Coffee) extends CoffeeDecorator(decoratedCoffee){
   override def cost = super.cost + 0.4
   override def ingredients = super.ingredients + sep + "Whip"
}

object DecoratorPattern{

    def main(args: Array[String]){
      var c: Coffee = new SimpleCoffee()
      println(c.cost+";"+c.ingredients)
      c = new Milk(c)
      println(c.cost+";"+c.ingredients)
      c = new Whip(c)
      println(c.cost+";"+c.ingredients)
     


   }


}
