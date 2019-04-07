package com.example.dietplan.data

import com.example.dietplan.DietPlanApplication
import okhttp3.*

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return getResponse(chain)
    }

    fun getResponse(chain: Interceptor.Chain) : Response {
        return Response.Builder()
            .body(json())
            .request(chain.request())
            .code(200)
            .message("responseString")
            .protocol(Protocol.HTTP_1_0)
            .build()
    }

    private fun json(): ResponseBody? {
        val assetManager = DietPlanApplication.getAppContext().assets
        val inputStream = assetManager.open("response.json")
        return ResponseBody.create(MediaType.parse("application/json"), inputStream.reader().readText())
    }
}