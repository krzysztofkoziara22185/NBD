import scala.Byte.MaxValue
import scala.None.fold
import scala.annotation.tailrec
import scala.math.abs
// Zadanie 1

val week_days: List[String] = List("Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piątek", "Sobota", "Niedziela")

def lab1_1a (l: List[String] ):String = {

  var weekdays=""
  for (i <- 0 until l.size){
    if (i==0){
      weekdays = l(i)
    }
    else{
      weekdays = weekdays+", "+l(i)
    }
  }
  weekdays
}

def lab1_1b (l: List[String] ):String = {

  var weekdays=""
  for (i <- 0 until l.size){
    if(l(i)(0)=='P')
    {
      if (i==0){
        weekdays = l(i)
      }
      else{
        weekdays = weekdays+", "+l(i)
      }
  }

  }
  weekdays
}

def lab1_1c (l: List[String] ):String = {

  var weekdays=""
  var i = 0
  while (i < l.size){
    if (i==0){
      weekdays = l(i)
    }
    else{
      weekdays = weekdays+", "+l(i)
    }
    i+=1
  }
  weekdays
}

//lab1_1a(week_days)
//lab1_1b(week_days)
//lab1_1c(week_days)

// Zadanie 2

def lab1_2a(l: List[String], i: Int, weekdays: String): String = {
  if (i==0) l(i)+lab1_2a(l,i+1,weekdays)
  else if (i<l.size && i>0) weekdays + ", "+l(i)+lab1_2a(l,i+1,weekdays)
  else  weekdays
  }

def lab1_2b(l: List[String], i: Int, weekdays: String): String = {
  if (i==l.size) l(i)+lab1_2b(l,i-1,weekdays)
  else if (i<l.size && i>=0) weekdays +l(i)+", "+lab1_2b(l,i-1,weekdays)
  else  weekdays
}

lab1_2a(week_days,0,"")
lab1_2b(week_days,week_days.size-1,"")

// Zadanie 3
def tail_weekdays(l: List[String]): String = {
  @tailrec
  def lab1_3(l: List[String], i: Int, weekdays: String): String = {
    if (i < 0) weekdays
    else lab1_3(l, i-1, l(i)+", " + weekdays)
  }
  lab1_3(l,l.size-1,"")
}


//tail_weekdays(week_days)

// Zadanie 4

def Lab1_4a(l: List[String]): String = {
  if (l.isEmpty) ""
  else if (l.length == 1) l.head
  else l.tail.foldLeft(l.head)(_ + ", " + _)
}

def Lab1_4b(l: List[String]): String = {
  if (l.isEmpty) ""
  else if (l.length == 1) l.head
  else l.foldRight("")( _+", " + _)
}

def Lab1_4c(l: List[String]): String = {
  if (l.nonEmpty) {
    if (l.length == 1 && l.head(0) == 'P') l.head
    else l.filter(_(0)=='P').tail.foldLeft(l.head)( _ + ", " + _)
  } else {
    ""
  }
}

//Lab1_4a(week_days)
//Lab1_4b(week_days)
//Lab1_4c(week_days)

// Zadanie 5

val prod = Map("x"->10,"y"->100,"z"->1000)
val prod_discount = prod.view.mapValues(_ * 0.9).toMap

// Zadanie 6

def Lab1_6(x: (Int, String, Char)) = {
  println(x._1)
  println(x._2)
  println(x._3)

}

// Lab1_6((5, "pięć", 'p'))

// Zadanie 7

val c = Map("x" -> 1,"y"-> 2)

def Lab1_7(x: Option[Int]) = x match {
  case Some(s) => s
  case None => "Not found"
}

println("Lab1_7(c.get( \"x\")) : " + Lab1_7(c.get( "x")) )
println("Lab1_7(c.get( \"y\")) : " + Lab1_7(c.get( "y")) )
println("Lab1_7(c.get( \"z\")) : " + Lab1_7(c.get( "z")) )


// Zadanie 8

def Lab1_8(list: List[Int], n: Int): List[Int] = list match {
  case Nil => Nil
  case h :: t =>
                 if (h == n) Lab1_8(t, n)
                 else h :: Lab1_8(t, n)
  }

//Lab1_8(List(4,5,0,0,1), 0)

// Zadanie 9

def Lab1_9(list: List[Int]): List[Int] = {
   list.map(x=>x+1)
}

val list: List[Int] = List(1,2,3,4,5,6,7,8,9)
Lab1_9(list)

// Zadanie 10

def Lab1_10(list: List[Double]): List[Double] = {
  list.filter(x => x>=(-5) && x<=12).map(x=>abs(x))

}

val list2: List[Double] = List(-4.5,-8,1,2,3,4,5,6,7,8,9)
Lab1_10(list2)