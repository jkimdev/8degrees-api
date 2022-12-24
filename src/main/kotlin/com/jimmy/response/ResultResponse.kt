package com.jimmy.response

import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse<T>(
    val code: Int,
    val result: List<T>
    )

@Serializable
data class HomeResultResponse<T> (
    var code: Int,
    var result: T
    )