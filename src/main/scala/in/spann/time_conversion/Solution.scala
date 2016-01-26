package in.spann.time_conversion

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var time = sc.next();
    var hour = time.substring(0,2)
    var finalHour = hour
    var other = time.substring(2, time.length - 2)
    var amOrPm = time.substring(time.length - 2).toLowerCase

    if (amOrPm == "am" && hour == "12") {
      finalHour = "00"
    }
    if (amOrPm == "pm" && hour != "12") {
      finalHour = (hour.toInt + 12).toString
    }
    println(finalHour + other)
  }
}
