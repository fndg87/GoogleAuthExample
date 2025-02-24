package com.elasticrent.app.data.remote

import com.elasticrent.app.domain.model.ApiRequest
import com.elasticrent.app.domain.model.ApiResponse
import com.elasticrent.app.domain.model.UserUpdate
import retrofit2.http.*

interface GoogleAuthKtorAPI {
    @POST("/token_verification")
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ): ApiResponse

    @GET("/get_user")
    suspend fun getUserInfo(): ApiResponse

    @PUT("/update_user")
    suspend fun updateUser(
        @Body userUpdate: UserUpdate
    ): ApiResponse

    @DELETE("/delete_user")
    suspend fun deleteUser(): ApiResponse

    @GET("/sign_out")
    suspend fun clearSession(): ApiResponse
}