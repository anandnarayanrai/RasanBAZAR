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
                "Grocery & Staples"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://wedigthepig.com/wp-content/uploads/2016/05/gogreen-pic-007-3.png",
                "Fruit"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Personal Care"
            )
        )
        childModel_list.add(
            ChildModel(
                "http://vapelabpk.com/wp-content/uploads/revslider/royalmarket1/nuts.png",
                "Dry Fruits"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Baby & Kids"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Biscuits, Snacks & Chocolates"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Breakfast & Dairy"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Vegetables"
            )
        )
        childModel_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Beverages"
            )
        )

        var childAdapter = ChildAdapter(childModel_list, 1)
        rv_AllProduct.adapter = childAdapter
    }
}
