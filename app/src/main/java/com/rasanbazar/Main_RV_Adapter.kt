package com.rasanbazar

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_rv_item_view1.view.*
import kotlinx.android.synthetic.main.parent_recycler.view.*

class Main_RV_Adapter(var model_liat: ArrayList<Main_RV_Model>) : RecyclerView.Adapter<Main_RV_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //// TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /* var view = LayoutInflater.from(parent.context).inflate(R.layout.main_rv_item_view1, parent, false)
         return ViewHolder(view)*/
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> ViewHolderItemA(inflater.inflate(R.layout.main_rv_item_view1, null))
            2 -> ViewHolderItemB(inflater.inflate(R.layout.main_rv_item_view2, null))
            else -> ViewHolderItemC(inflater.inflate(R.layout.parent_recycler, null))
        }
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return model_liat.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var main_RV_Model = model_liat[position]

        when (main_RV_Model.viewType) {
            1 -> {
                //ViewHolderItemA
                val viewHolderA = viewHolder as ViewHolderItemA
                //viewHolderA.tv_name.text = "Ini layout item a dengan position $position"
                viewHolderA.tv_name.text = main_RV_Model.name

                viewHolderA.tv_address.text = main_RV_Model.Address
            }
            2 -> {
                //ViewHolderItemB
                var viewHolderB = viewHolder as ViewHolderItemB
                //viewHolderB.imageView.setImageResource(main_RV_Model.image)

                Glide.with(viewHolderB.imageView.context)
                    .load(main_RV_Model.offerImage)
                    .into(viewHolderB.imageView)

            }
            else -> {
                //ViewHolderItemC
                var viewHolderC = viewHolder as ViewHolderItemC
                viewHolderC.tv_rv_child.text = main_RV_Model.name

                when (main_RV_Model.name) {
                    "Deals of the Day" ->
                        viewHolderC.rv_child.layoutManager = GridLayoutManager(viewHolderC.rv_child.context, 2)
                    "Shop By Category" ->
                        viewHolderC.rv_child.layoutManager = GridLayoutManager(viewHolderC.rv_child.context, 3)
                    "Best Offer" ->
                        viewHolderC.rv_child.layoutManager =
                                LinearLayoutManager(viewHolderC.rv_child.context, LinearLayout.VERTICAL, false)
                    else ->
                        viewHolderC.rv_child.layoutManager =
                                LinearLayoutManager(viewHolderC.rv_child.context, LinearLayout.HORIZONTAL, false)

                }
                viewHolderC.rv_child.addItemDecoration(DividerItemDecoration(viewHolderC.rv_child.context, 0))
                var childAdapter = ChildAdapter(main_RV_Model.children)
                viewHolderC.rv_child.adapter = childAdapter

                Glide.with(viewHolderC.iv_rv_offer.context)
                    .load(main_RV_Model.offerImage)
                    .into(viewHolderC.iv_rv_offer)


            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        //return super.getItemViewType(position)
        return model_liat[position].viewType
    }

    /*inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_name: TextView = itemView.tv_name
        var tv_address: TextView = itemView.tv_address
    }*/

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ViewHolderItemA(itemView: View) : ViewHolder(itemView) {
        var tv_name: TextView = itemView.findViewById(R.id.tv_name)
        var tv_address: TextView = itemView.tv_address
    }

    inner class ViewHolderItemB(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    inner class ViewHolderItemC(itemView: View) : ViewHolder(itemView) {
        var rv_child: RecyclerView = itemView.rv_child
        var tv_rv_child: TextView = itemView.tv_rv_child
        var iv_rv_offer: ImageView = itemView.iv_rv_offer
    }
}