/**
 * Created by A-Ota on 2015/01/06.
 */
object Chapter03 {
  def run(): Unit = {
    println("\n===== Chapter03 =====\n")

    // 実際は 0 to 2 は (0).to(2) の省略記法。メソッドのパラメータがひとつの場合はドットや括弧を省略できる。
    for (num <- 0 to 2)
      println(num)
    println()

    // 省略のテスト
    class MyClass{
      def func(value: Int): Unit = {
        println(value)
      }
    }
    val cls1 = new MyClass()
    cls1.func(100)
    cls1 func 200
    println()

    // 1 + 2 とかも 1.+(2) の省略形式に過ぎない。

    // obj(引数) の記述は obj.apply(引数) の呼び出しに変換される。リストの添字アクセスも実はapplyが呼び出されている。
    class HasApply{
      def apply(name: String, age: Int): Unit = {
        println("name = %s, age = %d".format(name, age))
      }
    }
    val ha = new HasApply
    ha("hoge", 30)
    ha.apply("hoge", 30)
  }
}
