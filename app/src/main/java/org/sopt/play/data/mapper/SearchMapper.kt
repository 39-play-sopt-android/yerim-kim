package org.sopt.play.data.mapper

import org.sopt.play.core.common.extension.toEpochMillis
import org.sopt.play.data.dto.response.PostResponse
import org.sopt.play.domain.model.PostModel

fun PostResponse.toModel(): PostModel =
    PostModel(
        postId = postId,
        title = title,
        content = content,
        author = author,
        createdAt = createdAt.toEpochMillis(),
        updatedAt = updatedAt.toEpochMillis(),
    )
