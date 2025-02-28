package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsRecyclerItem (
    matcher: Matcher<View>
) : KRecyclerItem<InTheNewsRecyclerItem>(matcher) {

    val horizontalScrollListItemImage = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }

    val horizontalScrollListItemText = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}