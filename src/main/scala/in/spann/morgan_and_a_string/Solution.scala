package in.spann.morgan_and_a_string

import scala.annotation.tailrec

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val input = new Array[String](n * 2)
    (0 to n * 2 - 1).foreach(input(_) = sc.next())

    for (i <- 0 to input.length - 1) {
      if (i % 2 == 0) {
        println(LexiFinder.generateString(input(i), input(i + 1)))
      }
    }
  }

}

class LexiFinder(first: String, second: String) {

  var firstHeadIndex = 0
  var secondHeadIndex = 0

  def generateString: String = {
    val totalLength = first.length + second.length
    
    (0 to totalLength - 1).map { i =>
      val a = getCharacter(first, firstHeadIndex)
      val b = getCharacter(second, secondHeadIndex)
      val char = getLexicographicallyMinChar(a, b)

      val (firstHeadIndexAnalyzed, secondHeadIndexAnalyzed) = if (first == second) (first.length, second.length) else getAnalyzedIndexes(0, 1000)

      val stackName = getWhichStackShouldBePoppedOut(a, b, char, firstHeadIndexAnalyzed, secondHeadIndexAnalyzed)

      stackName match {
        case LexiFinder.firstString => firstHeadIndex += 1
        case LexiFinder.secondString => secondHeadIndex += 1
      }

      char.get
    }.mkString
  }

  @tailrec
  private def getAnalyzedIndexes(beginIndex: Int, charactersToConsider: Int): (Int, Int) = {
    val endIndex = beginIndex + charactersToConsider

    val strippedFirst = first.substring(beginIndex, Math.min(endIndex, first.length))
    val strippedSecond = second.substring(beginIndex, Math.min(endIndex, second.length))

    if (strippedFirst == strippedSecond) {
      getAnalyzedIndexes(endIndex, charactersToConsider)
    } else {
      (beginIndex, beginIndex)
    }
  }

  @tailrec
  private def getWhichStackShouldBePoppedOut(a: Option[Char], b: Option[Char], char: Option[Char], firstHeadIndex: Int, secondHeadIndex: Int): String = {
    char match {
      case Some(x) if a.getOrElse("") == x && b.getOrElse("") == x =>
        val nextA = getCharacter(first, firstHeadIndex + 1)
        val nextB = getCharacter(second, secondHeadIndex + 1)
        val nextChar = getLexicographicallyMinChar(nextA, nextB)
        
        getWhichStackShouldBePoppedOut(nextA, nextB, nextChar, firstHeadIndex + 1, secondHeadIndex + 1)
      case Some(y) if a.getOrElse("") == y => LexiFinder.firstString
      case Some(z) if b.getOrElse("") == z => LexiFinder.secondString
      case _ => LexiFinder.firstString
    }
  }

  def getCharacter(str: String, index: Int): Option[Char] = {
    try {
      val char = str(index)
      Some(char)
    } catch {
      case e: Exception => None
    }
  }

  def getLexicographicallyMinChar(aOpt: Option[Char], bOpt: Option[Char]): Option[Char] = {
    (aOpt, bOpt) match {
      case (Some(a), Some(b)) => if (a < b) Some(a) else Some(b)
      case (Some(a), _) => Some(a)
      case (_, Some(b)) => Some(b)
      case (_, _) => None
    }
  }
}

object LexiFinder {
  
  val firstString = "first"
  val secondString = "second"
  
  def generateString(first: String, second: String) = {
    val obj = new LexiFinder(first, second)
    obj.generateString
  }
}
//SCOOSCOOTERTY
