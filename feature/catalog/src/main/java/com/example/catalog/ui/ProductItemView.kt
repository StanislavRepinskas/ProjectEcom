package com.example.catalog.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.catalog.R
import com.example.core.domain.model.Product

class ProductItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var product: Product? = null

    private val nameView: TextView
    private val buyView: View
    private val counterView: View
    private val plusView: ImageView
    private val countView: TextView
    private val minusView: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.product_item_view, this, true)
        nameView = findViewById(R.id.product_item_view_name)
        buyView = findViewById(R.id.product_item_view_buy)
        counterView = findViewById(R.id.product_item_view_counter)
        plusView = findViewById(R.id.product_item_view_plus)
        countView = findViewById(R.id.product_item_view_count)
        minusView = findViewById(R.id.product_item_view_minus)
    }

    fun bind(product: Product) {
        this.product = product
        nameView.text = product.name
    }
}