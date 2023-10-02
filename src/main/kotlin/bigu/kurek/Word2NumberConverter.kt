package bigu.kurek

/***
 * 1=L,T
 * 2=N,Ń,Z,Ż,Ź,V
 * 3=M,W
 * 4=K,R,X
 * 5=S,Ś
 * 6=G,J
 * 7=F,Ł
 * 8=B
 * 9=P
 * 0=D,Q,C
 *
 * - Cz, Dz i Sz na początku liczą się jak Z!
 * - Słowo może się zaczynać z literki D np. DeLFiN=0172 czyli 172
 */
enum class Word2NumberConverter(
    val map: Map<Char, Char>,
    private val prepareFunctions: List<(String) -> String>,
    private val postPrettifyFunctions: List<(String) -> String> = listOf()
) {
    STANDARD(
        mapOf(
            'l' to '1', 't' to '1', // 1=L,T
            'n' to '2', 'ń' to '2', 'z' to '2', 'ż' to '2', 'ź' to '2', 'v' to '2', // 2=N,Z,V
            'm' to '3', 'w' to '3', // 3=M,W
            'k' to '4', 'r' to '4', 'x' to '4', // 4=K,R,X
            's' to '5', 'ś' to '5',// 5=S
            'g' to '6', 'j' to '6',// 6=G,J
            'f' to '7', 'ł' to '7',// 7=F
            'b' to '8', // 8=B
            'p' to '9', // 9=P
            'd' to '0', 'q' to '0', 'c' to '0', 'ć' to '0' // 0=D,Q,C
        ),
        listOf(
            { s -> s.lowercase() },
            { s -> s.replacePrefix("cz", "z") }, // Cz, Dz i Sz na początku liczą się jak Z!
            { s -> s.replacePrefix("dz", "z") },
            { s -> s.replacePrefix("sz", "z") },
            { s -> s.replace("cz", "c") },
            { s -> s.replace("sz", "s") },
            { s -> s.replace("dz", "d") },
            { s -> s.replace("rz", "r") }
        ),
        listOf(
            { s -> s.replacePrefix("CZ", "cZ") },
            { s -> s.replacePrefix("DZ", "dZ") },
            { s -> s.replacePrefix("SZ", "sZ") },
            { s -> s.replace("CZ", "Cz") },
            { s -> s.replace("SZ", "Sz") },
            { s -> s.replace("DZ", "Dz") },
            { s -> s.replace("RZ", "Rz") }
        )
    ),
    V6(
        mapOf(
            'l' to '1', 't' to '1', // 1=L,T
            'v' to '2', 'z' to '2', // 2=V,Z
            'm' to '3', 'w' to '3', // 3=M,W
            'r' to '4', 'h' to '4', // 4=R,H,RZ
            's' to '5', 'ś' to '5', // 5=S,Ś,SZ
            'g' to '6', 'j' to '6', 'ź' to '6', 'ż' to '6', // 6=G,J,Ż,Ź
            'f' to '7', 'k' to '7', 'ł' to '7', // 7=F,K,Ł
            'b' to '8', 'x' to '8', 'n' to '8', 'ń' to '8', // 8=B,X,N,Ń
            'p' to '9', 'd' to '9', // 9=P,D, DZ
            'c' to '0', 'ć' to '0', 'q' to '0' // 0=C,Ć,Q,CH,CZ
        ),
        listOf(
            { s -> s.lowercase() },
            { s -> s.replace("rz", "r") },
            { s -> s.replace("sz", "s") },
            { s -> s.replace("dz", "d") },
            { s -> s.replace("ch", "c") },
            { s -> s.replace("cz", "c") }
        )
    ),
    V7(
        mapOf(
            'l' to '1', 't' to '1', // 1=L,T
            'n' to '2', 'ń' to '2', 'v' to '2',// 2=N,Ń,V
            'm' to '3', 'w' to '3', // 3=M,W
            'r' to '4',             // 4=R,RZ
            's' to '5', 'ś' to '5', // 5=S,Ś,SZ
            'g' to '6', 'j' to '6', 'ź' to '6', 'ż' to '6', // 6=G,J,Ż,Ź
            'f' to '7', 'k' to '7', 'ł' to '7', // 7=F,K,Ł
            'b' to '8', 'h' to '8', 'n' to '8', 'ń' to '8', // 8=B,H,X,Z
            'p' to '9', 'd' to '9', // 9=P,D,DZ,DŻ,DŹ
            'c' to '0', 'ć' to '0', 'q' to '0' // 0=C,Ć,Q,CH,CZ
        ),
        listOf(
            { s -> s.lowercase() },
            { s -> s.replace("rz", "r") },
            { s -> s.replace("sz", "s") },
            { s -> s.replace("dz", "d") },
            { s -> s.replace("dż", "d") },
            { s -> s.replace("dź", "d") },
            { s -> s.replace("ch", "c") },
            { s -> s.replace("cz", "c") }
        )
    );

    fun word2number(word: String): Int {
        val result = StringBuilder()
        for (t in prepareWord(word)) {
            val digit = map[t]
            if (digit != null)
                result.append(digit)
        }
        return try {
            result.toString().toInt()
        } catch (e: NumberFormatException) {
            0
        }
    }

    fun wordPrettify(word: String): String {
        val result = StringBuilder()
        word.lowercase().forEach { c ->
            if (c in map.keys) {
                result.append(c.uppercase())
            } else {
                result.append(c)
            }
        }
        return postPrettifyFunctions
            .fold(result.toString()) { r, f -> f(r) }
    }

    private fun prepareWord(inputWord: String): String =
        prepareFunctions.fold(inputWord) { word, function -> function(word) }

}
