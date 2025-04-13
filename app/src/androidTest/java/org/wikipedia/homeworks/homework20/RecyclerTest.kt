package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.homeworks.homework19.namedSteps

class RecyclerTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testTopReadSection() = run {
        step("Открываем главный экран") {
            ExploreScreenNew {
                namedSteps.isVisible(toolbarTitle)
            }
        }

        step("Взаимодействуем с блоком Top Read") {
            ExploreScreenNew {
                val topReadBlock = topReadItem()

                namedSteps.isVisible(topReadBlock.headerText)

                namedSteps.click(topReadBlock.moreTopReadBtn)
            }
        }
    }
}