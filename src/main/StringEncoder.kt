package main

class StringEncoder {

    private val encodeTable = hashMapOf(
        'a' to "1",
        'b' to "a",
        'c' to "b",
        'd' to "c",
        'e' to "2",
        'f' to "e",
        'g' to "f",
        'h' to "g",
        'i' to "3",
        'j' to "i",
        'k' to "j",
        'l' to "k",
        'm' to "l",
        'n' to "m",
        'o' to "4",
        'p' to "o",
        'q' to "p",
        'r' to "q",
        's' to "r",
        't' to "s",
        'u' to "5",
        'v' to "u",
        'w' to "v",
        'x' to "w",
        'y' to " ",
        'z' to "y",
        ' ' to "y"
    )

    fun encodeString(input: String): String {
        var result = ""
        var numBuffer = ""
        var numCount = 0
        val inputString = input.toLowerCase()

        for (character in inputString) {
            if (encodeTable.containsKey(character)) {
                if (numCount > 0) {
                    result += numBuffer.reversed()
                    numCount = 0
                    numBuffer = ""
                }
                result += encodeTable[character]
                continue
            } else if (character.isDigit()) {
                numBuffer += character
                numCount++
                continue
            }
            // special characters
            result += character
        }

        // account for digit only inputs
        if (numCount > 0) {
            result += numBuffer.reversed()
        }

        return result
    }
}
