fun main() {
    var word : String = "Katak"
    if (isPalindrom(word)) {
        println("Palindrom")
    } else {
        println("Bukan Palindrom")
    }
}

// fungsi untuk mengecek apakah input merupakan palindrom atau bukan
fun isPalindrom(word: String): Boolean {
    // membalik kata (bisa menggunakan word.reversed())
    var reversedWord : String = ""
    for (i in word.length - 1 downTo 0){
        reversedWord = reversedWord + word[i]
    }
    return word.lowercase() == reversedWord.lowercase()
}