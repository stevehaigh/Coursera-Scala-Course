package funsets

object fsws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


  import FunSets._

	def boundedSet(m: Int, n: Int): Set =  x => x >= m && x <= n
                                                  //> boundedSet: (m: Int, n: Int)Int => Boolean
	
	val s = boundedSet(1,3)                   //> s  : Int => Boolean = <function1>
	printSet(s)                               //> {1,2,3}
	
	def arbitrarySet(i: Int*):
		Set = x => i.contains(x)          //> arbitrarySet: (i: Int*)Int => Boolean
	val t = arbitrarySet(2,4,8)               //> t  : Int => Boolean = <function1>
	printSet(t)                               //> {2,4,8}



  exists(t, x => x == 4)                          //> res0: Boolean = true
  exists(t, x => x == 3)                          //> res1: Boolean = false
  
  forall(s, x => x < 4)                           //> res2: Boolean = true
  
  val sm = map(s, x => x+x)                       //> sm  : Int => Boolean = <function1>
  printSet(sm)                                    //> {2,4,6}
  
  val tm = map(t, x=> x+1)                        //> tm  : Int => Boolean = <function1>
  printSet(tm)                                    //> {3,5,9}
	}