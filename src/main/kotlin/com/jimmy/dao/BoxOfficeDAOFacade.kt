package com.jimmy.dao

import com.jimmy.models.BoxOfficeDAO

interface BoxOfficeDAOFacade {
    suspend fun allBoxOffices(): List<BoxOfficeDAO>
}