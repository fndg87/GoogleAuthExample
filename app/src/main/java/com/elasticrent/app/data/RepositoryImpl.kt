package com.elasticrent.app.data

import com.elasticrent.app.domain.repository.DataStoreOperations
import com.elasticrent.app.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations:DataStoreOperations
): Repository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }
}