package com.github.keyno63.kotlin_sample.arrow

fun main(args: Array<String>) {

    // case of non-null-type String.
    val sample = "sample"
    println(sample.length)

    // case of null-type String.
    val nullables: String? = null
    // must check null or not.
    println(if (nullables != null) nullables.length else 0)


}