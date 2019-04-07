package com.example.dietplan.ui

import com.example.dietplan.data.DataProvider
import com.example.dietplan.data.DataProviderImpl
import com.example.dietplan.data.Model.Response

class MainPresenter(val view: Contract.ViewContract) : Contract.PresenterContract {
    override fun getResponse() {

        DataProviderImpl().getList(object : DataProvider.Callback<Response> {
            override fun onFailure(message: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSuccess(response: Response?) {
                view.setDataForView(response!!)
            }

        })
    }


//    override fun getResponse() {
//        val jsonString = MockDataProvider().getMockResponse()
//
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()
//
//        val parse = gson.fromJson<Response>(jsonString, Response::class.java)
//        view.setDataForView(parse)
//    }
//
//


}