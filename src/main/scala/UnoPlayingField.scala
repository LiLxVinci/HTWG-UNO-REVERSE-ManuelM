/** Renders the visible cards and live status of a UNO game. */
object UnoPlayingField:

  /** Shows a card face when known, or a card back when the card is hidden. */
  def visualization(
      visibleCards: List[String],
      hiddenCardCount: Int = 0
  ): String =
    val cardFaces = visibleCards.map(card => s"[$card]")
    val cardBacks = List.fill(hiddenCardCount)("[UNO card back]")
    (cardFaces ++ cardBacks).mkString(" ")

  /** Shows whose turn it is, each player's hand, and the played/table cards. */
  def game_information(
      currentPlayer: Int,
      players: List[List[String]],
      playedCards: List[String],
      topCard: Option[String]
  ): String =
    val playerStatus = players.zipWithIndex.map { case (hand, index) =>
      val playerNumber = index + 1
      val cards        = hand.map(card => s"[$card]").mkString(" ")
      s"p$playerNumber: ${hand.size} cards [$cards]"
    }

    val played = playedCards.map(card => s"[$card]").mkString(" ")
    val top    = topCard.map(card => s"[$card]").getOrElse("none")

    (List(s"Current turn: p$currentPlayer") ++
      playerStatus ++
      List(s"Played cards: $played", s"Top card on table: $top")).mkString("\n")
