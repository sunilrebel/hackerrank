package in.spann.morgan_and_a_string

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val input = new Array[String](n * 2)
    (0 to n * 2 - 1).foreach(input(_) = sc.next())

    for (i <- 0 to input.length - 1) {
      if (i % 2 == 0) {
        println(generateString(input(i), input(i + 1)))
      }
    }
  }

  def generateString(first: String, second: String): String = {
    val totalLength = first.length + second.length
    var firstHeadIndex = 0
    var secondHeadIndex = 0
    (0 to totalLength - 1).map { i =>
      val a = getCharacter(first, firstHeadIndex)
      val b = getCharacter(second, secondHeadIndex)

      val char = getLexicographicallyMinChar(a, b)
      if (a.getOrElse("") == char && b.getOrElse("") == char) {
        val nextA = getCharacter(first, firstHeadIndex + 1)
        val nextB = getCharacter(second, secondHeadIndex + 1)
        val nextChar = getLexicographicallyMinChar(a, b)
        if (nextChar == nextA.getOrElse("")) {
          firstHeadIndex += 1
        } else {
          secondHeadIndex += 1
        }
      } else if (b.getOrElse("") == char) {
        secondHeadIndex += 1
      } else {
        firstHeadIndex += 1
      }
      char
    }.mkString
  }

  def getCharacter(str: String, index: Int): Option[Char] = {
    try {
      val char = str(index)
      Some(char)
    } catch {
      case e: Exception => None
    }
  }

  def getLexicographicallyMinChar(aOpt: Option[Char], bOpt: Option[Char]): Char = {
    (aOpt, bOpt) match {
      case (Some(a), Some(b)) => if (a < b) a else b
      case (Some(a), _) => a
      case (_, Some(b)) => b
    }
  }

}
