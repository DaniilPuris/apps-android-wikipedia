package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val primaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }
    val pageIndicator = UiBottomNavigationView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }

    val getStartedButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }
}

