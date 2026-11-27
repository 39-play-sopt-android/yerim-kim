package org.sopt.play.data.remote

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.request.SearchRequest
import org.sopt.play.data.dto.response.SearchResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SearchService {
    @GET("api/v1/posts")
    suspend fun getPosts(): BaseResponse<SearchResponse>

    @POST("api/v1/posts")
    suspend fun createPost(
        @Header("Authorization") authorizationCode: String,
        @Body request: SearchRequest,
    ): BaseResponse<Unit>
}
