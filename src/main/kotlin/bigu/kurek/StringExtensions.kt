package bigu.kurek

fun String.replacePrefix(prefix: String, newValue: String): String {
    if (this.startsWith(prefix)) {
        return this.replaceFirst(prefix, newValue)
    }
    return this
}
