package com.elasticrent.app.data.repository

import com.elasticrent.app.data.remote.GoogleAuthKtorAPI
import com.elasticrent.app.domain.model.ApiRequest
import com.elasticrent.app.domain.model.ApiResponse
import com.elasticrent.app.domain.model.UserUpdate
import com.elasticrent.app.domain.repository.DataStoreOperations
import com.elasticrent.app.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations:DataStoreOperations,
    private val googleAuthKtorAPI: GoogleAuthKtorAPI
): Repository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }


    override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            googleAuthKtorAPI.verifyTokenOnBackend(request = request)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun getUserInfo(): ApiResponse {
        return try {
            googleAuthKtorAPI.getUserInfo()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun updateUser(userUpdate: UserUpdate): ApiResponse {
        return try {
            googleAuthKtorAPI.updateUser(userUpdate = userUpdate)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun deleteUser(): ApiResponse {
        return try {
            googleAuthKtorAPI.deleteUser()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun clearSession(): ApiResponse {
        return try {
            googleAuthKtorAPI.clearSession()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }
}