package org.sopt.play.domain.repository

import org.sopt.play.domain.model.PostPageModel

interface SearchRepository {
    suspend fun getPosts(): Result<PostPageModel>
}
