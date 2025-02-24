package com.elasticrent.app.presentation.screen.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elasticrent.app.domain.model.MessageBarState
import com.elasticrent.app.domain.repository.Repository
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

}