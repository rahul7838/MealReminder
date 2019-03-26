package com.example.dietplan

import android.app.Application
import android.content.Context

class DietPlanApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {

        lateinit var context: Context

        fun getAppContext() : Context {
            return context
        }
    }


}