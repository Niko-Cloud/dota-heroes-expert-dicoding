package com.dicoding.dotaheroesbase.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.dotaheroesbase.core.R
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import com.dicoding.dotaheroesbase.core.databinding.HeroItemBinding

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ListViewHolder>() {
    private var listData = ArrayList<Hero>()
    var onItemClick: ((Hero) -> Unit)? = null

    fun setData(newListData: List<Hero>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = HeroItemBinding.bind(itemView)
        fun bind(data: Hero) {
            with(binding) {
                tvItem.text = data.localizedName
                Glide.with(itemView.context)
                    .load("https://api.opendota.com${data.img}")
                    .into(ivItem)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }

        }
    }
}