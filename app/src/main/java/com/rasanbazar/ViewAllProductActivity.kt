package com.rasanbazar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class ViewAllProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_product)
        var imageUrl: String = intent.getStringExtra("imageUrl")
        var productName: String = intent.getStringExtra("productName")
        var rv_AllProduct = findViewById(R.id.rv_AllProduct) as RecyclerView
        rv_AllProduct.layoutManager =
                LinearLayoutManager(rv_AllProduct.context, LinearLayout.VERTICAL, false)

        rv_AllProduct.addItemDecoration(DividerItemDecoration(rv_AllProduct.context, 0))

        var childModel_list = ArrayList<ChildModel>()
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Grocery & Staples",
                true
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Fruit",
                true
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Personal Care",
                true
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Dry Fruits",
                true
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Baby & Kids",
                false
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Biscuits, Snacks & Chocolates",
                true
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Breakfast & Dairy",
                true
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Vegetables",
                false
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Beverages",
                true
            )
        )

        var childAdapter = ChildAdapter(childModel_list, 1)
        rv_AllProduct.adapter = childAdapter
    }
}
