package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class PageWebViewElementTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkPageWebViewElementIsVisible() = run {
        step("Skip onboarding") {
            OnboardingScreen.skipButton.click()
        }

        step("Find and click on the third news item") {
            ExploreScreen {
                items {
                    childWith<InTheNewsCardViewItem> {
                        withDescendant {
                            withText("In the news")
                        }
                    } perform {
                        inTheNewsCardList {
                            childAt<InTheNewsRecyclerItem>(2) {
                                click()
                            }
                        }
                    }
                }
            }
        }

        step("Click on the second article") {
            RelatedNewsScreen {
                newsStoryRecyclerView {
                    childAt<NewsStoryRecyclerViewItems>(1) {
                        click()
                    }
                }
            }
        }

        step("Check if WebView is displayed") {
            onView(withId(R.id.page_web_view)).check(matches(isDisplayed()))
        }
    }
}