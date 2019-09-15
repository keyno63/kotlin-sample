package com.github.keyno63.kotlin_sample.arrow

fun main(args: Array<String>) {
    val nullables: String? = null
    println(if (nullables != null) nullables.length else 0)

    val sample = "sample"
    println(sample.length)
}