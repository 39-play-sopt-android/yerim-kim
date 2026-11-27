package org.sopt.play.data.remote

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.request.AuthorizationCodeRequest
import org.sopt.play.data.dto.response.AuthorizationCodeResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members/authorization-code")
    suspend fun getAuthorizationCode(
        @Body request: AuthorizationCodeRequest,
    ): BaseResponse<AuthorizationCodeResponse>
}
