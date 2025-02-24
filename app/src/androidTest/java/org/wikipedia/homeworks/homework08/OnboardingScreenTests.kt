package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity


class OnboardingScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFirstSlideImageTest() {
        run {
            step("Check that image is displayed on first onboarding slide") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    image.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkTitleDisplayed() {
        run {
            step("Check that title is displayed") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    title.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkTitleHasCorrectText() {
        run {
            step("Check that title has correct text") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    title.hasText("The Free Encyclopedia")
                }
            }
        }
    }

    @Test
    fun checkLanguagesListDisplayed() {
        run {
            step("Check that languages list is displayed") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languages.isDisplayed()
                }
            }
        }
    }
}








