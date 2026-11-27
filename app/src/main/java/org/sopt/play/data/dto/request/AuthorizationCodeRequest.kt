package org.sopt.play.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationCodeRequest(
    val part: String,
)
