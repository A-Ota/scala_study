/**
 * Created by A-Ota on 2015/01/06.
 */
object Chapter01 {
  def run(): Unit = {
    println("\n===== Chapter01 =====\n")

    // クラス定義がこれだけで良い。
    class MyClass(var index: Int, var name: String)
    val cls1 = new MyClass(0, "hoge")
    val cls2 = new MyClass(1, "fuga")
    println("cls1(%d, %s) cls2(%d, %s)".format(cls1.index, cls1.name, cls2.index, cls2.name))

    // 叙述関数が楽々記述できる。
    val name1 = "hogehoge"
    val name2 = "fuGafUga"
    println("%s has uppercase? %b".format(name1, name1.exists(_.isUpper)))
    println("%s has uppercase? %b".format(name2, name2.exists(_.isUpper)))
  }
}
