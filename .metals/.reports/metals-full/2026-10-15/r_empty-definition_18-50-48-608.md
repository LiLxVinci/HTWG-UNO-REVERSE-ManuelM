error id: file://<WORKSPACE>/src/main/scala/UnoModel.wordsheet.sc:
file://<WORKSPACE>/src/main/scala/UnoModel.wordsheet.sc
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -TopCard.
	 -TopCard#
	 -TopCard().
	 -scala/Predef.TopCard.
	 -scala/Predef.TopCard#
	 -scala/Predef.TopCard().
offset: 1407
uri: file://<WORKSPACE>/src/main/scala/UnoModel.wordsheet.sc
text:
```scala
/**
  * Datenstrukturen von Scala austesten
  * fuer Karten / Spieler / Spielzustand
  * 
  */

// Farben Definieren
enum Color:
    case Red, Green, Yellow, Black

// Kartenwerte Definieren
enum Value:
    case Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine
    case Skip, Reverse, DrawTwo
    case Wild, WildDrawFour

// Eine Karte als Case Class modellieren
case class Card(color: Color, value: Value):
    def fitsOn(topCard: Card): Boolean = 
        color == topCard.color || value == topCard.value || color == Color.Black
    override def toString: String = s"$color $value"

// Spieler mit Handkarten
case class Player(name: String, hand: List[Card]):
    def cardCount: Int = hand.length

// Spielzustand / Feld
case class GameState(
    plyers: Vector[Player],
    topCard: Card,
    isReversed: Boolean = false
)

// Auswertung der Spielinformationen
val card1 = Card(Color.Red, Value.Reverse)
val card2 = Card(Color.Red, Value.Five)
val card3 = Card(Color.Green, Value.Five)
val card4 = Card(Color.Blue, Value.Skip)

// Testen der logic im Worksheet
card2.fitsOn(card1) // true, da gleiche Farbe 
card3.fitsOn(card1) // false, da weder gleiche Farbe noch gleiche Zahl
card4.fitsOn(card1) // false, da weder gleiche Farbe noch gleiche Zahl

//Spieler anlegen
val player1 = Player("Manuel", List(card1, card2))
player1.cardCount // eval -> 2

val game = GameState(Vector(player1), TopC@@ard = card1)
```


#### Short summary: 

empty definition using pc, found symbol in pc: 