package com.globant.training.recyclerviewtesting

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.globant.training.recyclerviewtesting.adapters.CustomAdapter
import com.globant.training.recyclerviewtesting.model.Item
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity(), CustomAdapter.AdapterEvents {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val items = ArrayList<Item>()
        items.add(Item(1,"RecyclerViewTesting1","subTitle RecyclerViewTesting","about_me_icon"))
        items.add(Item(2,"RecyclerViewTesting2","subTitle RecyclerViewTesting","dice_roller_icon"))
        items.add(Item(3,"RecyclerViewTesting3","subTitle RecyclerViewTesting","about_me_icon"))
        items.add(Item(4,"RecyclerViewTesting4","subTitle RecyclerViewTesting","dice_roller_icon"))
        items.add(Item(5,"RecyclerViewTesting5","subTitle RecyclerViewTesting","about_me_icon"))
        val adapter = CustomAdapter(items, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(item: Item) {
        Log.d("#040","elemento  $(item.id)"+item.id)
    }
}
