package org.sopt.play.data.repository

import org.sopt.play.core.common.util.suspendRunCatching
import org.sopt.play.data.dto.request.SearchRequest
import org.sopt.play.data.mapper.toModel
import org.sopt.play.data.remote.SearchService
import org.sopt.play.domain.model.PostPageModel
import org.sopt.play.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val service: SearchService,
) : SearchRepository {
    override suspend fun getPosts(): Result<PostPageModel> =
        suspendRunCatching {
            val response = service.getPosts()
            val data = requireNotNull(response.data) { "data is null" }

            PostPageModel(
                posts = data.posts.map { it.toModel() },
                nextCursor = data.nextCursor,
                hasNext = data.hasNext,
            )
        }

    override suspend fun createPost(
        authorizationCode: String,
        title: String,
        content: String,
        author: String,
    ): Result<Unit> = suspendRunCatching {
        service.createPost(
            authorizationCode = authorizationCode,
            request = SearchRequest(
                title = title,
                content = content,
                author = author,
            ),
        )
    }
}
