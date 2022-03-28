package bigu.kurek

import java.io.File

class NumConversionGenerator {
    val converter = Word2NumberConverter()

    companion object {
        val NUMS_TO_CONVERT_RANGE = 1..4000
    }

    fun generateConversion(dictionary_filename: String, destFileName: String) {
        val dictionaryWords = readResourceFileAsLines(dictionary_filename)
        val results = mutableMapOf<Int, MutableList<String>>()
        for (word in dictionaryWords) {
            val number = converter.word2number(word)
            if (number in NUMS_TO_CONVERT_RANGE) {
                val prettyWord = converter.wordPrettify(word)
                results.getOrPut(number) { mutableListOf() }.add("$word $prettyWord")
            }
        }

        saveResults(results, destFileName)
        printResults(results)
    }

    private fun saveResults(results: Map<Int, List<String>>, destFileName: String) {
        val writer = File(destFileName).bufferedWriter()
        writer.use { bufferedWriter ->
            for (result in results.toSortedMap()) {
                bufferedWriter.write("${result.key},${result.value.joinToString(",")}\n")
            }
        }
        writer.close()
    }

    private fun readResourceFileAsLines(fileName: String): List<String> {
        val inputStream = this::class.java.getResourceAsStream(fileName) ?: throw RuntimeException("resource file not exist: $fileName")
        return inputStream.bufferedReader().readLines()
    }

    private fun printResults(results: MutableMap<Int, MutableList<String>>) {
        for (result in results.toSortedMap()) {
            println("${result.key} :: ${result.value}")
        }
    }
}

fun main() {
    val generator = NumConversionGenerator()
//    generator.generate("/pl_PL_clean.txt", "results/pl_PL_result.csv")
    generator.generateConversion("/en_GB_clean.txt", "results/en_GB_result.csv")
}
