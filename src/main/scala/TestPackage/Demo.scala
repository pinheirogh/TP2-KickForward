import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap

object Demo {
  def main(args: Array[String]): Unit ={
    var lines = scala.io.Source.fromFile("teste.txt").mkString
    print(lines.replaceAll("/^\\w+$/", ""))
    sort(ListMap("Linha" -> 4, "teste" -> 1, "alguma" -> 3, "coisa" -> 2), no_op(null))
    // normalize(lines, no_op(null))
  }

  def no_op(tt: Null): Unit = {
    val donothing = tt
  }

  def read_file(path_to_file: String, fn: (String) => String): (Unit)={
    val data = Source.fromFile(path_to_file).getLines.mkString
    normalize(data, fn)
  }

  def filter_chars(str_data: String, fn: (String) => String): (Unit)={
    val pattern = str_data.replaceAll("/^\\w+$/", "")
    scan_function(pattern, fn)
  }

  def normalize(str_data: String, fn: (String) => String): (Unit)={
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

  def frequencies(tt: ListBuffer[String], unit: Unit): Unit = {
    var wf = new ListMap[String, Int]()
    sort(wf, no_op(null))
  }

  def sort(wf: ListMap[String, Int], unit: Unit): Unit = {
    val a = 0
    print_text(ListMap(wf.toSeq.sortWith(_._2 > _._2):_*), no_op(null))
  }

  def print_text(wf: ListMap[String, Int], unit: Unit): Unit = {
    wf.foreach {
      case (key, value) => println (key + " - " + value)
    }
  }

}