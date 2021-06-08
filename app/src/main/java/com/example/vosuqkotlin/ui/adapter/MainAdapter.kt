package com.example.vosuqkotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vosuqkotlin.R
import com.example.vosuqkotlin.data.model.Item
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter (
    private val items: ArrayList<Item>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) {
            itemView.textViewSymbolDate.text = item.symbol
            itemView.textViewBaseCurrencyShortNameData.text = item.baseCurrencyShortName
            itemView.textViewQuoteCurrencyShortNameData.text = item.quoteCurrencyShortName
            itemView.textViewQuantityIncrementData.text = item.quantityIncrement.toString()
            itemView.textViewTickSizeData.text = item.tickSize.toString()
            itemView.textViewTakeLiquidityRateData.text = item.takeLiquidityRate.toString()
            itemView.textViewProvideLiquidityRateData.text = item.provideLiquidityRate.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items[position])
        val context = holder.itemView.context
        setBackgroundColor(holder, items[position], context)
    }
    fun addData(list: List<Item>) {
        items.addAll(list)
    }
    fun setBackgroundColor(holder: DataViewHolder,item :Item, context: Context){
        val colorOff = ContextCompat.getColor(context, R.color._E8E8E8)
        val colorOn = ContextCompat.getColor(context, R.color._FFFFFF)
        when (item.feeSide) {
            0 -> holder.itemView.container.setBackgroundColor(colorOff)
            1 -> holder.itemView.container.setBackgroundColor(colorOn)
        }
    }

}