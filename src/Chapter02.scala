/**
 * Created by A-Ota on 2015/01/06.
 */
object Chapter02 {
  def run(): Unit = {
    println("\n===== Chapter02 =====\n")

    val args = Array("hoge", "fuga", "piyo")

    // foreach確認。
    args.foreach(arg => println(arg))
    println()

    // 引数ひとつで、引数をひとつとる文の場合、省略出来る。
    args.foreach(println)
    println()

    // for確認(argは実際はval argとなっている。なのでargにはfor内で代入出来ない。)
    for (arg <- args)
      println(arg)
    println()

  }
}
