trait DrawingAPI{
    def drawCircle(x:Double, y: Double, radius: Double)
}

class DrawingAPI1 extends DrawingAPI{
    override def drawCircle(x: Double, y: Double, radius: Double)={
      println("DrawingAPI1:"+radius+","+x+","+y)

    }

}

class DrawingAPI2 extends DrawingAPI{
    override def drawCircle(x: Double, y: Double, radius: Double)={
      println("DrawingAPI2:"+radius+","+x+","+y)
    }
}

abstract class Shape(drawingAPI: DrawingAPI){
    def draw
    def resizeByPercentage(pct: Double)
}

class CircleShape(x: Double , y: Double, radius: Double, drawingAPI: DrawingAPI) extends Shape(drawingAPI) {
    var _x: Double =x
    var _y : Double = y
    var _radius: Double = radius

    override def draw = drawingAPI.drawCircle(_x, _y, _radius)
    override def resizeByPercentage(pct: Double) = _radius *=pct
}


object BridgePattern{
  def main(args: Array[String]){
     var shape = new CircleShape(1,2,3, new DrawingAPI1())
      shape.draw
      shape.resizeByPercentage(2.5)
      shape = new CircleShape(2,3,4, new DrawingAPI2())
      shape.draw
      shape.resizeByPercentage(1.7)
  }

}
