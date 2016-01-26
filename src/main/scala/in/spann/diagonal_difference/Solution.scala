package in.spann.diagonal_difference

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a = Array.ofDim[Int](n,n);
    var sum1 = 0
    var sum2 = 0
    for(a_i <- 0 to n-1) {
      for(a_j <- 0 to n-1){
        val element = sc.nextInt();
        a(a_i)(a_j) = element
        if (a_i == a_j) {
          sum1 += element
        }
        if ((a_i + a_j) == (n-1)) {
          sum2 += element
        }
      }
    }

    val difference = Math.abs(sum1 - sum2)
    println(difference)
  }
}
