/**
 * Created by A-Ota on 2015/01/08.
 */
object Chapter07 {
  def run(): Unit = {
    println("\n===== Chapter07 =====\n")

    // ifは結果を返す式なので、三項演算子っぽく使える。
    val flag = true
    val number = if (flag) 1 else 0
    println("number = %d".format(number))

    // 代入の結果はUnitになる。Unitは()に等しい。
    var x: Int = 0
    val result = (x = 100)
    println("result = %s".format(result))
    println("result == () = %b ".format(result == ()))

    // for式の基本。
    for (value <- 1 to 3)
      print(value + ",")
    println()

    // forの右側の正体はRange型の値
    val range: Range = 1 to 3
    for (value <- range)
      print(value + ",")
    println()

    // なので配列も指定出来る。
    val arr = Array(1,3,7)
    for (value <- arr)
      print(value + ",")
    println()

    // untilで未満までを楽に指定出来る。toもuntilもfor式の機能ではなくRange型を返すInt型のメソッド。
    for (value <- 1 until 3)
      print(value + ",")
    println()

    // if式でフィルタリングできる。3の倍数のみ抽出。
    for (value <- 1 to 10 if value % 3 == 0)
      print(value + ",")
    println()

    // yield(産出する)で左辺(を元に加工したもの)をリストとして取り出せる。
    val arr2 = for (value <- 1 to 3) yield value + 10
    arr2.foreach(n => print(n.toString + ","))
    println()

    // for(...){...} があったとして、yieldを入れる位置は for(...)yield{...} ここ！
    val arr3 = for (value <- 1 to 3) yield {
      println("value = %d".format(value))
      value + 20
    }
    arr3.foreach(n => print(n.toString + ","))
    println()

    // TODO:続きやる。
  }
}
