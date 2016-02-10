trait Component{
    def state: String
    def name: String
}

case class AComponent(id: String) extends Component{
     def state= name +":"+id
     def name = "A"
}

trait ComponentDecoratorA extends Component{
    abstract override def name = "ByDecorated:"+super.name
}

trait ComponentDecoratorB extends Component{
     abstract override def name = "ByDecorated:"+super.name

}

object StaticDecoratorPattern extends App{
    val c = new AComponent("42") with ComponentDecoratorA with ComponentDecoratorB
    println(c.state)
}
