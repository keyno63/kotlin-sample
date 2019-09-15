package com.github.keyno63.kotlin_sample.idiom

fun main(args: Array<String>) {
    val list = listOf("a", "b", "c")
    val newList = list.filter {
        it.startsWith("b")
    }
    println(newList)

}

