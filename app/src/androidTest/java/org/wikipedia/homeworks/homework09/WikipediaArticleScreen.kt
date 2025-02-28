package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object WikipediaArticleScreen : KScreen<WikipediaArticleScreen>() {
    override val layoutId = null
    override val viewClass = null

    val webView = KView {
        withId(R.id.page_web_view)
    }
}