package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest: TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            step("Пропускаем онбординг") {
                OnboardingScreen.skipButton.click()
            }
            
            step("Переходим в произвольную статью") {
                Thread.sleep(1000)
                
                ExploreScreen.items.firstChild<TopReadViewItem> {
                    isVisible()
                    cardTopReadTitleTextView.click()
                }
            }
            
            step("Проскролливаем до элемента с id 'References' и проверяем его текст") {
                ArticleViewScreen {
                    Thread.sleep(2000)
                    
                    webView {
                        withElement(Locator.XPATH, "//span[@id='References']") {
                            scroll()
                            hasText("References")
                        }
                        
                        withElement(Locator.XPATH, "//a[contains(@class, 'pcs-ref-back-link') and contains(text(), '[5]')]") {
                            scroll()
                            click()
                        }
                    }
                }
            }
        }
    }
}