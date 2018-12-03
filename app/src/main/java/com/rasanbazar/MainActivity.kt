package com.rasanbazar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)

        var model_list = ArrayList<Main_RV_Model>()
        var childModel_list = ArrayList<ChildModel>()
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Grocery & Staples"))
        childModel_list.add(ChildModel("https://wedigthepig.com/wp-content/uploads/2016/05/gogreen-pic-007-3.png", "Fruit"))
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Personal Care"))
        childModel_list.add(ChildModel("http://vapelabpk.com/wp-content/uploads/revslider/royalmarket1/nuts.png", "Dry Fruits"))
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Baby & Kids"))
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Biscuits, Snacks & Chocolates"))
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Breakfast & Dairy"))
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Vegetables"))
        childModel_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Beverages"))

        var dealOfDay_list= ArrayList<ChildModel>()

        dealOfDay_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Grocery & Staples"))
        dealOfDay_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Fruit"))
        dealOfDay_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Personal Care"))
        dealOfDay_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Dry Fruits"))
        dealOfDay_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Baby & Kids"))
        dealOfDay_list.add(ChildModel("https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg", "Breakfast & Dairy"))


      /*  model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "https://www.fingent.com/blog/assets/uploads/2017/03/Infographics_Cover_image-01.png",
                childModel_list
            )
        )*/

        model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "http://www.psdtohtmlcloud.com/blog/wp-content/uploads/2016/12/christmas-new-year-offer.jpg",
                childModel_list
            )
        )

        model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "https://images-eu.ssl-images-amazon.com/images/G/31/img17/AmazonPay/NocostEMI/BankCB/V2/NCE11_ART_1500x200.jpg",
                childModel_list
            )
        )

        model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTamvQ--ndZpm4AMnaF-NvtT0casDzYByZUk5BdYMy8Up9vLuv0fQ",
                childModel_list
            )
        )

        model_list.add(
            Main_RV_Model(
                1,
                "Anand Rai",
                "Varanasi",
                "https://pbs.twimg.com/media/DShUEpLUIAIFTFt.jpg",
                childModel_list
            )
        )
        model_list.add(
            Main_RV_Model(
                3,
                "Deals of the Day",
                "Varanasi",
                "https://pbs.twimg.com/media/DShUEpLUIAIFTFt.jpg",
                dealOfDay_list
            )
        )

        model_list.add(
            Main_RV_Model(
                3,
                "Shop By Category",
                "Varanasi",
                "https://www.fingent.com/blog/assets/uploads/2017/03/Infographics_Cover_image-01.png",
                childModel_list
            )
        )
        model_list.add(
            Main_RV_Model(
                3,
                "Best Offer",
                "Varanasi",
                "https://img3.gozefo.com/zefo-store-home.jpg",
                dealOfDay_list
            )
        )

        model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "http://rasanbazar.com/image/data/logosample.png",
                childModel_list
            )
        )

        model_list.add(
            Main_RV_Model(
                3,
                "Trending Product",
                "Varanasi",
                "https://www.fingent.com/blog/assets/uploads/2017/03/Infographics_Cover_image-01.png",
                childModel_list
            )
        )

        model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbFLpuLFfQciioPtEBAHiRn64P5W3E8m-HVBFdiATeCp8Fh8k2",
                childModel_list
            )
        )
        model_list.add(
            Main_RV_Model(
                2,
                "Anand Rai",
                "Varanasi",
                "https://3udno63459u23yboa6366rls-wpengine.netdna-ssl.com/wp-content/uploads/2017/05/Best-Offers-In-Ecommerce.jpg",
                childModel_list
            )
        )

        //creating our adapter
        val adapter = Main_RV_Adapter(model_list)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}
