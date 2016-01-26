package in.spann.staircase

object Solution {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    (1 to n).foreach { line =>
      (1 to (n - line)).foreach(_ => print(" "))
      (1 to line).foreach(_ => print("#"))
      println()
    }
  }
}
