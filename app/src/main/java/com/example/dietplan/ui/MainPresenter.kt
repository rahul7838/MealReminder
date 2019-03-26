package com.example.dietplan.ui

import com.example.dietplan.data.MockDataProvider
import com.example.dietplan.data.Model.Response
import com.google.gson.GsonBuilder

class MainPresenter(val view: Contract.ViewContract) : Contract.PresenterContract {


    override fun getResponse() {
        val jsonString = MockDataProvider().getMockResponse()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val parse = gson.fromJson<Response>(jsonString, Response::class.java)
        view.setDataForView(parse)
    }


}