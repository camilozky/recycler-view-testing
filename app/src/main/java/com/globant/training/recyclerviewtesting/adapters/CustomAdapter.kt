package com.globant.training.recyclerviewtesting.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globant.training.recyclerviewtesting.R
import com.globant.training.recyclerviewtesting.model.Item
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.collections.ArrayList



/**
 * CustomAdapter digest the data of items to show into the recycler view
 * <p>
 *
 * @author david.mazo
 */

class CustomAdapter(val itemList: ArrayList<Item>, val listener: AdapterEvents?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(itemList[position])
        holder.bindListener(listener)
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var item: Item

        fun bindItems(item: Item) {
            this.item = item
            val resourceId = itemView.context.resources.getIdentifier(item.image, "drawable", itemView.context.packageName)
            itemView.img.setImageResource(resourceId)
            itemView.title.text = item.title
            itemView.subTitle.text = item.subTitle
        }

        fun bindListener(listener: AdapterEvents?) {
            view.setOnClickListener {
                listener?.onItemClicked(this.item)
            }
        }
    }

    interface AdapterEvents {
        fun onItemClicked(item: Item)
    }
}
