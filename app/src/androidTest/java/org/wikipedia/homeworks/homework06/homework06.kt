package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.CoreMatchers.allOf

enum class Color { 
    RED, 
    BLUE, 
    GREEN, 
    YELLOW, 
    BLACK, 
    WHITE 
}

data class Shape(
    val sideLength: Float, 
    val numberOfSides: Int, 
    val color: Color
    )

val shapes = listOf(
    Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
    Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
    Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
    Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
    Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
    Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
    Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
)

class SideLengthRangeMatcher(
    private val minLength: Float,
    private val maxLength: Float
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description?.appendText("фигура с длиной стороны в пределах $minLength и $maxLength")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength in minLength..maxLength
    }
}

fun hasValidSideLength() = SideLengthRangeMatcher(0.1f, 100.0f)

class AngleCountMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("фигура с корректным количеством углов")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return when {
            shape.numberOfSides <= 2 -> true  
            shape.numberOfSides >= 3 -> true  
            else -> false
        }
    }
}

class EvenSidesCountMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("фигура с четным количеством сторон")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides % 2 == 0
    }
}

fun hasEvenSidesCount() = EvenSidesCountMatcher()
fun hasValidAngleCount() = AngleCountMatcher()

class ColorMatcher(private val expectedColor: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("фигура цвета $expectedColor")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == expectedColor
    }
}

fun hasColor(color: Color) = ColorMatcher(color)

class NonNegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("фигура с неотрицательной длиной стороны")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength >= 0
    }
}

class NonNegativeSidesCountMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("фигура с неотрицательным количеством сторон")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides >= 0
    }
}

fun hasNonNegativeSideLength() = NonNegativeSideLengthMatcher()
fun hasNonNegativeSidesCount() = NonNegativeSidesCountMatcher()

fun main() {
    shapes.forEachIndexed { index, shape ->
        try {
            println("\nПроверяем фигуру #${index + 1}: $shape")
            assertThat(shape, allOf(
                hasValidSideLength(),
                hasValidAngleCount(),
                hasEvenSidesCount(),
                hasColor(shape.color),
                hasNonNegativeSideLength(),
                hasNonNegativeSidesCount()
            ))
            println("Фигура прошла все проверки")
        } catch (e: AssertionError) {
            println("Фигура не прошла проверку: ${e.message}")
        }
    }
}

