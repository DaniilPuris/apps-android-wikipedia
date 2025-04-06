package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object WikipediaArticleScreen : KScreen<WikipediaArticleScreen>() {
    override val layoutId = null
    override val viewClass = null

    val webView = KWebView {
        withId(R.id.page_web_view)
    }
}