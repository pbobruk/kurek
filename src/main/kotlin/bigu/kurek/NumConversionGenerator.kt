package bigu.kurek

import java.io.File

class NumConversionGenerator {
    companion object {
        val NUMBS_TO_CONVERT_RANGE = 1..4000
    }

    fun generateConversion(converter: Word2NumberConverter, dictionaryFilename: String, destFileName: String) {
        val dictionaryWords = readResourceFileAsLines(dictionaryFilename)
        val results: HashMap<Int, MutableList<String>> = object : HashMap<Int, MutableList<String>>() {
            init {
                NUMBS_TO_CONVERT_RANGE.forEach { num -> put(num, mutableListOf()) }
            }
        }
        for (word in dictionaryWords) {
            val number = converter.word2number(word)
            if (number in NUMBS_TO_CONVERT_RANGE) {
                val prettyWord = converter.wordPrettify(word)
                results[number]?.add("$word $prettyWord")
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
        val inputStream = this::class.java.getResourceAsStream(fileName)
            ?: throw RuntimeException("resource file not exist: $fileName")
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
    generator.generateConversion(Word2NumberConverter.STANDARD,"/pl_PL_clean.txt", "results/pl_PL_result.csv")
    generator.generateConversion(Word2NumberConverter.STANDARD, "/en_GB_clean.txt", "results/en_GB_result.csv")

    generator.generateConversion(Word2NumberConverter.V6, "/pl_PL_clean.txt", "results/pl_PL_result_v6.csv")
    generator.generateConversion(Word2NumberConverter.V6, "/en_GB_clean.txt", "results/en_GB_result_v6.csv")

    generator.generateConversion(Word2NumberConverter.V7, "/pl_PL_clean.txt", "results/pl_PL_result_v7.csv")
    generator.generateConversion(Word2NumberConverter.V7, "/en_GB_clean.txt", "results/en_GB_result_v7.csv")

}
