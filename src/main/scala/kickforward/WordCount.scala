import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap
import scala.collection.mutable.HashMap

object WordCount {
  def main(args: Array[String]): Unit ={
    var path = "teste1.txt" //The tests are "teste1.txt", "teste2.txt and "teste3.txt"

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
    val pattern = str_data.replaceAll("[^A-Za-z0-9 ]", "")
    normalize(pattern, fn)
  }

  def normalize(str_data: String, fn: Unit): (Unit)={
    var lines = str_data.toLowerCase()
    scan_function(lines, fn)
  }

  def scan_function(str_data: String, fn: Unit): Unit = {
    var wordlist = str_data.split(' ')
    var wordBufferList = ListBuffer[String]()
    for (word <- wordlist) wordBufferList += word
    remove_stop_words(wordBufferList, fn)
  }

  def remove_stop_words(tt: ListBuffer[String], fn: Unit): Unit ={
    val stopWordsList = Source.fromFile("stop_words.txt").getLines.mkString.split(",").map(_.trim).toList
    def isStopWord(word: String) = stopWordsList.contains(word.toLowerCase())
    var tempList = ListBuffer[String]()
    var wordList = ListBuffer[String]()

    for (phrase <- tt) {
      phrase.split(" ").foreach(tempList += _)
    }
    for (word <- tempList) {
      if (!isStopWord(word)) {
        wordList += word
      }
    }
    frequencies(wordList, sort)
  }

  def frequencies(tt: ListBuffer[String], fn: (HashMap[String, Int], (ListMap[String, Int], Null => Unit) => Unit) => Unit): Unit = {
    val table: HashMap[String, Int] = new HashMap[String, Int]()

    def mapFrequency(word: String) = {
      if (table.contains(word)) {
        val freq = table(word) + 1
        table += (word -> freq)
      } else {
        table += (word -> 1)
      }
    }
    tt.foreach{(mapFrequency)}

    fn(table, print_text)
  }

  def sort(wf: HashMap[String, Int], fn: (ListMap[String, Int], Null => Unit) => Unit): Unit = {
    fn(ListMap(wf.toSeq.sortWith(_._2 > _._2):_*), no_op)
  }

  def print_text(wf: ListMap[String, Int], fn: Null => Unit): Unit = {
    wf.take(25).foreach {
      case (key, value) => println (key + " - " + value)
    }

    fn(null)
  }

}
