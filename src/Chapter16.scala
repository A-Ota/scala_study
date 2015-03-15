/**
 * Created by A-Ota on 2015/03/14.
 */

object Chapter16 {
  def run(): Unit = {
    val fruit = List("apples", "oranges", "pears")
    println(fruit)
    println(fruit.head)
    val field = List(
      List(true, false, true),
      List(true, true, true),
      List(true, false, false)
    )
    println(field)
    println(field.tail) // tailは先頭を取り除いたリストを返す
    println(field.last) // lastは末尾の要素
    println(field.init) // initは末尾を取り除いたリスト

    // パターンマッチでリストから変数に
    {
      val List(a, b, c) = fruit
      println(a)
      println(b)
      println(c)
    }

    // 数が不明なら残りをリストとして取り出せる
    {
      val a::rest = fruit
      println(a)
      println(rest)
    }

    // リストの連結は:::
    println(List("a", "b"):::List("c", "d", "e"))

    // リストの単層化はflatten
    println(field.flatten)

    // 2つのリストの各要素をペアにしたリストを作成するzip
    println(List("a", "b", "c") zip List(100, 200, 300))
    println(List("a", "b", "c").indices zip List("a", "b", "c"))

    // ペア(タプル)のリストからそれぞれの要素のリストを作成するunzip
    println(List(("hoge", 1), ("fuga", 2), ("piyo",3)).unzip)

    // toArrayでListを配列に、toListで配列をListに変換できる。
    val arr = fruit.toArray
    println(arr.toString)

    // map
    println(List(1, 10, 100).map(v => List(v, v +1)))
    // flatMap
    println(List(1, 10, 100).flatMap(v => List(v, v +1)))

    // リスト操作系
    {
      val list = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
      println(list.filter(_ < 5))
      println(list.find(_ < 5))
      println(list.partition(_ < 5))
      println(List(1, 2, 1, 0, -1 ,-2, -1 , 0, 1).takeWhile(_ >= 0))
      println(List(1, 2, 1, 0, -1 ,-2, -1 , 0, 1).dropWhile(_ >= 0))
      println(List(1, 2, 3, 4).forall(_ < 10))
      println(List(8, 9, 10, 11).forall(_ < 10))
      println(List(9, 10, 11, 12).exists(_ < 10))
      println(List(10, 11, 12, 13).exists(_ < 10))
    }

    // 左から折りたたみしつつ関数を適用(=foldLeft)
    println((1 /: List(3, 4, 5))(_ + _))
    val words = List("hoge", "fuga", "piyo")
    println((words.head /: words.tail)(_ + "," + _))

    // 右から折りたたむ(=foldRight)
    println((List(3, 4, 5) :\ 1)(_ + _))

    // その他リスト関連のメソッド
    println(List.range(1, 5))
    // ステップ指定もできる。
    println(List.range(1, 10, 3))
    println(List.range(10, 1, -3))

    println(List.fill(3)('a'))
    println(List.fill(2, 2)('b'))

    // zipped
    println((List(1, 2), List(3, 4)).zipped.map(_ + _))
    println((List(1, 2), List(3, 4), List(5, 6)).zipped.map(_ + _ + _))
  }
}
