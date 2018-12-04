package com.rasanbazar

import android.content.Intent
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_item_buy.view.*


class ChildAdapter(private val children: List<ChildModel>, private val viewType: Int) :
    RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_buy, parent, false)
        return ViewHolder(v)*/
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> ViewHolderItemA(inflater.inflate(R.layout.layout_item_buy, null))
            else -> ViewHolderItemB(inflater.inflate(R.layout.layout_view_item, null))
        }
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        //holder.imageView.setImageResource(child.image)
        when (viewType) {
            1 -> {
                val viewHolderA = holder as ChildAdapter.ViewHolderItemA
                Glide.with(viewHolderA.iv_buy_item.context)
                    .load(child.productImage)
                    .into(viewHolderA.iv_buy_item)
                viewHolderA.tv_buy_item_Name.text = child.title
                // viewHolderA.tv_buy_item_dprice.text = child.title
                viewHolderA.tv_buy_item_dprice.paintFlags = viewHolderA.tv_buy_item_dprice.paintFlags or
                        Paint.STRIKE_THRU_TEXT_FLAG

                viewHolderA.tv_iIncrement.setOnClickListener {

                    var yy = viewHolderA.tv_nQuntity.text.toString()

                    viewHolderA.tv_nQuntity.text = (yy.toInt() + 1).toString()
                }
                viewHolderA.tv_iDecrement.setOnClickListener {
                    var yy = viewHolderA.tv_nQuntity.text.toString()

                    viewHolderA.tv_nQuntity.text = (yy.toInt() - 1).toString()
                }

                holder.itemView.setOnClickListener {
                    //mListener.invoke(item) // <- item instance of ItemObject
                    //  Toast.makeText(holder.itemView.context, "assate", Toast.LENGTH_SHORT).show()
                    val intent = Intent(holder.itemView.context, ItemDescriptionActivity::class.java)
                    intent.putExtra("imageUrl", child.productImage)
                    intent.putExtra("productName", child.title)
                    intent.putExtra("productDescription", "")
                    holder.itemView.context.startActivity(intent)

                }
            }
            else -> {
                val viewHolderB = holder as ChildAdapter.ViewHolderItemB
                Glide.with(viewHolderB.child_imageView.context)
                    .load(child.productImage)
                    .into(viewHolderB.child_imageView)
                viewHolderB.child_textView.text = child.title
                holder.itemView.setOnClickListener {
                    //mListener.invoke(item) // <- item instance of ItemObject
                    //  Toast.makeText(holder.itemView.context, "assate", Toast.LENGTH_SHORT).show()
                    val intent = Intent(holder.itemView.context, ViewAllProductActivity::class.java)
                    intent.putExtra("imageUrl", child.productImage)
                    intent.putExtra("productName", child.title)
                    intent.putExtra("productDescription", "")
                    holder.itemView.context.startActivity(intent)

                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        //return super.getItemViewType(position)
        return viewType
    }


    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ViewHolderItemA(itemView: View) : ViewHolder(itemView) {
        val iv_buy_item: ImageView = itemView.iv_buy_item
        val tv_buy_item_Name: TextView = itemView.tv_buy_item_Name
        val tv_buy_item_dprice: TextView = itemView.tv_buy_item_dprice
        val tv_nQuntity: TextView = itemView.tv_nQuntity
        val tv_iIncrement: TextView = itemView.tv_iIncrement
        val tv_iDecrement: TextView = itemView.tv_iDecrement
    }


    inner class ViewHolderItemB(itemView: View) : ViewHolder(itemView) {
        var child_imageView: ImageView = itemView.findViewById(R.id.child_imageView)
        var child_textView: TextView = itemView.findViewById(R.id.child_textView)
    }

}