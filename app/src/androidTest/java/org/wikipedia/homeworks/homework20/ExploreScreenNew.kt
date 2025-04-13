package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadItem

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Заголовок"))
    }
    val feed = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::TopReadItem)
        }
    ).name(withParent("Список блоков"))

    fun topReadItem(index: Int, function: TopReadItem.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun topReadItem(): TopReadItem {
        return feed.childWith<TopReadItem> {
            withDescendant {
                withText("Top read")
            }
        }.name(feed.getName().withParent("Top read"))
    }


}