package com.example.dietplan.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dietplan.R
import com.example.dietplan.ScheduleAlarmThread
import com.example.dietplan.data.Model.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.ViewContract {

    private val TAG = MainActivity::class.java.canonicalName

    lateinit var recyclerView: RecyclerView
    lateinit var mealAdapterList: MealAdapterList

    override fun setDataForView(response: Response) {
        ScheduleAlarmThread(response).start()
        val weekDietData = response.week_diet_data
        val list = listOf(weekDietData.monday, weekDietData.wednesday, weekDietData.thursday).flatten()
        mealAdapterList.prepareNewsList(list)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        mealAdapterList = MealAdapterList()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = mealAdapterList
        }
        MainPresenter(this).getResponse()
    }
}
