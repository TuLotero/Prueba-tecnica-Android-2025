package com.tulotero.buscadorboletos.uicomponents

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.tulotero.buscadorboletos.R

class FilterButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val filterIcon: ImageView
    private val filterText: TextView
    private val filterWithValue: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_filter_button, this, true)
        filterIcon = findViewById(R.id.filter_icon)
        filterText = findViewById(R.id.filter_text)
        filterWithValue = findViewById(R.id.filter_with_value)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.FilterButtonView)
        filterIcon.setImageResource(attributes.getResourceId(R.styleable.FilterButtonView_icon, 0))
        filterText.text = attributes.getString(R.styleable.FilterButtonView_text)
        attributes.recycle()
    }
}