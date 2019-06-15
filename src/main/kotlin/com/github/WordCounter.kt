package com.github

import java.io.File

class WordCounter {
    fun totalWordCount(fileName: String) = readFile(fileName).split(" ").size

    fun findWordCount(fileName: String, wordToSearch: String) =
            readFile(fileName).split(" ").filter { it == wordToSearch }.size

    private fun readFile(fileName: String) = File(javaClass.classLoader.getResource(fileName).file).readText()
}