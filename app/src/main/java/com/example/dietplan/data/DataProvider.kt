package com.example.dietplan.data

import com.example.dietplan.data.Model.Response

interface DataProvider {

    fun getList(callback: Callback<Response>)


    interface Callback<T> {

        fun onSuccess(response: T?)

        fun onFailure(message: String?)
    }
}