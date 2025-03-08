package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkImageIsView() {
        run {
            OnboardingUiScreen.image.isDisplayed()
        }
    }

    @Test
    fun checkPrimaryTextIsDisplayed() {
        run {
            OnboardingUiScreen.primaryText.isDisplayed()
        }
    }

    @Test
    fun checkPrimaryTextContainsText() {
        run {
            OnboardingUiScreen.primaryText {
                containsText("The Free Encyclopedia")
            }
        }
    }

    @Test
    fun checkSecondaryTextIsDisplayed() {
        run {
            OnboardingUiScreen.secondaryText.isDisplayed()
        }
    }

    @Test
    fun checkSecondaryTextContainsText() {
        run {
            OnboardingUiScreen.secondaryText {
                containsText("We’ve found the following on your device:")
            }
        }
    }

    @Test
    fun checkSkipButtonIsDisplayed() {
        run {
            OnboardingUiScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkSkipButtonHasText() {
        run {
            OnboardingUiScreen.skipButton {
                hasText("Skip")
            }
        }
    }

    @Test
    fun checkContinueButtonIsDisplayed() {
        run {
            OnboardingUiScreen.continueButton.isDisplayed()
        }
    }

    @Test
    fun checkContinueButtonHasText() {
        run {
            OnboardingUiScreen.continueButton {
                hasText("Continue")
            }
        }
    }
}



