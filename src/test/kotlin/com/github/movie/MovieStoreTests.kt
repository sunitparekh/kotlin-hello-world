package com.github.movie

import io.kotlintest.matchers.collections.shouldContainInOrder
import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.time.LocalDate

class MovieStoreTests : StringSpec() {

    init {
        val movieStore = MovieStore.create(getDummyMovies())
        "movies list size with duraction greater than given"{
            movieStore.findMovies(130) shouldHaveSize 3
        }

        "movies list size should be equal to all movies size"{
            movieStore.findMoviesOfGivenYear(2019) shouldHaveSize movieStore.movies.size
        }

        "test if a movie is present in list"{
            val movie = Movie("1", "Avengers", LocalDate.now(), listOf(Genre.Anthology, Genre.Classic), "Marvel",
                    listOf("Iron Man", "Captain America"), listOf("Natasha", "Captain Marvel"), 150)

            movieStore.hasMovie(movie) shouldBe true
        }

        "movie should contain given actor name"{
            val movie = Movie("1", "Avengers", LocalDate.now(), listOf(Genre.Anthology, Genre.Classic), "Marvel",
                    listOf("Iron Man", "Captain America"), listOf("Natasha", "Captain Marvel"), 150)
            val results = listOf<Movie>(movie)

            movieStore.findMoviesOfGivenActors(listOf("Captain America")) shouldBe results
        }

        "movie should contain given actresses name"{
            val results = ArrayList<Movie>()

            results.add(Movie("2", "Conjuring", LocalDate.now(), listOf(Genre.Anthology, Genre.Comic), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 120))
            results.add(Movie("3", "Iron Man", LocalDate.now(), listOf(Genre.Drama, Genre.Classic), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 180))
            results.add(Movie("4", "Spiderman", LocalDate.now(), listOf(Genre.Crime, Genre.FairyTale), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 100))
            results.add(Movie("5", "Captain Marvel", LocalDate.now(), listOf(Genre.Horror, Genre.Classic), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 140))


            movieStore.findMoviesOfGivenActresses(listOf("Allie")) shouldBe results
        }

        "movie should be sorted by duration in ascending order"{

            val expectedSortedResults = ArrayList<Movie>()
            expectedSortedResults.add(Movie("4", "Spiderman", LocalDate.now(), listOf(Genre.Crime, Genre.FairyTale), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 100))
            expectedSortedResults.add(Movie("2", "Conjuring", LocalDate.now(), listOf(Genre.Anthology, Genre.Comic), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 120))
            expectedSortedResults.add(Movie("5", "Captain Marvel", LocalDate.now(), listOf(Genre.Horror, Genre.Classic), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 140))
            expectedSortedResults.add(Movie("3", "Iron Man", LocalDate.now(), listOf(Genre.Drama, Genre.Classic), "Darshan",
                    listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 180))

            val comparator = object : Comparator<Movie> {
                override fun compare(movie1: Movie, movie2: Movie): Int {
                    return if (movie1 > movie2) 1 else -1
                }
            }

            val sortedMovies = movieStore.movies.sortedWith(comparator)
            sortedMovies shouldContainInOrder expectedSortedResults
        }
    }

    private fun getDummyMovies(): ArrayList<Movie> {
        val listMovies = ArrayList<Movie>()

        listMovies.add(Movie("1", "Avengers", LocalDate.now(), listOf(Genre.Anthology, Genre.Classic), "Marvel",
                listOf("Iron Man", "Captain America"), listOf("Natasha", "Captain Marvel"), 150))
        listMovies.add(Movie("2", "Conjuring", LocalDate.now(), listOf(Genre.Anthology, Genre.Comic), "Darshan",
                listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 120))
        listMovies.add(Movie("3", "Iron Man", LocalDate.now(), listOf(Genre.Drama, Genre.Classic), "Darshan",
                listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 180))
        listMovies.add(Movie("4", "Spiderman", LocalDate.now(), listOf(Genre.Crime, Genre.FairyTale), "Darshan",
                listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 100))
        listMovies.add(Movie("5", "Captain Marvel", LocalDate.now(), listOf(Genre.Horror, Genre.Classic), "Darshan",
                listOf("Iron Man", "Actor name 1"), listOf("Natasha", "Allie"), 140))
        return listMovies
    }
}