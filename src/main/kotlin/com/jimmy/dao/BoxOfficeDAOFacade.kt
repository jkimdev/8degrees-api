package com.jimmy.dao

import com.jimmy.models.BoxOfficeDAO

interface BoxOfficeDAOFacade {
    suspend fun top10BoxOffices(): List<BoxOfficeDAO>
}