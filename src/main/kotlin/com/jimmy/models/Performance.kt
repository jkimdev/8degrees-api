package com.jimmy.models

@kotlinx.serialization.Serializable
data class Performance(val mt20id: String, val prfnm: String)

val PerformanceStorage = mutableListOf<Performance>()


