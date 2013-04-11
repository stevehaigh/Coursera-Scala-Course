package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    //if (c > r) 0 // fallen off the end
    if (c == r) 1 // end of the row
    else if (c == 0) 1 // first column is always 1
    else if (r == 1) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1) // sum the "2 items above"
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    /**
     * Count up number of open brackets, and decrement every time a closing bracket is found.
     * If the count goes negative it means too many closing brackets found before opening ones.
     */
    def checkNumOpened(chars: List[Char], numOpen: Int) : Boolean = {
      if (chars.isEmpty) numOpen == 0 // OK so long as our open count is zero
      else if (chars.head == '(') checkNumOpened (chars.tail, numOpen + 1)
      else if (chars.head == ')') (numOpen > 0) && checkNumOpened(chars.tail, numOpen - 1) // check we don't have ')' before a '('
      else checkNumOpened(chars.tail, numOpen)
    }
    
    checkNumOpened(chars, 0) // kick of the recursive function with a zero count.
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0 // no way to make change
    else if (money == 0) 1 // one way to do this, and it is the correct base case in recursion too.
    else if (money < 0) 0 // base case if coin too big for amount left
    else { countChange(money, coins.tail) +  // add ways of making change without current coin
      countChange(money - coins.head, coins) // and ways of making change with current coin and reduced total.
      }
  }
}
