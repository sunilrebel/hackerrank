package in.spann.solve_me_first

import scala.io.Source

object Solution {

  def main(args: Array[String]) {
    println(Source.stdin.getLines().take(2).map(_.toInt).sum)
  }

}
