abstract class Product

abstract class PizzaBuilder{
    var dough: String
    var sauce: String
    var topping: String

    def withDough(dough: String): PizzaBuilder
    def withSauce(sauce: String): PizzaBuilder
    def withTopping(topping: String): PizzaBuilder
   
    def build:Product

}

class Pizza(builder: PizzaBuilder) extends Product{
    val dough: String = builder.dough
    val sauce: String = builder.sauce
    val topping: String = builder.topping

    override def toString: String={
      "Dough:"+dough+" Topping:"+topping+" Sauce:"+sauce

    }


}

class Cook extends PizzaBuilder{
    var dough: String = ""
    var sauce: String = ""
    var topping: String = ""

    override def withDough(dough: String) : PizzaBuilder={
      this.dough = dough
      this

   }

   override def withSauce(sauce: String) : PizzaBuilder={
    this.sauce= sauce
    this
   }

   override def withTopping(topping: String): PizzaBuilder={
     this.topping=topping 
     this   

   }

   override def build: Product= new Pizza(this)

}

object BuilderPattern{
    def main(args: Array[String]){
       val hawaiianCook = new Cook().withDough("cross").withTopping("ham+pineapple").withSauce("mild")
       val hawaiianPizza = hawaiianCook.build
        println(hawaiianPizza)


    }





}
