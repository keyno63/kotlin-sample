package com.github.keyno63.kotlin_sample.idiom

import java.io.File

fun main(args: Array<String>) {
    val fileHere: Array<File>  = File(".").listFiles()
    //fileHere.forEach { println(it) }
    val a = FileMatcher.fileEnding(fileHere, "txt")
    println("fileEnding: $a")
    val b = FileMatcher.fileContaining(fileHere, "idea")
    println("fileContaining: $b")
}

object FileMatcher {
    private fun fileMatching(files: Array<java.io.File>, matcher: (String) -> Boolean): List<File> {
        return files.filter{
                x -> matcher(x.name)
        }
    }

    // fileEnding
    fun fileEnding(files: Array<java.io.File>, query: String): List<File> {
        return fileMatching(files, {x: String -> x.endsWith(query)})
    }
    // fileContaining
    fun fileContaining(files: Array<File>, query: String): List<File> {
        return fileMatching(files, {x: String  -> x.contains(query)})
    }
    // fileRegex
    /*
    fun fileRegex(files: Array<java.io.File>, query: String): List<File> {
        return fileMatching(files, {x: String -> x.matches(query)})
    }
    */
}