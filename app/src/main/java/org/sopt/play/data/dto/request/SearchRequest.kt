package org.sopt.play.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class SearchRequest(
    val title: String,
    val content: String,
    val author: String,
)
