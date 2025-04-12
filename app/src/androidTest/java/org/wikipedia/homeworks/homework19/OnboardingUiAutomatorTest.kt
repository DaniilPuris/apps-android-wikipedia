package org.wikipedia.homeworks.homework19

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework10.OnboardingUiScreen
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onboardingUiAutomatorTest() {
        run {
            steps {
                device.network.disable()
            }
            steps {
                device.network.enable()
            }
            steps {
                isVisible(OnboardingUiScreen.image, "imageViewCentered")
            }
            steps {
                isDisplayed(OnboardingUiScreen.secondaryText, "secondaryTextView")
            }
            steps {
                containsText(OnboardingUiScreen.secondaryText, "We’ve found the following on your device:")
            }
            steps {
                hasText(OnboardingUiScreen.skipButton,"Skip")
            }
            steps {
                hasAnyText(OnboardingUiScreen.continueButton,"continueButton")
            }
        }
    }
}
