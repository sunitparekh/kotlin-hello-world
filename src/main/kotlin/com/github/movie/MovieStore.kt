package com.github.movie

class MovieStore private constructor(val movies: List<Movie>) {
    fun findMoviesOfGivenYear(releaseYear: Int) = movies.filter { it.matchesYear(releaseYear) }

    fun findMovies(duration: Int) = movies.filter { it.isDurationGreaterThanGiven(duration) }

    fun findMoviesOfGivenActors(actors: List<String>) = movies.filter { it.areAllActorsPresent(actors) }

    fun findMoviesOfGivenActresses(actresses: List<String>) = movies.filter { it.areAllActressesPresent(actresses) }

    fun hasMovie(movie: Movie): Boolean {
        return movie in movies
    }

    companion object Factory {
        fun create(movies: List<Movie>): MovieStore {
            return MovieStore(movies)
        }
    }
}