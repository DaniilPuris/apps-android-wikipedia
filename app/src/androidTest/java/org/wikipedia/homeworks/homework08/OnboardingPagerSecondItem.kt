package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPagerSecondItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerSecondItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }
}