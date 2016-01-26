package in.spann.palindrome_index

object Solution {

  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val inputStrings = new Array[String](n)
    (0 to n - 1).foreach(inputStrings(_) = sc.next())

    inputStrings.foreach { x =>
      val chars = x.toCharArray
      println(findFaultyChar(chars))
    }
  }

  def findFaultyChar(chars: Array[Char]): Int = {
    val maxIndex = chars.length - 1

    (0 to maxIndex).foreach { i =>
      if (chars(i) != chars(maxIndex - i)) {
        val updatedChars = chars.patch(i, Nil, 1)
        if (isPalindrome(updatedChars.mkString)) {
          return i
        } else {
          return maxIndex - i
        }
      }
    }

    -1
  }

  def isPalindrome(str: String): Boolean = {
    str == str.reverse
  }
}
