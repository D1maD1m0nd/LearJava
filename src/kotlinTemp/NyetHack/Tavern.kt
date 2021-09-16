package kotlinTemp.NyetHack
const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10


fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun performPurchase(price : Double) {
    displayBalance()
    println("Purchasing item for $price")
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun placeOrder(menu : String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    val menuData = menu.split(',')

    val (type, name, price) = menu.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDoubleOrNull() ?: 0.0)
    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)

    println(toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE!"))
}

private fun toDragonSpeak(phrase : String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a","A" -> "4"
            "e","E" -> "3"
            "i","I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
}