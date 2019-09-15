package com.github.keyno63.kotlin_sample.arrow

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse

fun stringDouble(src: String) = src + src

fun sometimeReturnNull(): String? = TODO()

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