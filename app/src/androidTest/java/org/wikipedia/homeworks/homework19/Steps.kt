package org.wikipedia.homeworks.homework19

import com.kaspersky.components.kautomator.component.common.assertions.UiBaseAssertions
import com.kaspersky.components.kautomator.component.text.UiTextViewAssertions
import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

class Steps(private val testContext: TestContext<*>) {

    private fun execute(textOfStep: String, actions: (StepInfo) -> Unit){
        testContext.step(textOfStep, actions)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun disableNetwork(device: Device) {
        execute("Отключает сетевое соединение") {
            device.network.disable()
        }
    }
    
    fun enableNetwork(device: Device) {
        execute("Включает сетевое соединение") {
            device.network.enable()
        }
    }

    fun setOrientationLeft(device: Device) {
        execute("Устанавливает ориентацию экрана влево") {
            device.setOrientationLeft()
        }
    }
    
    fun setOrientationRight(device: Device) {
        execute("Устанавливает ориентацию экрана вправо") {
            device.setOrientationRight()
        }
    }
    
    fun setOrientationNatural(device: Device) {
        execute("Возвращает естественную ориентацию экрана") {
            device.setOrientationNatural()
        }
    }

    fun isVisible(item: BaseAssertions, name: String) {
        execute("Проверяет видимость элемента '$name'"){
            item.isVisible()
        }
    }

    fun isDisplayed(item: UiBaseAssertions, name: String) {
        execute("Проверяет отображение элемента '$name'"){
            item.isDisplayed()
        }
    }

    fun hasText(item: UiTextViewAssertions, text: String) {
        execute("Checks if the view has concrete text '$text'"){
            item.hasText(text)
        }
    }

    fun hasAnyText(item: UiTextViewAssertions, name: String) {
        execute("Checks if the view has any text '$name'"){
            item.hasAnyText()
        }
    }

    fun containsText(item: UiTextViewAssertions, text: String) {
        execute("Checks if the view contains concrete text '$text'"){
            item.containsText(text)
        }
    }

    fun click(item: BaseActions, name: String){
        execute("Нажимает на элемент '$name'"){
            item.click()
        }
    }

    fun sleep(millis: Long){
        execute("Сделать паузу $millis"){
            Thread.sleep(millis)
        }
    }
}