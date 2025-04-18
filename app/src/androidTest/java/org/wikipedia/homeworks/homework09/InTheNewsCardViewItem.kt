package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R


class InTheNewsCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<InTheNewsCardViewItem>(matcher) {

    val inTheNewsTitleTextView = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val viewListCardHeaderMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val inTheNewsCardList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::InTheNewsRecyclerItem)
        }
    )
}