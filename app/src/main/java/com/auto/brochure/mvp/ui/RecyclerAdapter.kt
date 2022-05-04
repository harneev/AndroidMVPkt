package com.auto.brochure.mvp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.auto.brochure.mvp.R

class RecyclerAdapter<T>(
    private val displayList: List<T>,
    private val bindingInterface: GenericRecyclerBindingInterface<T>
) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(displayList[position], bindingInterface)
    }

    override fun getItemCount(): Int = displayList.size

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view as TextView

        fun <T> bind(item: T, bindingInterface: GenericRecyclerBindingInterface<T>) =
            bindingInterface.bindData(item, textView)
    }
}

interface GenericRecyclerBindingInterface<Model> {

    fun bindData(item: Model, textView: TextView)
}