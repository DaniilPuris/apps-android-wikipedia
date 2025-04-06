package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.homeworks.homework10.OnboardingUiScreen

class OnboardingUiAutomatorTest2 : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkScreenRotationAndOrientation() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        run {
            step("Проверка начальной ориентации экрана") {
                assertTrue(
                    "Экран изначально должен быть в естественной ориентации",
                    device.isNaturalOrientation
                )
                OnboardingUiScreen.image.isDisplayed()
            }

            step("Поворот экрана в альбомный режим") {
                device.setOrientationLeft()
                assertFalse(
                    "Экран не должен быть в естественной ориентации после поворота",
                    device.isNaturalOrientation
                )
            }

            step("Проверка отображения элементов в альбомном режиме") {
                OnboardingUiScreen.image.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
                OnboardingUiScreen.continueButton.isDisplayed()
            }

            step("Возврат в портретный режим") {
                device.setOrientationNatural()
                assertTrue(
                    "Экран должен вернуться в естественную ориентацию",
                    device.isNaturalOrientation
                )
            }

            step("Проверка отображения элементов после возврата в портретный режим") {
                OnboardingUiScreen.image.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
                OnboardingUiScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkScreenTurnOffAndOn() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        run {
            step("Проверка отображения элемента до выключения экрана") {
                OnboardingUiScreen.image.isDisplayed()
            }

            step("Выключение экрана") {
                device.sleep()
                Thread.sleep(1000)
            }

            step("Включение экрана") {
                device.wakeUp()
                if (!device.isScreenOn) {
                    device.pressMenu()
                }
                Thread.sleep(1000)
            }

            step("Проверка отображения элемента после включения экрана") {
                assertTrue("Экран должен быть включен",
                    device.isScreenOn
                )
                OnboardingUiScreen.image.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
            }
        }
    }

    @Test
    fun checkHomeButtonAndRecentApps() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        run {
            step("Проверка отображения элемента до сворачивания приложения") {
                OnboardingUiScreen.image.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
            }

            step("Сворачивание приложения кнопкой Home") {
                device.pressHome()
                Thread.sleep(1000)
            }

            step("Разворачивание приложения через Recent Apps") {
                device.pressRecentApps()
                Thread.sleep(1000)

                device.pressRecentApps()
                Thread.sleep(1500)
            }

            step("Проверка отображения элемента после разворачивания приложения") {
                OnboardingUiScreen.image.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
                OnboardingUiScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkCurrentActivityIsMainActivity() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        run {
            step("Проверка, что текущая активность — MainActivity") {
                val packageName = context.packageName

                assertTrue("Приложение должно быть на переднем плане",
                    device.currentPackageName == packageName
                )

                OnboardingUiScreen.image.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
            }
        }
    }
}
