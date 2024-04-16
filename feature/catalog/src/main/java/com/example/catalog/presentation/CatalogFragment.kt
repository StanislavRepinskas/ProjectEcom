package com.example.catalog.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.catalog.R
import com.example.catalog.data.CatalogRepositoryImpl
import com.example.catalog.di.DaggerCatalogComponent
import com.example.catalog.ui.ProductItemView
import com.example.core.di.NavigationDependencyHolder
import com.example.core.domain.model.Product
import com.example.core.observe
import com.example.product_api.ProductNavigation
import javax.inject.Inject

class CatalogFragment : Fragment() {
    lateinit var viewModel: CatalogViewModel

    private var listView: LinearLayout? = null

    @Inject
    lateinit var productNavigation: ProductNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerCatalogComponent.factory().create(
            (requireActivity() as NavigationDependencyHolder).getNavigationDependencyProvider()
        ).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = CatalogViewModel(CatalogRepositoryImpl())

        listView = view.findViewById(R.id.fragment_catalog_list)

        viewModel.products.observe(this) {
            updateProducts(it)
        }
    }

    private fun updateProducts(products: List<Product>) {
        val listViewValue = listView ?: return
        listViewValue.removeAllViews()
        for (product in products) {
            val view = ProductItemView(requireContext())
            listViewValue.addView(view)
            view.bind(product)
            view.setOnClickListener {
                productNavigation.openProduct()
            }
        }
    }
}