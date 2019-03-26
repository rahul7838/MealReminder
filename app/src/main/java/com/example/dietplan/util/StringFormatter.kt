package com.example.dietplan.util

fun formatString(string: String) : String {
    val i = string.indexOf(':')
    val subString = string.subSequence(0,i)
    return subString.toString()
}