package in.spann.a_very_big_sum

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Long](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextLong();
    }

    println(arr.sum)
  }
}
