package com.globant.training.recyclerviewtesting

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.globant.training.recyclerviewtesting.adapters.CustomAdapter
import com.globant.training.recyclerviewtesting.adapters.AdapterEvents
import com.globant.training.recyclerviewtesting.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CustomAdapter.AdapterEvents {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val items = ArrayList<Item>()
        items.add(Item(1,"Monda","vaya a comer monda Perro hp1","about_me_icon"))
        items.add(Item(2,"Monda1","vaya a comer monda Perro hp2","dice_roller_icon"))
        items.add(Item(3,"Monda2","vaya a comer monda Perro hp3","about_me_icon"))
        items.add(Item(4,"Monda3","vaya a comer monda Perro hp4","dice_roller_icon"))
        items.add(Item(5,"Monda4","vaya a comer monda Perro hp5","about_me_icon"))
        val adapter = CustomAdapter(items, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(item: Item) {
        Log.d("#040","elemento  $(item.id)"+item.id)
    }



}
