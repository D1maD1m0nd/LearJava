package kotlinTemp.filmApp


fun main(){
    listOf("ABBA","GOGO","FIRE", "WAPP", "ABBB").forEach{
        val isCorrect = isCorrectWord(it)
        println(isCorrect)
    }
}
fun isCorrectWord(word : String) : String{
    //заполняем список
    val list = ArrayList<Char>();
    word.forEach {
        list.add(it)
    }

    val set = list.distinct().filter {
        val countS = word.count { s ->
            it == s
        }
        return@filter countS <= 2
    }

    return if(set.size == 2) {
        "YES"
    } else {
        "NO"
    }
}
