package com.rasanbazar

import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

        var tv_disitem_dprice: TextView = findViewById(R.id.tv_disitem_dprice)
        tv_disitem_dprice.paintFlags = tv_disitem_dprice.paintFlags or
                Paint.STRIKE_THRU_TEXT_FLAG

        var tv_disnQuntity: TextView = findViewById(R.id.tv_disnQuntity)
        var tv_disiIncrement: TextView = findViewById(R.id.tv_disiIncrement)

        tv_disiIncrement.setOnClickListener {

            var yy = tv_disnQuntity.text.toString()

            tv_disnQuntity.text = (yy.toInt() + 1).toString()
        }
        var tv_disiDecrement: TextView = findViewById(R.id.tv_disiDecrement)
        tv_disiDecrement.setOnClickListener {
            var yy = tv_disnQuntity.text.toString()

            tv_disnQuntity.text = (yy.toInt() - 1).toString()
        }

        var rv_dSameProduct = findViewById(R.id.rv_dSameProduct) as RecyclerView
        rv_dSameProduct.layoutManager =
                LinearLayoutManager(rv_dSameProduct.context, LinearLayout.VERTICAL, false)

        // rv_dSameProduct.addItemDecoration(DividerItemDecoration(rv_dSameProduct.context, 0))

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
        rv_dSameProduct.adapter = childAdapter
    }
}
