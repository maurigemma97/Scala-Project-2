def Square(l:List[Int]) : Int = {
  l.foldLeft(0) { (acc, x) => acc + x*x }
}
println( Square(List(3, 2, 6, 4)) )

