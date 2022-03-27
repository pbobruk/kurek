package bigu.kurek

import spock.lang.Specification
import spock.lang.Unroll

class Word2NumberTest extends Specification {
    
    def "should convert word: '#word' to expectedNumber: '#expectedNumber'"() {
        def word2number = new Word2Number()

        expect:
        word2number.word2number(word) == expectedNumber

        where:
        word        | expectedNumber
        "LoDóWa"    | 103
        "LaKieR"    | 144
        "cZaSzKa"   | 254
        "cZePeK"    | 294
        "MaLuCh"    | 310
        "KoCheR"    | 404
        "DeLFiN"    | 172
        "KSiąDz"    | 450
        "PęDzeL"    | 901
        "PieLuCha"  | 910
        "ZeSzyT"    | 251
        "aLKieRz"   | 144
        "TaBLeT"    | 1811
        "ZDzieLeNi" | 2012
        "MuRzyN"    | 342
        "RzeRzuCha" | 440
        "LaTaWieC"  | 1130
        "PaŁaC"     | 970
        "FiLC"      | 710
        "PieRzyNa"  | 942
        "PoRoŻe"    | 942
        "ToŚKa"     | 154
        "KaPeĆ"     | 490
        "BaŃKa"     | 824
        "sZaDŹ"     | 202
    }

    @Unroll
    def "should prettify word: #word to #prettyWord"() {
        def word2number = new Word2Number()

        expect:
        word2number.wordPrettify(word) == prettyWord

        where:
        word        | prettyWord
        "szadź"     | "sZaDŹ"
        "pielucha"  | "PieLuCha"
        "zeszyt"    | "ZeSzyT"
        "filc"      | "FiLC"
        "delfin"    | "DeLFiN"
        "rzerzucha" | "RzeRzuCha"
        "zdzieleni" | "ZDzieLeNi"
        "czaszka"   | "cZaSzKa"
    }
}
