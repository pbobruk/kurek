package bigu.kurek

class Word2Number {

    /***
    1=L,T
    2=N,Ń,Z,Ż,Ź,V
    3=M,W
    4=K,R,X
    5=S,Ś
    6=G,J
    7=F,Ł
    8=B
    9=P
    0=D,Q,C

    - Cz, Dz i Sz na początku liczą się jak Z!
    - Słowo może się zaczynać z literki D np. DeLFiN=0172 czyli 172
     */

    private val map = mapOf(
        "l" to "1", // 1=L,T
        "t" to "1",
        "n" to "2", // 2=N,Z,V
        "ń" to "2",
        "z" to "2",
        "ż" to "2",
        "ź" to "2",
        "v" to "2",
        "m" to "3", // 3=M,W
        "w" to "3",
        "k" to "4", // 4=K,R,X
        "r" to "4",
        "x" to "4",
        "s" to "5", // 5=S
        "ś" to "5",
        "g" to "6", // 6=G,J
        "j" to "6",
        "f" to "7", // 7=F
        "ł" to "7",
        "b" to "8", // 8=B
        "p" to "9", // 9=P
        "d" to "0", // 0=D,Q,Ch
        "q" to "0",
        "c" to "0",
        "ć" to "0"
    )

    fun word2number(word: String): Int {
        val wordTokens = tokenize(prepareWord(word))

        val result = StringBuilder()
        for (t in wordTokens) {
            val digit = map[t]
            if (digit != null)
                result.append(digit)
        }
        return result.toString().toInt()
    }

    private fun tokenize(word: String): List<String> {
        var result = listOf<String>()
        var i = 0
        while (i <= word.lastIndex) {
            result = result.plus(word[i].toString())
            i++
        }
        return result
    }

    private fun prepareWord(word: String): String {
        return word.lowercase()
            .replacePrefix("cz", "z")  // Cz, Dz i Sz na początku liczą się jak Z!
            .replacePrefix("dz", "z")
            .replacePrefix("sz", "z")
            .replace("cz", "c")
            .replace("sz", "s")
            .replace("dz", "d")
            .replace("rz", "r")
    }
}
