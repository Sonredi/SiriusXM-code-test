package com.example.jcp.siriusxmtest.ui.card

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jcp.siriusxmtest.data.entities.Item
import com.example.jcp.siriusxmtest.databinding.ItemCardBinding

/**
 * Created by jacp on 5/23/2018.
 */
class CardAdapter(private val listCards: MutableList<Item>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val cardViewModel = listCards[position]
        holder?.bind(cardViewModel)
    }

    override fun getItemCount(): Int {
        return listCards.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val itemBinding: ItemCardBinding = ItemCardBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    class ViewHolder(private val itemBinding: ItemCardBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Item) {
            itemBinding.viewModel = CardViewModel.of(item)
            itemBinding.executePendingBindings()
        }
    }

    fun updateItems(cards: List<Item>) {
        listCards.clear()
        listCards.addAll(cards)
        notifyDataSetChanged()
    }
}