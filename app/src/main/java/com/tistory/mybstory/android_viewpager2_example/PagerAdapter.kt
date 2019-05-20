package com.tistory.mybstory.android_viewpager2_example

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_page.view.*

class PagerAdapter : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    private val colorArray = ArrayList<Int>()

    init {
        addPage()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))

    override fun getItemCount(): Int = colorArray.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.itemView.run {
            setBackgroundColor(colorArray[position])
            tv_page_number.text = "Page $position"
        }
    }

    fun addPage() {
        val randomRed = (0..255).shuffled().first()
        val randomGreen = (0..255).shuffled().first()
        val randomBlue = (0..255).shuffled().first()

        colorArray.add(Color.rgb(randomRed, randomGreen, randomBlue))
        notifyDataSetChanged()
    }

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}