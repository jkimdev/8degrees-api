package com.jimmy.models

import kotlinx.serialization.Serializable

@Serializable
data class HomeDAO(
    var genres: List<GenreDAO>,
    val boxOffices: List<BoxOfficeDAO>,
    val upcomingPerformances: List<SimplePerformanceDAO>
)
