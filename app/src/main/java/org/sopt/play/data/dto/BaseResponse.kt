package org.sopt.play.data.dto.base

import kotlinx.serialization.SerialName

data class BaseResponse<T>(
    @SerialName("isSuccess")
    val isSuccess: Boolean,

    @SerialName("code")
    val code: String,

    @SerialName("message")
    val message: String,

    @SerialName("data")
    val data: T,
)
