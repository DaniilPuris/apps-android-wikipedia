package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R


object RelatedNewsScreen: KScreen<RelatedNewsScreen>() {
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null

    val newsStoryRecyclerView = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::NewsStoryRecyclerViewItems)
        }
    )
}


