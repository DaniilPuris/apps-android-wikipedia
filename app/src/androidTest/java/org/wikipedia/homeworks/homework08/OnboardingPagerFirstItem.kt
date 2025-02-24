package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPagerFirstItem (
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerFirstItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val description = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languagesList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItem)
        }
    )

    val addLanguagesButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}