package com.jimmy.models

import kotlinx.serialization.Serializable

@Serializable
data class HomeDAO(
    var exhibitions: List<ExhibitionDAO>,
    var genres: List<GenreDAO>,
    val boxOffices: List<BoxOfficeDAO>,
    val upcomingPerformances: List<SimplePerformanceDAO>
)
