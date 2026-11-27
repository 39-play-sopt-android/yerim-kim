package org.sopt.play.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("posts")
    val posts: List<PostResponse>,

    @SerialName("nextCursor")
    val nextCursor: Long?,

    @SerialName("hasNext")
    val hasNext: Boolean,
)

@Serializable
data class PostResponse(
    @SerialName("id")
    val postId: Long,

    @SerialName("title")
    val title: String,

    @SerialName("content")
    val content: String,

    @SerialName("author")
    val author: String,

    @SerialName("createdAt")
    val createdAt: String,

    @SerialName("updatedAt")
    val updatedAt: String,
)
