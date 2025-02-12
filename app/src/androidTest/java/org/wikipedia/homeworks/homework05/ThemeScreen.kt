package org.wikipedia.homeworks.homework05

import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.button.MaterialButton
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.slider.KSlider
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.views.DiscreteSeekBar

val handleBar = KView {
    isInstanceOf(View::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val readingSettingsHeader = KTextView {
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val textScalingPercent = KTextView {
    withId(R.id.text_size_percent)
    withText("100% (Default)")
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val buttonDecreaseTextScale = KButton {
    withId(R.id.buttonDecreaseTextSize)
    withText("T")
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val textScaleSeekBar = KSlider {
    withId(R.id.text_size_seek_bar)
    isInstanceOf(DiscreteSeekBar::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val buttonIncreaseTextScale = KButton {
    withId(R.id.buttonIncreaseTextSize)
    withText("T")
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val fontSelectionButton1 = KButton {
    withId(R.id.button_font_family_sans_serif)
    withText(R.string.font_family_sans_serif)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val fontSelectionButton2 = KButton {
    withId(R.id.button_font_family_serif)
    withText(R.string.font_family_serif)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val readingFocusModeImage = KImageView {
    withDrawable(R.drawable.ic_icon_reading_focus_mode)
    isInstanceOf(AppCompatImageView::class.java)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val themeChooserReadingFocusModeSwitch = KSwitch {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
    withText(R.string.reading_focus_mode)
    isInstanceOf(MaterialSwitch::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val themeChooserReadingFocusModeDescription = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
    withText(R.string.reading_focus_mode_detail)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(ScrollView::class.java)
    }
}

val themeSettingsHeader = KTextView {
    withText("Theme")
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val buttonThemeLight = KButton {
    withId(R.id.button_theme_light)
    withText("Aa")
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val buttonThemeSepia = KButton {
    withId(R.id.button_theme_sepia)
    withText("Aa")
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val buttonThemeDark = KButton {
    withId(R.id.button_theme_dark)
    withText("Aa")
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val buttonThemeBlack = KButton {
    withId(R.id.button_theme_black)
    withText("Aa")
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withParent {
            isInstanceOf(ScrollView::class.java)
        }
    }
}

val themeChooserMatchSystemThemeSwitch = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
    withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
    isInstanceOf(MaterialSwitch::class.java)
    withParent {
        isInstanceOf(ScrollView::class.java)
    }
}

val themeChooserDarkModeDimImagesSwitch = KSwitch {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    withText(R.string.theme_chooser_dialog_image_dimming_switch_label)
    isInstanceOf(MaterialSwitch::class.java)
    withParent {
        isInstanceOf(ScrollView::class.java)
    }
}