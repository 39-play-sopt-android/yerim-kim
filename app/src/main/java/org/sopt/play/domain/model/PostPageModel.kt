package org.sopt.play.domain.model

data class PostPageModel(
    val posts: List<PostModel>,
    val nextCursor: Long?,
    val hasNext: Boolean,
)
