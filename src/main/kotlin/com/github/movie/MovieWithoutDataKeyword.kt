package com.github.movie

import java.time.LocalDate

class MovieWithoutDataKeyword(
        val imdbID: String,
        val title: String,
        val releaseDate: LocalDate,
        val genres: List<Genre>,
        val director: String,
        val actors: List<String>,
        val actresses: List<String>,
        val duration: Int
) {
    operator fun component1(): String {
        return imdbID
    }


    operator fun component2(): String {
        return title
    }

    override fun toString(): String {
        return title
    }

    fun matchesYear(year: Int) = releaseDate.year == year

    fun areAllActorsPresent(actors: List<String>) = this.actors.containsAll(actors)

    fun areAllActressesPresent(actresses: List<String>) = this.actresses.containsAll(actresses)

    operator fun compareTo(movie: Movie): Int {
        return this.duration - movie.duration
    }
}