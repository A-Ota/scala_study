import scala.collection.mutable.ArrayBuffer

/**
 * Created by A-Ota on 2015/01/10.
 */
object Chapter08 {
  def run(): Unit = {
    println("\n===== Chapter08 =====\n")

    run1()
    run2()
    run3()
    run4()
    run5()
  }

  private def run1(): Unit = {
    // でっち上げクラス
    class View(x: Int, y:Int, w:Int, h:Int) {
      var enabled = true
      var text = ""
      def setEnabled(flag: Boolean) = {enabled = flag}
      def setText(text: String) = {this.text = text}
      override def toString: String =
        "%s x:%d y:%d w:%d h:%d %s".format(text, x, y, w, h, if (enabled) "enabled" else "disabled")
    }
    class Page() {
      val views = ArrayBuffer[View]()
    }
    object PageCreator1 {
      def create(): Page = {
        val page = new Page()
        page.views += createView(0, true, "新規登録")
        page.views += createView(50, true, "ログイン")
        page.views += createView(100, false, "ログアウト")
        page.views += createView(150, false, "退会")
        page
      }
      // 従来的な方法、privateメソッドに共通処理を記述。
      // このメソッドはcreateのためのヘルパーメソッドなのに、他のメソッドからも使えちゃうので混乱の元。
      private def createView(y: Int, enabled: Boolean, text: String): View = {
        val v = new View(10, y, 200, 40)
        v.setEnabled(enabled)
        v.setText(text)
        v
      }
    }
    object PageCreator2 {
      def create(): Page = {
        // メソッド内にメソッドを定義しちゃえば外から見えなくなる。
        def createView(y: Int, enabled: Boolean, text: String): View = {
          val v = new View(10, y, 200, 40)
          v.setEnabled(enabled)
          v.setText(text)
          v
        }
        val page = new Page()
        page.views += createView(0, true, "新規登録")
        page.views += createView(50, true, "ログイン")
        page.views += createView(100, false, "ログアウト")
        page.views += createView(150, false, "退会")
        page
      }
    }
    val p1 = PageCreator1.create()
    p1.views.foreach(println); println
    val p2 = PageCreator2.create()
    p2.views.foreach(println); println

    // 一人前の存在としての関数だってさ
    val increase = (x: Int) => x + 1
    println("increased10 = %d".format(increase(10)))

    // 関数リテラルの省略
    var numbers = Array(1, 2, 3, 4, 5)
    numbers = numbers.filter((x: Int) => x <= 3)
    numbers.foreach(n => print("%d,".format(n))); println
    // 型と括弧を省略
    numbers = numbers.filter(x => x <= 3)
    numbers.foreach(n => print("%d,".format(n))); println
    // プレースホルダ記法
    numbers = numbers.filter(_ <= 3)
    numbers.foreach(n => print("%d,".format(n))); println

    // 関数の部分適用
    def sum(a: Int, b: Int, c:Int) = a + b + c
    // 0個を部分適用
    val sum1 = sum _
    println("sum1 = " + sum1(1, 2, 3))
    // 1個を部分適用
    val sum2 = sum(2, 3, _: Int)
    println("sum2 = " + sum2(4))
    // 0個の部分適用は関数が明らかに必要な個所では_も省略できる
    def catchSum(func: (Int, Int, Int) => Int) = func(1, 2, 3)
    catchSum(sum)
  }
  private def run2(): Unit = {
    // クロージャ
    // 外側で定義した値にアクセスできる
    val x = 10
    val func1 = (num: Int) => num + x
    println("func1(100) = " + func1(100))
    // 値が変更されるとクロージャでつかんだものも変更される(同じ参照を保持している)
    var y = 20
    val func2 = (num: Int) => num + y
    println("func2(100) = " + func2(100))
    y = 30
    println("func2(100) = " + func2(100))
    // 引数は渡した時のが保持される
    val createFunc = (z: Int) => (num: Int) => num + z
    val func3 = createFunc(40)
    println("func3(100) = " + func3(100))
    val func4 = createFunc(50)
    println("func4(100) = " + func4(100))
  }
  private def run3(): Unit = {
    // 連続パラメーター
    def echo(args: String*) ={
      for (arg <- args) print(arg + ",")
      println
    }
    echo("one")
    echo("one", "two")
    // echo内部ではargsはArray扱いだからといってArrayは渡せない。
    // echo(Array("one", "two", "three"))
    // : _* で連続パラメータに変換する必要がある。
    echo(Array("one", "two", "three"): _*)
  }
  private def run4(): Unit = {
    def setNameAge(name: String, age: Int) = println("name:%s age:%d".format(name, age))
    setNameAge("hoge", 20)
    // 仮引数名指定で順番バラバラにできる。
    setNameAge(age = 30, name = "fuga")
    // デフォルト引数と組み合わせると強力じゃない？
    def setNameAgeCountry(name: String = "default", age: Int = 18, country: String = "japan"): Unit = {
      println("name:%s age:%d country:%s".format(name, age, country))
    }
    setNameAgeCountry(age = 40)
  }
  private def run5(): Unit = {
    // TODO:末尾再起について
  }
}
