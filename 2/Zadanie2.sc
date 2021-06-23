import java.awt.datatransfer.MimeTypeParseException

val week_days: List[String] = List("Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piątek", "Sobota", "Niedziela")

// Zadanie 1
def Lab2_1(day: String) = day match {
  case "Poniedziałek"| "Wtorek"|"Sroda"|"Czwartek"|"Piątek" => "Praca"
  case "Sobota"|"Niedziela" => "Weekend"
  case x => "Nie ma takiego dnia"
}

Lab2_1("Sroda")
Lab2_1("Sobota")
Lab2_1("Marzec")

// Zadanie 2

class KontoBankowe(private var _stanKonta:Float){

  def this(){
    this(0)
  }

  def stanKonta:Float = _stanKonta

  def wplata(kwota:Float): Unit ={
      this._stanKonta += kwota
  }

  def wyplata(kwota:Float): Unit ={
      this._stanKonta -= kwota
  }
}

val p = new KontoBankowe(500)
p.stanKonta
p.wplata(500)
p.stanKonta
p.wyplata(100)
p.stanKonta

// Zadanie 3

class Osoba(val imie:String, val nazwisko:String)

val Kajtek = new Osoba("Kajetan", "Kowalski")
val Pepe = new Osoba("Jose", "Martinez")
val Rafal = new Osoba("Rafal", "Nowak")
val Andrzej = new Osoba("Andrzej", "Czajkowski")


def Witaj(osoba:Osoba) = osoba match {
  case Pepe => "Cześć Pepe"
  case Rafal => "Dzień dobry, Rafał"
  case Kajtek => "Witaj Kajtek!"
  case _ => "A pan to kto?"
}

Witaj(Kajtek)
Witaj(Rafal)
Witaj(Pepe)
Witaj(Andrzej)

// Zadanie 4

val f = (x: Int) => x*x
val x = 2

def Lab2_4(x: Int, f:Int=>Int): Int ={
  f(f(f(x)))
}

Lab2_4(x,f)

// Zadanie 5

abstract class Osoba(val imie:String, val nazwisko:String) {
  def podatek:Double
}

trait Pracownik extends Osoba {
  var pensja =0.0
 override def podatek = pensja*0.2
}

trait Student extends Osoba{
  override def podatek = 0
}

trait Nauczyciel extends Pracownik{
  override def podatek = pensja*0.1
}

val pracownik1 = new Osoba("a","b") with Pracownik
pracownik1.pensja = 1000
pracownik1.podatek

val nauczyciel1 = new Osoba("c","d") with Nauczyciel
nauczyciel1.pensja = 1000
nauczyciel1.podatek

val student1 = new Osoba("e","f") with Student
student1.podatek

val student_pracownik = new Osoba("g","h") with Student with Pracownik
student_pracownik.pensja = 1000
student_pracownik.podatek

val pracownik_student = new Osoba("i","j") with Pracownik with Student
pracownik_student.pensja = 1000
pracownik_student.podatek