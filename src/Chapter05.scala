/**
 * Created by A-Ota on 2015/01/07.
 */
object Chapter05 {
  def run(): Unit = {
    println("\n===== Chapter05 =====\n")

    // リストが==で比較できる。
    println("List(1, 2, 3) == List(1 ,2, 3) = %b".format(List(1, 2, 3) == List(1 ,2, 3)))
    println("List(1, 2, 3) == List(2 ,3, 4) = %b".format(List(1, 2, 3) == List(2, 3, 4)))
    println("List(1, 2, 3) == List(1 ,2) = %b".format(List(1, 2, 3) == List(1 ,2)))

    // 基本形にもさまざまな便利メソッドが生えてる。
    println("0 max 5 = %d".format(0 max 5))
    println("-100.abs() = %d".format(-100.abs))
    1 to 3 foreach(println)

    // 0-100の範囲に収める
    println("0 max 101 min 100 = %d".format(0 max 101 min 100))
    println("0 max -1 min 100 = %d".format(0 max -1 min 100))
  }
}
