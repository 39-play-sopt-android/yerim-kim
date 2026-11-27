package org.sopt.play.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationCodeResponse(
    val authorizationCode: String,
)