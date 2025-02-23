package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AnnouncementCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<AnnouncementCardViewItem>(matcher)  {

    val cardAnnouncementHeaderImageView = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val cardAnnouncementTextView = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val cardAnnouncementCustomizeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val cardAnnouncementGotItButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }
}