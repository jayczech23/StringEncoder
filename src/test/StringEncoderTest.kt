package test

import main.StringEncoder
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringEncoderTest {

    private lateinit var encoder: StringEncoder
    private val errorMessage: String = "Encoded String did not match expected output: "

    @BeforeAll
    fun setup() {
        encoder = StringEncoder()
    }

    @Test
    fun test_encode_simple_single_vowel() {
        val result = encoder.encodeString("a")
        assertEquals("1",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_vowels_all() {
        val input = "aeiou"
        val result = encoder.encodeString(input)
        assertEquals("12345",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_vowels_backwards() {
        val input = "uoiea"
        val result = encoder.encodeString(input)
        assertEquals("54321",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_vowels_with_punctuation() {
        val input = "aiu!"
        val result = encoder.encodeString(input)
        assertEquals("135!",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_y_to_whitespace() {
        val input = "y"
        val result = encoder.encodeString(input)
        assertEquals(" ",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_multiple_whitespace_to_y() {
        val input = "   "
        val result = encoder.encodeString(input)
        assertEquals("yyy",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_multiple_y_to_whitespace() {
        val input = "yyyy"
        val result = encoder.encodeString(input)
        assertEquals("    ",
            result,
            errorMessage + result)
    }

    @Test
    fun test_encode_whitespace_to_y() {
        val input = " "
        val result = encoder.encodeString(input)
        assertEquals("y",
            result,
            errorMessage + result)
    }

    @Test
    fun test_hello_world() {
        val input = "Hello World!"
        val result = encoder.encodeString(input)
        assertEquals("g2kk4yv4qkc!",
            result,
            errorMessage + result)
    }

    @Test
    fun test_all_caps() {
        val input = "ABCDEFG"
        val result = encoder.encodeString(input)
        assertEquals("1abc2ef",
            result,
            errorMessage + result)
    }

    @Test
    fun test_star_wars() {
        val input = "You've never heard of the Millennium Falcon? It's the ship that made the Kessel Run in less than 12 parsecs."
        val result = encoder.encodeString(input)
        assertEquals(" 45'u2ym2u2qyg21qcy4eysg2yl3kk2mm35lye1kb4m?y3s'rysg2yrg3oysg1syl1c2ysg2yj2rr2kyq5my3myk2rrysg1my21yo1qr2br.",
            result,
            errorMessage + "\n$result")
    }

    @Test
    fun test_only_one_num() {
        val input = "1"
        val result = encoder.encodeString(input)
        assertEquals("1",
            result,
            errorMessage + result)
    }

    @Test
    fun test_2_nums_reverse() {
        val input = "12"
        val result = encoder.encodeString(input)
        assertEquals("21",
            result,
            errorMessage + result)
    }

    @Test
    fun test_big_num_reverse() {
       val input = "9874659832"
        val result = encoder.encodeString(input)
        assertEquals(input.reversed(),
            result,
            errorMessage + result)
    }
}