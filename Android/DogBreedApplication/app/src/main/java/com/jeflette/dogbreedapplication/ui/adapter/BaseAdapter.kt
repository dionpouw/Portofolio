package com.jeflette.dogbreedapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeflette.dogbreedapplication.R
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import com.jeflette.dogbreedapplication.databinding.DogitemBinding
import com.jeflette.dogbreedapplication.ui.dogfavorite.DogFavoriteFragmentDirections
import com.jeflette.dogbreedapplication.ui.doglist.DogListFragmentDirections

class BaseAdapter : RecyclerView.Adapter<BaseAdapter.ViewHolder>() {

    private val items = mutableListOf<Breed>()

    fun setItem(items: List<Breed>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val itemBinding: DogitemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Breed) {
            Glide.with(itemBinding.root)
                .load(item.image?.url)
                .error(R.drawable.ic_launcher_background)
                .into(itemBinding.itemImage)
            itemBinding.itemName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = DogitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            val actionFromList =
                DogListFragmentDirections.actionDogListFragmentToDogDetailFragment(items[position])
            val actionFromFavorite =
                DogFavoriteFragmentDirections.actionDogFavoriteFragmentToDogDetailFragment(items[position])

            findNavController(it).currentDestination?.id?.let { id ->
                when (id) {
                    R.id.dogListFragment -> findNavController(it).navigate(actionFromList)
                    R.id.dogFavoriteFragment -> findNavController(it).navigate(actionFromFavorite)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}