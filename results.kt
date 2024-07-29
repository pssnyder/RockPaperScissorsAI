var winCount = 0
var lossCount = 0

wonButton.setOnClickListener {
    winCount++
    // Update AI with the result
}

lostButton.setOnClickListener {
    lossCount++
    // Update AI with the result
}

endButton.setOnClickListener {
    // Display final results
    val resultMessage = "Wins: $winCount, Losses: $lossCount"
    Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show()
}