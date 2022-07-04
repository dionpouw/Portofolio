package com.jeflette.storyapps.ui.liststory.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeflette.storyapps.R
import com.jeflette.storyapps.data.remote.response.ListStoryItem

class ListStoryAdapter(private val data: List<ListStoryItem>) :
    RecyclerView.Adapter<ListStoryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivData: ImageView = itemView.findViewById(R.id.iv_image_item)
        val tvData: TextView = itemView.findViewById(R.id.tv_image_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            View.inflate(
                parent.context,
                R.layout.item_story,
                null
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data[position].photoUrl)
            .into(holder.ivData)
        holder.tvData.text = data[position].name
    }

    override fun getItemCount(): Int = data.size
}