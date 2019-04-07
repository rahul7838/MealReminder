package com.example.dietplan.data

import android.util.Log
import com.example.dietplan.data.Model.Response
import retrofit2.Call
import retrofit2.Callback

class DataProviderImpl : DataProvider {


    private val TAG: String? = DataProviderImpl::class.java.canonicalName

    override fun getList(callback: DataProvider.Callback<Response>) {
        ServiceApiRepository().getRetofit().create(ServiceApiCall::class.java)
            .userList.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.i(TAG, "onFailure")
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                }
                Log.i(TAG, "Successful")
            }

        })

    }

}

