package com.rasanbazar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var TAG: String = "MainActivity"
    var PLACE_AUTOCOMPLETE_REQUEST_CODE: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure action bar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Hello Toolbar"

        var drawer_title: TextView = findViewById(R.id.drawer_title)

        drawer_title.setOnClickListener {
            var intent = Intent(this@MainActivity, LoginRegisterActivity::class.java)
            startActivity(intent)
        }


        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this@MainActivity,
            drawer_layout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }

        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        /*// Set navigation view navigation item selected listener
         navigation_view.setNavigationItemSelectedListener{
             when (it.itemId){
                 R.id.action_cut -> toast("Cut clicked")
                 R.id.action_copy -> toast("Copy clicked")
                 R.id.action_paste -> toast("Paste clicked")
                 R.id.action_new ->{
                     // Multiline action
                     toast("New clicked")
                     drawer_layout.setBackgroundColor(Color.RED)
                 }

             }
             // Close the drawer
             drawer_layout.closeDrawer(GravityCompat.START)
             true
         }*/

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)

        var model_list = ArrayList<Main_RV_Model>()
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

        var dealOfDay_list = ArrayList<ChildModel>()

        dealOfDay_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Grocery & Staples",
                true
            )
        )
        dealOfDay_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Fruit",
                true
            )
        )
        dealOfDay_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Personal Care",
                false
            )
        )
        dealOfDay_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Dry Fruits",
                true
            )
        )
        dealOfDay_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Baby & Kids",
                true
            )
        )
        dealOfDay_list.add(
            ChildModel(
                "https://www.huertosdesoria.org/tienda/wp-content/uploads/2016/04/verdura-ecologica.jpg",
                "Breakfast & Dairy",
                true
            )
        )


        /* model_list.add(
             Main_RV_Model(
                 2,
                 "Anand Rai",
                 "Varanasi",
                 "https://www.fingent.com/blog/assets/uploads/2017/03/Infographics_Cover_image-01.png",
                 childModel_list
             )
         )
 */
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
        val adapter = Main_RV_Adapter(this@MainActivity, model_list)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }

    // Extension function to show toast message easily
    private fun Context.toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun GetAddredd() {
        try {
            val intent = PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                .build(this@MainActivity)
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
        } catch (e: GooglePlayServicesRepairableException) {
            // TODO: Handle the error.
        } catch (e: GooglePlayServicesNotAvailableException) {
            // TODO: Handle the error.
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val place = PlaceAutocomplete.getPlace(this@MainActivity, data!!)
                    Log.i(TAG, "Place: " + place.name)
                    val actionBar = supportActionBar
                    actionBar?.title = place.name
                }
                PlaceAutocomplete.RESULT_ERROR -> {
                    val status = PlaceAutocomplete.getStatus(this@MainActivity, data!!)
                    // TODO: Handle the error.
                    Log.i(TAG, status.statusMessage)

                }
                Activity.RESULT_CANCELED -> {
                    // The user canceled the operation.
                }
            }
        }
    }
}
