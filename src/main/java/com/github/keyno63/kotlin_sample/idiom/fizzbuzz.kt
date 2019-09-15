package com.github.keyno63.kotlin_sample.idiom

fun main(args: Array<String>) {
    val range = 0..100
    for (v in range) {
        when {
            v % 15 == 0 -> println("FizzBuzz")
            v % 3 == 0 -> println("Fizz")
            v % 5 == 0 -> println("Buzz")
            else -> println(v)
        }
    }
}