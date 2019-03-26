package com.example.dietplan.data

import com.example.dietplan.DietPlanApplication
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MockDataProvider {

    private val context = DietPlanApplication.context

    fun getMockResponse() : String {

        val stream = context.assets.open("response.json")

        val jsonString = readFile(stream)

        return jsonString
    }


    private fun readFile(stream: InputStream) : String {

        val stringBuilder = StringBuilder()

        val bufferedReader = BufferedReader(InputStreamReader(stream))

        var line = bufferedReader.readLine()

        while (line != null){
            stringBuilder.append(line)
            line = bufferedReader.readLine()
        }
        bufferedReader.close()

        return stringBuilder.toString()
    }
}

