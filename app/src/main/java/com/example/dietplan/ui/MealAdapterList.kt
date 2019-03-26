package com.example.dietplan.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dietplan.R
import com.example.dietplan.data.Model.Monday
import com.example.dietplan.data.Model.Thursday
import com.example.dietplan.data.Model.Wednesday
import com.example.dietplan.data.Model.WeekDays

class MealAdapterList : RecyclerView.Adapter<MealAdapterList.MealViewHolder>() {

    var list: MutableList<WeekDays> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_view, parent, false)
        return MealViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val day = list[position]
        when(day){
            is Monday -> {
                holder.dishName.text = day.food
                holder.dishDay.text = "Monday@${day.meal_time}"
            }
            is Wednesday -> {
                holder.dishName.text = day.food
                holder.dishDay.text = "Wednesday@${day.meal_time}"
            }
            is Thursday -> {
                holder.dishName.text = day.food
                holder.dishDay.text = "Thursday@${day.meal_time}"
            }
        }
    }

    fun prepareNewsList(newList: List<WeekDays>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dishName = itemView.findViewById<TextView>(R.id.textView1)
        val dishDay = itemView.findViewById<TextView>(R.id.textView2)

    }

}

