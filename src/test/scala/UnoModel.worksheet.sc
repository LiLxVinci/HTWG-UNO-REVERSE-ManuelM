/**
 * Datenstrukturen von Scala austesten
 * fuer Karten / Spieler / Spielzustand
 */

// 1. Farben Definieren (Blue ergänzt)
enum Color:
  case Red, Green, Yellow, Blue, Black

// 2. Kartenwerte Definieren
enum Value:
  case Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine
  case Skip, Reverse, DrawTwo
  case Wild, WildDrawFour

// 3. Karte als Case Class modellieren mit korrigierter fitsOn-Logik
case class Card(color: Color, value: Value):
  def fitsOn(topCard: Card): Boolean = 
    // Passt wenn: gleiche Farbe, gleicher Wert, Handkarte ist schwarz ODER Tischkarte ist schwarz
    color == topCard.color || 
    value == topCard.value || 
    color == Color.Black || 
    topCard.color == Color.Black

  override def toString: String = s"$color $value"

// 4. Spieler mit Handkarten
case class Player(name: String, hand: List[Card]):
  def cardCount: Int = hand.length

// 5. Spielzustand / Feld (Typo 'plyers' -> 'players' gefixt)
case class GameState(
    players: Vector[Player],
    topCard: Card,
    isReversed: Boolean = false
)

// 6. Auswertung der Spielinformationen / Testaufrufe
def testGameDomain(): Unit =
  val card1 = Card(Color.Red, Value.Reverse)
  val card2 = Card(Color.Red, Value.Five)
  val card3 = Card(Color.Green, Value.Five)
  val card4 = Card(Color.Blue, Value.Skip)

  println(s"card2 fits on card1: ${card2.fitsOn(card1)}") // true (gleiche Farbe: Red)
  println(s"card3 fits on card1: ${card3.fitsOn(card1)}") // false (weder Farbe noch Wert)
  println(s"card4 fits on card1: ${card4.fitsOn(card1)}") // false (weder Farbe noch Wert)
  println(s"card3 fits on card2: ${card3.fitsOn(card2)}") // true (gleicher Wert: Five)

  // Spieler anlegen
  val player1 = Player("Manuel", List(card1, card2))
  println(s"Player 1 Card Count: ${player1.cardCount}") // 2

  // Spielzustand erzeugen
  val game = GameState(players = Vector(player1), topCard = card1)
  println(s"Current Top Card in Game: ${game.topCard}")

testGameDomain()

/**
  * ==== Vorlesungsunterlagen:
  * kein "var"
  *     arbeite mit unveraenderlichen werten (val) und 
  *     immutable Datenstrukturen wie List oder Vector
  * kein "null"
  * case class & enum
  *    fuer Datenstrukturen, die sich nicht veraendern sollen
  */
