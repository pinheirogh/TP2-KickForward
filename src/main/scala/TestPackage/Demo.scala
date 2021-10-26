import scala.io.Source, scala.collection.mutable.ListBuffer

object Demo {
  def main(args: Array[String]): Unit ={
    var lines = scala.io.Source.fromFile("teste.txt").mkString
    normalize(lines, no_op(null))
  }

  def no_op(tt: Null): Unit = {
    val donothing = tt
  }

  def read_file(path_to_file: String, fn: Unit): Unit ={
    val data = Source.fromFile(path_to_file).getLines.mkString
    filter_chars(data, no_op(null))
  }

  def filter_chars(str_data: String, fn: Unit): Unit ={
    val pattern = str_data.replaceAll("\\W", "")
    normalize(pattern, no_op(null))
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
  }

}
