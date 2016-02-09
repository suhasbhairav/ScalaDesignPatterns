import scala.collection.JavaConversions._


trait Command[V]{
 val parameters = new ArrayList[Any]()

 def validate(){}

 def execute() : V

 def addParameters(params: Any*){
  this.parameters ++ params
 }
}


trait SimpleCommand extends Command[Any]{
 def execute() : Any

}

trait CompoundCommand[V] extends Command[ArrayList[V]]{
 val commands = new ArrayList[Command[V]]()
 
 override def validate(){
  for(command <- commands){
   command.validate()
  }

 }

 override def execute() : ArrayList[V] = {

       var result = new ArrayList[V]()
       for(command <- commands)
        result.add(command.execute())
       return result

}

}

trait SimpleCompoundCommand extends CompoundCommand[Any]

case class MyValue(val str: String)

class SomeConcreteCommand extends Command[MyValue]{
      override def execute() : MyValue = {
       print("Hello ")
       return new MyValue("SomeConcreteCommand")

      }



    }

class AnotherConcreteCommand extends Command[MyValue]{
    override def execute(): MyValue = {
      println("Command!")
      return new MyValue("AnotherConcreteCommand")

   }



}


class ComplexConcreteCommand extends CompoundCommand[MyValue]{
    commands.add(new SomeConcreteCommand())
    commands.add(new AnotherConcreteCommand())
}

object CommandPattern extends App{
   var c1 = new SomeConcreteCommand()
   var c2 = new AnotherConcreteCommand()
   var c3 = new ComplexConcreteCommand()
   

   c1.execute()
   c2.execute()
   c3.execute()



}
