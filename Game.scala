object Game {
  def main(args: Array[String]): Unit = {
    var hasQuit = false
    var hasQuit2 = false
    var m = -1
    var b = 0
    val g = "Welcome to the simpilest game of chance known to man."
    val gc = "I will flip a coin and you try to guess if the coin will land on heads or tails."
    val gc2 = "Call it in the air."
    val c = "Let's make this a little more interesting."
    val cc = "How about we put some money down on this."
    val i = "insufficate funds"
    val t = "You currently have $"
    val j = "What? You don't want to play? Oh well, your loss."
    val qq = "I'm sorry but you've seem to have run out of money."
    val gg = "Good idea, quit while you still have some money left. Here are your total winnings. $"
    val nt = "Hopefully you get to play next time."
    val ty = "Thanks for playing, I hope you had fun."
    println(g)
    println(gc)
    println(gc2)
    val a = headsOrTails()
    a match {
      case 2 => hasQuit = true; hasQuit2 = true
      case e => isMatch(a)
    }
    while (!hasQuit) {
      println(c)
      println(cc)
      m = getMoney()
      m match {
        case 0 => hasQuit = true; hasQuit2 = true
        case e => hasQuit = true
      }
    }
    while (!hasQuit2) {
      var check = false
      while (!check) {
      b = isBet()
      b match {
        case -1 => hasQuit2 = true; check = true 
        case e => (b <= m) match {
        case true => check = true
        case false => println("insufficate funds")
        }
      }
      }
      hasQuit2 match { 
        case false =>
          val a = headsOrTails()
          a match {
            case 2 => hasQuit2 = true
            case e =>
              val mm = m
              val is = isMatch(a); is match {
                case true => m = mm + b
                case false => m = mm - b
              }
          }
        case true =>
      }
      m match {
        case 0 => hasQuit2 = true
        case e => println(t + m)
      }
    }
    m match {
      case -1 => println(j)
      case 0 => println(qq)
      case e => println(gg + m)
    }
    m match {
      case -1 => println(nt)
      case e => println(ty)
    }
  }
  def toInt(s: String): Int = {
    var answer = 0
    try {
      s.toInt
    } catch {
      case e: Exception => answer = -1
    }
    return answer
  }
  def isBet(): Int = {
    var invalid = true
    var answer = 0
    while (invalid) {
      println("How much money would you like to bet on this next coin flip?")
      val z = readLine
      z match {
        case "q" => answer = -1; invalid = false
        case "Q" => answer = -1; invalid = false
        case s => toInt(z) match {
          case -1 => println("That's not a valid currency, please enter a number. (ie. 100)")
          case 0 => answer = z.toInt; invalid = false
        }
      }
    }
    return answer
  }
  def getMoney(): Int = {
    var invalid = true
    var answer = 0
    while (invalid) {
      println("How much money do you have to gamble with?")
      val z = readLine
      z match {
        case "q" => invalid = false
        case "Q" => invalid = false
        case s => toInt(z) match {
          case 0 => answer = z.toInt; invalid = false
          case -1 => println("That's not a valid currency, please enter a number. (ie. 1000)")
        }
      }
    }
    return answer
  }
  def headsOrTails(): Int = {
    var invalid = true
    var answer = -1
    while (invalid) {
      println("press 'h' for heads or press 't' for tails")
      val input = readLine()
      input match {
        case "h" => answer = 1; invalid = false
        case "t" => answer = 0; invalid = false
        case "q" => answer = 2; invalid = false
        case "H" => answer = 1; invalid = false
        case "T" => answer = 0; invalid = false
        case "Q" => answer = 2; invalid = false
        case a => println("Try again.")
      }
    }
    return answer
  }
  def isMatch(a: Int): Any = {
    var answer = true
    a match {
      case 1 => scala.util.Random.nextInt(2) match {
        case 1 => println("It's heads. Congradulations, you win.")
        case 0 => println("It's tails. Sorry, better luck next time."); answer = false
      }
      case 0 => scala.util.Random.nextInt(2) match {
        case 1 => println("It's heads. Sorry, better luck next time."); answer = false
        case 0 => println("It's tails. Congradulations, you win.")
      }
    }
    return answer
  }
}
