package com.jimmy.dao

import com.jimmy.models.BoxOfficeDAO
import com.jimmy.models.SingleBoxOfficeDAO

interface BoxOfficeDAOFacade {
    suspend fun top10BoxOffices(): List<BoxOfficeDAO>
    suspend fun findBoxOfficeById(id: String): List<SingleBoxOfficeDAO>
}