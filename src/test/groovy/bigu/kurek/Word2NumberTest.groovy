package bigu.kurek

import spock.lang.Specification

class Word2NumberTest extends Specification {


    def "should convert word: '#word' to number: '#number'"() {
        def word2number = new Word2Number()

        expect:
        word2number.word2number(word) == number

        where:
        word     | number
        "LoDóWa" | "103"
        "LaKieR" | "144"
    }
}
