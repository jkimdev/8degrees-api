package com.jimmy.dao

import com.jimmy.models.GenreDAO

interface GenreDAOFacade {
    suspend fun allGenres(): List<GenreDAO>
}