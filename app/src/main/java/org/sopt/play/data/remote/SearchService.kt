package org.sopt.play.data.remote

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.response.SearchResponse
import retrofit2.http.GET

interface SearchService {
    @GET("api/v1/posts")
    suspend fun getPosts(): BaseResponse<SearchResponse>
}
