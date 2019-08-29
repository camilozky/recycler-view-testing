package com.globant.training.recyclerviewtesting.adapters

import com.globant.training.recyclerviewtesting.model.Item

interface AdapterEvents {
    fun onItemClicked(item: Item)
}