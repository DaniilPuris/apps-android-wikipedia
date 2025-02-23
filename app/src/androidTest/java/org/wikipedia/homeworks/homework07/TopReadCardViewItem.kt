package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardViewItem (
    matcher: Matcher<View>
) : KRecyclerItem<TopReadCardViewItem>(matcher) {

    val numberTextView = KTextView(matcher) {
        withId(R.id.numberView)
    }

    val titleTextView = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val subtitleTextView = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val graphView = KTextView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val pageViewsTextView = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val imageView = KTextView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}