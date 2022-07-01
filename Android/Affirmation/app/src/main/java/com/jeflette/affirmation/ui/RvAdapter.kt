package com.jeflette.affirmation.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jeflette.affirmation.R
import com.jeflette.affirmation.data.remote.response.NewResponse

class RvAdapter(private val data: List<NewResponse>) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.findViewById(R.id.tv_quotes_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = View.inflate(parent.context, R.layout.affirmation_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text = data[position].phrase
    }

    override fun getItemCount(): Int = data.size
}