/**
 * Created by A-Ota on 2015/01/08.
 */
object Chapter06 {
  def run(): Unit = {
    println("\n===== Chapter06 =====\n")

    // 分数テスト
    println(new Rational(2, 4))
    println(new Rational(1, 2) + new Rational(1, 3))
    println(new Rational(1, 2) + 2)
    // IntにはRationalを引数に取る+メソッドは無いが、暗黙の型変換でInt->Rationalに変換してしまえばいける。
    implicit def intToRational(x :Int) = new Rational(x)
    println(2 + new Rational(1, 2))
  }

  // 分数を表すクラス
  class Rational(inBunsi: Int, inBunbo: Int){
    // 分母は0ではならない(事前条件チェック)
    require(inBunbo != 0)
    // 正規化
    val divisor = gcd(inBunsi, inBunbo)
    val bunbo = inBunbo / divisor
    val bunsi = inBunsi / divisor
    override def toString = bunsi + "/" + bunbo
    // 整数のみ指定出来る補助コンストラクタ
    def this(num: Int) {
      // 補助コンストラクタの先頭で必ず他のコンストラクタを呼び出さなければならない。
      this(num, 1)
    }
    // 分母同士の加算
    def +(that: Rational): Rational =
      new Rational((that.bunsi * this.bunbo) + (this.bunsi * that.bunbo), that.bunbo * this.bunbo)
    // 整数との加算
    def +(that: Int): Rational =
      new Rational(that) + this

    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }
}
