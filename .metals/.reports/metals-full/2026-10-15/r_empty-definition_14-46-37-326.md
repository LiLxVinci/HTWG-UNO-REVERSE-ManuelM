error id: file://<WORKSPACE>/src/main/scala/Main.scala:
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -UnoPlayingField.
	 -scala/Predef.UnoPlayingField.
offset: 206
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
// main.scala

@main def runGame(): Unit =
  val hand  = List("Red 5", "Blue Skip", "Yellow 1")
  val table = List("Green 7")
  val deck  = List("Red 2", "Blue 4", "Yellow Reverse")

  val output = UnoPlayi@@ngField.generatePlayingField(
    playerNr = 1, 
    cardsOnHand = hand, 
    cardsOnTable = table,
    cardsOnDeck = deck,
    unoReverse = true
  )
  
  println(output)
```


#### Short summary: 

empty definition using pc, found symbol in pc: 