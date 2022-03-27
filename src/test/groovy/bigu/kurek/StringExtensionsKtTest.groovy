package bigu.kurek

import spock.lang.Specification
import spock.lang.Unroll

class StringExtensionsKtTest extends Specification {

    @Unroll
    def "should replace prefix in #input"() {
        expect:
        use(StringExtensionsKt) {
            input.replacePrefix(prefix, newValue) == expectedOutput
        }

        where:
        input     | prefix | newValue | expectedOutput
        "czaszka" | "cz"   | "z"      | "zaszka"
        "czacza"  | "cz"   | "z"      | "zacza"
    }
}
