import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap

object Demo {
  def main(args: Array[String]): Unit ={
    var path = "teste.txt"
    //print(lines.replaceAll("/^\\w+$/", ""))
    // sort(ListMap("Linha" -> 4, "teste" -> 1, "alguma" -> 3, "coisa" -> 2), no_op(null))
    read_file(path, no_op(null))
  }

  def no_op(tt: Null): Unit = {
    val donothing = tt
  }

  def read_file(path_to_file: String, fn: Unit): (Unit)={
    val data = Source.fromFile(path_to_file).getLines.mkString
    filter_chars(data, fn)
  }

  def filter_chars(str_data: String, fn: Unit): (Unit)={
    val pattern = str_data.replaceAll("/^\\w+$/", "")
    normalize(pattern, fn)
  }

  def normalize(str_data: String, fn: Unit): (Unit)={
    var lines = str_data.toLowerCase()
    scan_function(lines, fn)
  }

  def scan_function(str_data: String, fn: Unit): Unit = {
    var wordlist = str_data.split(',')
    var wordBufferList = ListBuffer[String]()
    for (word <- wordlist) wordBufferList += word
    remove_stop_words(wordBufferList, fn)
  }

  def remove_stop_words(tt: ListBuffer[String], fn: Unit): Unit ={
    for (word <- tt) println(word)
    //frequencies(tt, fn)
  }

  /*
  def frequencies(tt: ListBuffer[String], fn: Unit): Unit = {
    var wf = new ListMap[String, Int]()
    sort(wf, fn)
  }

  def sort(wf: ListMap[String, Int], fn: Unit): Unit = {
    val a = 0
    print_text(ListMap(wf.toSeq.sortWith(_._2 > _._2):_*), fn)
  }

  def print_text(wf: ListMap[String, Int], unit: Unit): Unit = {
    wf.foreach {
      case (key, value) => println (key + " - " + value)
    }
  }
  */

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