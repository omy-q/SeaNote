package com.example.seanote.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class SeaNoteBaseRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: MutableList<T> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        getViewHolder()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? SeaNoteViewHolderBinder<T>)?.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int = getType()

    override fun getItemCount(): Int = data.size

    abstract fun getViewHolder(): RecyclerView.ViewHolder

    abstract fun getType(): Int

    fun addAllData(data: List<T>) {
        this.data.addAll(data)
    }

    fun addData(data: T) {
        this.data.add(data)
    }

    fun updateData(data: List<T>) {
        this.data = data.toMutableList()
    }
}