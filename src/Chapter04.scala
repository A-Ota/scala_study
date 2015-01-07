/**
 * Created by A-Ota on 2015/01/07.
 */
object Chapter04 {
  def run(): Unit = {
    println("\n===== Chapter04 =====\n")

    // 基本的に行末のセミコロンは省略できるが、こんな感じで関数呼び出しの後にブロックを切りたい場合、
    // セミコロンがないと名前渡しパラメータの中括弧と認識されてコンパイルエラーになる。
    println("hoge");
    {
      val b = 10
    }
  }
}
