import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap

object Demo {
  def main(args: Array[String]): Unit ={
    var lines = scala.io.Source.fromFile("teste.txt").mkString
    // sort(ListMap("Linha" -> 4, "teste" -> 1, "alguma" -> 3, "coisa" -> 2), print_text)
    normalize(lines, no_op(null))
  }

  def no_op(tt: Null): Unit = {
    val donothing = tt
  }

  def read_file(path_to_file: String, fn: (String) => String): (String)={
    val data = Source.fromFile(path_to_file).getLines.mkString
    normalize(data)
  }
  
  def filter_chars(str_data: String, fn: (String) => String): (String)={
      val pattern = str_data.replaceAll("\\W", "")
      scan(pattern)
  }

  def normalize(str_data: String, unit: Unit): Unit ={
    var lines = str_data.toLowerCase()
    scan_function(lines, no_op(null))
  }

  def scan_function(str_data: String, unit: Unit): Unit = {
    var wordlist = str_data.split('\n')
    var wordBufferList = ListBuffer[String]()
    for (word <- wordlist) wordBufferList += word
    remove_stop_words(wordBufferList, no_op(null))
  }

  def remove_stop_words(tt: ListBuffer[String], unit: Unit): Unit ={
    for (word <- tt) println(word)
    // frequencies(tt, no_op(null))
  }

  def frequencies(tt: ListBuffer[String], unit: (ListMap[String, Int], (ListMap[String, Int], Null => Unit) => Unit) => Unit): Unit = {
    var wf = new ListMap[String, Int]()
    // sort(wf, no_op(null))
  }

  def sort(wf: ListMap[String, Int], unit: (ListMap[String, Int], Null => Unit) => Unit): Unit = {
    val a = 0
    unit(ListMap(wf.toSeq.sortWith(_._2 > _._2):_*), no_op)
  }

  def print_text(wf: ListMap[String, Int], unit: Null => Unit): Unit = {
    wf.foreach {  // TODO: Only the first 25 items
      case (key, value) => println (key + " - " + value)         
    }

    unit(null)
  }

}
