// main.scala

@main def runGame(): Unit =
  val players = List(
    List("Red 5", "Blue Skip"),
    List("Yellow 1", "Green 3", "Red Draw Two"),
    List("Blue 7", "Yellow Reverse"),
    List("Green 9", "Red 2", "Blue 4", "Yellow 6")
  )
  val playedCards = List("Red 8", "Blue 8")
  val topCard     = Some("Blue 8")

  println(UnoPlayingField.game_information(2, players, playedCards, topCard))
  println("\nVisible cards and hidden card backs:")
  println(UnoPlayingField.visualization(List("Blue 8"), hiddenCardCount = 3))
