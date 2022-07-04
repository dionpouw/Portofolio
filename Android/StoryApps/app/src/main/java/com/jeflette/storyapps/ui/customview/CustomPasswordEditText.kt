package com.jeflette.storyapps.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class CustomPasswordEditText :
    AppCompatEditText {

    constructor(context: Context) : super(
        context
    ) {

        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                if (p0.length <= 6) {
                    this@CustomPasswordEditText.error = "Minimal 6 karakter"
                } else {
                    this@CustomPasswordEditText.error = null
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}