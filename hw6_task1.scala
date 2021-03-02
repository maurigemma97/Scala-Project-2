trait Shape {
var color = "red"
def area:Double
}
class Rectangle(color1:String) extends Shape {
    color = color1
    var width = 1.0
    var length = 1.0
    def Rectangle(c:String, w:Double, l:Double) {
        width = w
        color = c
        length = l
    }
    def Rectangle(w:Double, l:Double) {
        width = w
        length = l
    }
    override def area() :Double =  {
        var answer = width * length
        answer
    }
}

class Circle(color1:String) extends Shape {
    color = color1
    var radius = 2.0
    def Circle(c:String, r:Double) {
        color = c
        radius = r
    }
    def Circle(r:Double) {
        radius = r
    }

    override def area() :Double = 
    {
        var answer = 3.14 * radius * radius
        answer
    }
}

var list:List[Shape] = Nil
val f = new scala.util.Random
for(i <- 0 until 40) {
  var x:Int = f.nextInt(2)
  if(x==0) {
  val e = new Rectangle(f.nextString (4))
  list = list :+ e
  }
  else {
  val c = new Circle(f.nextString (4))
  list = list :+ c
  }
}
var totalArea = 0.0
var y = list.foreach{
  x => totalArea = totalArea + x.area
}
println(totalArea)

