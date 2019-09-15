package com.github.keyno63.kotlin_sample.arrow

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse

// 動作確認用関数.
fun main(args: Array<String>) {

    // optionResult.
    val x = Optionals().optionResult
    when(x) {
        is Some -> println(x)
        is None -> println("nothing to print, value is None.")
        else -> println("invalid type")
    }

    // whenResult
    println(Optionals().whenResult)

    // foldResult
    println(Optionals().foldResult)

    // mapResult
    println(Optionals().mapResult)

}

class Optionals {
    fun stringDouble(src: String) = src + src

    private var someValue: Int = 0
    fun sometimeReturnNull(): String? {
        //someValue += 1
        return if (someValue % 2 == 0) "Something." else null
    }

    fun sometimeReturnNone(src: String): Option<String> = Option(src)

    val optionResult: Option<String> = Option.fromNullable(sometimeReturnNull())

    val whenResult: String = when (optionResult) {
        None -> "default value"
        is Some -> optionResult.t
    }

    val foldResult: String = optionResult.fold(
        ifEmpty = { "default value" },
        ifSome = { it }
    )

    val getOrElseResult: String = optionResult.getOrElse { "default value" }

    val mapResult: Option<String> = optionResult.map(::stringDouble)

    val flatMapResult: Option<String> = optionResult.flatMap(::sometimeReturnNone)
}