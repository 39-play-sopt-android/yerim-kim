package org.sopt.play.domain.repository

import org.sopt.play.domain.model.PostPageModel

interface SearchRepository {
    suspend fun getPosts(): Result<PostPageModel>

    suspend fun createPost(
        authorizationCode: String,
        title: String,
        content: String,
        author: String,
    ): Result<Unit>

    suspend fun deletePost(
        authorizationCode: String,
        postId: Long,
    ):Result<Unit>
}
