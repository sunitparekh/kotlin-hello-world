package com.github

import com.github.movie.Genre
import com.github.movie.MovieWithoutDataKeyword
import java.time.LocalDate


fun main(args: Array<String>) {

    // Word Counter Testing
    val wordCounter = WordCounter()
    val totalWords = wordCounter.totalWordCount("word-count.txt")
    println("Total words = $totalWords")

    val countOfGivenWord = wordCounter.findWordCount("word-count.txt", "left")
    println("Given word count = $countOfGivenWord")


    // Destructuring of data class
//    val (imdbId) = Movie("5", "Captain Marvel", LocalDate.now(), listOf(Genre.Horror, Genre.Classic), "Darshan",
//            listOf<String>("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 140)
//    println(imdbId)

    // Destructuring of non-data class
    val (imdbId, title) = MovieWithoutDataKeyword("5", "Captain Marvel", LocalDate.now(), listOf(Genre.Horror, Genre.Classic), "Darshan",
            listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 140)
    println("IMBD ID: $imdbId title: $title")
}