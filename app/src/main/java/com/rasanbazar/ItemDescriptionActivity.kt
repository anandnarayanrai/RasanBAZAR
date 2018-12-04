package com.rasanbazar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide

class ItemDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_description)
        var imageUrl: String = intent.getStringExtra("imageUrl")
        var iv_disItemImage: ImageView = findViewById(R.id.iv_disItemImage)
        Glide.with(this@ItemDescriptionActivity)
            .load(imageUrl)
            .into(iv_disItemImage)
        var tv_disItemName: TextView = findViewById(R.id.tv_disItemName)
        tv_disItemName.text = intent.getStringExtra("productName")

        var rv_dSameProduct = findViewById(R.id.rv_dSameProduct) as RecyclerView
        rv_dSameProduct.layoutManager =
                LinearLayoutManager(rv_dSameProduct.context, LinearLayout.VERTICAL, false)

        rv_dSameProduct.addItemDecoration(DividerItemDecoration(rv_dSameProduct.context, 0))

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
        rv_dSameProduct.adapter = childAdapter
    }
}
