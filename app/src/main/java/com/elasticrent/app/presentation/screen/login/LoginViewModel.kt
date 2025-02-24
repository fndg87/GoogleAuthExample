package com.elasticrent.app.presentation.screen.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elasticrent.app.domain.model.ApiRequest
import com.elasticrent.app.domain.model.ApiResponse
import com.elasticrent.app.domain.model.MessageBarState
import com.elasticrent.app.domain.repository.Repository
import com.elasticrent.app.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _signInState : MutableState<Boolean> = mutableStateOf(false)
    val signedInState:State<Boolean> = _signInState
    private val _messageBarState : MutableState<MessageBarState> = mutableStateOf(MessageBarState())
    val messageBarState:State<MessageBarState> = _messageBarState
    private val _apiResponse: MutableState<RequestState<ApiResponse>> =
        mutableStateOf(RequestState.Idle)
    val apiResponse: State<RequestState<ApiResponse>> = _apiResponse

    init {
        viewModelScope.launch {
            repository.readSignedInState().collect {
                _signInState.value = it
            }
        }
    }
    fun saveSignedInState(signedIn:Boolean){
        viewModelScope.launch(Dispatchers.IO){
            repository.saveSignedInState(signedIn=signedIn)
        }
    }

    fun updateMessageBarState() {
        _messageBarState.value = MessageBarState(
            error = GoogleAccountNotFoundException()
        )
    }

    fun verifyTokenOnBackend(request: ApiRequest) {
        Log.d("LoginViewModel", request.tokenId)
        _apiResponse.value = RequestState.Loading
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = repository.verifyTokenOnBackend(request = request)
                _apiResponse.value = RequestState.Success(response)
                _messageBarState.value = MessageBarState(
                    message = response.message,
                    error = response.error
                )
            }
        } catch (e: Exception) {
            _apiResponse.value = RequestState.Error(e)
            _messageBarState.value = MessageBarState(error = e)
        }
    }


}

class GoogleAccountNotFoundException(
    override val message: String? = "Google Account Not Found."
) : Exception()