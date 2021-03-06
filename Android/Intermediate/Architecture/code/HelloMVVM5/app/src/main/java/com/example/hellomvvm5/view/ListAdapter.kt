package com.example.hellomvvm5.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hellomvvm5.R
import com.example.hellomvvm5.model.CryptocurrencyModel


class ListAdapter(private val dataset: MutableMap<Int, CryptocurrencyModel>,
                  private val rowClicked: (CryptocurrencyModel) -> Unit) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_row, parent, false)
        return ListViewHolder(layout, rowClicked)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        dataset[position]?.let {
            holder.bindModel(it)
        }
    }

    override fun getItemCount(): Int {
        return dataset.count()
    }
}