package com.github.movie

import java.time.LocalDate

enum class Genre {
    Anthology,
    Classic,
    Comic,
    Crime,
    Drama,
    FairyTale,
    Horror
}

data class Movie(
        val imdbID: String,
        val title: String,
        val releaseDate: LocalDate,
        val genres: List<Genre>,
        val director: String,
        val actors: List<String>,
        val actresses: List<String>,
        val duration: Int
) {
    override fun toString(): String {
        return title
    }

    fun isDurationGreaterThanGiven(duration: Int) = this.duration > duration

    fun matchesYear(year: Int) = releaseDate.year == year

    fun areAllActorsPresent(actors: List<String>) = this.actors.containsAll(actors)

    fun areAllActressesPresent(actresses: List<String>) = this.actresses.containsAll(actresses)

    operator fun compareTo(movie: Movie): Int {
        return this.duration - movie.duration
    }
}