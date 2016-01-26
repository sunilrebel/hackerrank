package in.spann.plus_minus

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    var plus: Float = 0
    var minus: Float = 0
    var zero: Float = 0
    for(arr_i <- 0 to n-1) {
      val num = sc.nextInt();
      arr(arr_i) = num
      num match {
        case x if x > 0 => plus += 1
        case y if y < 0 => minus += 1
        case z if z == 0 => zero += 1
      }
    }
    println(plus/n)
    println(minus/n)
    println(zero/n)
  }
}
