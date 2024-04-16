package com.example.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.core.domain.model.Product

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = view.findViewById(R.id.fragment_product_text)
        textView.text = arguments?.getString(ARG_NAME_KEY) ?: "Undefined"
    }

    companion object {
        fun createArgs(product: Product): Bundle {
            return Bundle().apply {
                putString(ARG_NAME_KEY, product.name)
            }
        }

        private const val ARG_NAME_KEY = "ARG_NAME_KEY"
    }
}