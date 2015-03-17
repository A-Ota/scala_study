/**
 * Created by A-Ota on 2015/03/17.
 */
object Chapter17 {
  def run(): Unit = {
    // SetやMap
    println(Set(1,2,3,2,1))
    val map = Map("hoge" -> 1, "huga" -> 3, "piyo" -> 5)
    println(map)
    println(map("huga"))

    // タプル
    println(("hoge", "fuga"))
    println(("hoge", "fuga", "piyo")._3)
    val (a, b) = (10, 100)
    println("a=%d b=%d".format(a, b))
  }
}
