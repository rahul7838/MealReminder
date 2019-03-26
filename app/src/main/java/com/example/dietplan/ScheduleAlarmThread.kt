package com.example.dietplan

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.dietplan.data.Model.*
import com.example.dietplan.util.formatString
import java.util.*

class ScheduleAlarmThread(val response: Response) : Thread() {

    private val TAG = ScheduleAlarmThread::class.java.canonicalName

    override fun run() {

        Log.i(TAG, response.diet_duration.toString())
        val mondayMealList = response.week_diet_data.monday
        val wednesdayMealList = response.week_diet_data.wednesday
        val thursdayMealList = response.week_diet_data.thursday

        val mondayMealNumber = mondayMealList.size
        val wednesdayMealNumber = wednesdayMealList.size
        val thursdayMealNumber = thursdayMealList.size

        setMealReminder(mondayMealList, mondayMealNumber)
        setMealReminder(wednesdayMealList, wednesdayMealNumber)
        setMealReminder(thursdayMealList, thursdayMealNumber)
    }

    private fun <T : WeekDays> setMealReminder(mealList: List<T>, mealNumber: Int) {

        for (i in 0 until mealNumber - 1) {
            val day = mealList[i]
            when (day) {
                is Monday -> {
                    setAlarm(eatingTime = getMealTime(day.meal_time, Calendar.MONDAY), foodName = day.food)
                }
                is Wednesday -> {
                    setAlarm(eatingTime = getMealTime(day.meal_time, Calendar.WEDNESDAY), foodName = day.food)
                }
                is Thursday -> {
                    setAlarm(eatingTime = getMealTime(day.meal_time, Calendar.THURSDAY), foodName = day.food)
                }
            }
        }
    }

    private fun setAlarm(eatingTime: Long, foodName: String) {
        val context = DietPlanApplication.getAppContext()
        val intent = Intent(context, DietBroadcastReceiver::class.java)
        intent.putExtra("foodName", foodName)
        val pendingIntent = PendingIntent.getBroadcast(context, 12, intent, PendingIntent.FLAG_ONE_SHOT)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, eatingTime, pendingIntent)

    }

    private fun getMealTime(eatingTime: String, day: Int): Long {
        val calendar = Calendar.getInstance()
        val formattedString = formatString(eatingTime)
        calendar.apply {
            set(Calendar.HOUR_OF_DAY, Integer.parseInt(formattedString) - 1)
            set(Calendar.SECOND, 0)
            set(Calendar.MINUTE, 55)
            set(Calendar.DAY_OF_WEEK, day)
        }
        val time = calendar.timeInMillis
        return time
    }

}