package com.jimmy.dao

import com.jimmy.models.HomeDAO

interface HomeDAOFacade {
    suspend fun getHome(): HomeDAO
}