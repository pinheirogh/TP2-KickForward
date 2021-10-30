import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap

object Demo {
  def main(args: Array[String]): Unit ={
    var path = "teste.txt"
    //print(lines.replaceAll("/^\\w+$/", ""))

    // teste para funcao sort e print_text:
    /*
    sort(ListMap(
      "Linha" -> 4, "teste" -> 1, "alguma" -> 3, "coisa" -> 5,
      "Linha1" -> 4, "teste1" -> 82, "alguma1" -> 346, "coisa1" -> 2,
      "Linha2" -> 435, "teste2" -> 21, "alguma2" -> 92, "coisa2" -> 23,
      "Linha3" -> 546, "teste3" -> 534, "alguma3" -> 215, "coisa3" -> 897,
      "Linha4" -> 6, "teste4" -> 12, "alguma4" -> 3246, "coisa4" -> 9,
      "Linha5" -> 121, "teste5" -> 2398, "alguma5" -> 45, "coisa5" -> 42,
      "Linha6" -> 34, "teste6" -> 537, "alguma6" -> 87, "coisa6" -> 8768,
      "Linha7" -> 12, "teste7" -> 328, "alguma7" -> 75, "coisa7" -> 87,
      "Linha8" -> 40, "teste8" -> 2314, "alguma8" -> 2, "coisa8" -> 77,
      "Linha9" -> 83, "teste9" -> 84, "alguma9" -> 897, "coisa9" -> 933,
      "Linha0" -> 93, "teste0" -> 92, "alguma0" -> 62, "coisa0" -> 87
    ), print_text)
    */

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
    val stopWordsList = Source.fromFile("stop_words.txt").getLines.mkString.split(",").map(_.trim).toList
    def isStopWord(word: String) = stopWordsList.contains(word.toLowerCase()) 
    var tempList = ListBuffer[String]()
    var wordList = ListBuffer[String]()

    for (phrase <- tt) {
      phrase.split(" ").foreach(tempList += _)
    }
    for (word <- phraseList) {
      if (!isStopWord(word)) {
        wordList += word
      }
    }
    print(wordList)
    frequencies(wordList, sort)
  }

  def frequencies(tt: ListBuffer[String], fn: (ListMap[String, Int], (ListMap[String, Int], Null => Unit) => Unit) => Unit): Unit = {
    var wf = new ListMap[String, Int]()
    // a implementar...
    fn(wf, print_text)
  }

  def sort(wf: ListMap[String, Int], fn: (ListMap[String, Int], Null => Unit) => Unit): Unit = {
    fn(ListMap(wf.toSeq.sortWith(_._2 > _._2):_*), no_op)
  }

  def print_text(wf: ListMap[String, Int], fn: Null => Unit): Unit = {
    wf.take(25).foreach {
      case (key, value) => println (key + " - " + value)
    }

    fn(null)
  }

  /*
  def frequencies(tt: ListBuffer[String], fn: Unit): Unit = {
    var wf = new ListMap[String, Int]()
    // a implementar...

    sort(wf, fn)
  }

  def sort(wf: ListMap[String, Int], fn: Unit): Unit = {
    print_text(ListMap(wf.toSeq.sortWith(_._2 > _._2):_*), fn)
  }

  def print_text(wf: ListMap[String, Int], fn: Unit): Unit = {
    wf.take(25).foreach {
      case (key, value) => println (key + " - " + value)
    }
  }
  */

}