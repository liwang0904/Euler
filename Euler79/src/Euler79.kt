import java.io.File

fun main() {
    val file = "src/keylog.txt"
//    println(fileToList(file))
//    println(determineCharactersBefore('0', fileToList(file)))
    determinePasscode(fileToList(file))
}

fun fileToList(file: String): List<String> {
    var randomCharacters = mutableListOf<String>()
    File(file).forEachLine { randomCharacters.add(it) }
    return randomCharacters
}

fun determineCharactersBefore(char: Char, randomCharacters: List<String>): List<Char> {
    val characterBefore = mutableListOf<Char>()
    for (input in randomCharacters) {
        if (input.toCharArray().contains(char)) {
            val precedingCharacters = input.toCharArray().slice(0 until input.toCharArray().indexOf(char))
            for (precedingCharacter in precedingCharacters) {
                characterBefore.add(precedingCharacter)
            }
        }
    }
    return characterBefore.distinct()
}

fun determinePasscode(randomCharacters: List<String>): String {
    val passcode = mutableListOf<Char>()
    val characters = mutableListOf<Char>()
    for (input in randomCharacters) {
        val chars = input.toCharArray()
        for (char in chars) {
            characters.add(char)
        }
    }
    for (character in characters.distinct()) {
        println(character)
        println(determineCharactersBefore(character, randomCharacters))
//        val index = characters.distinct().size - determineCharactersBefore(character, randomCharacters).size
//        passcode.add(index, character)
    }

    return passcode.toString()
}