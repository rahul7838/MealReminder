package com.example.dietplan.ui

import com.example.dietplan.data.Model.Response

interface Contract {

    interface PresenterContract {
        fun getResponse()
    }

    interface ViewContract {
        fun setDataForView(response: Response)
    }
}