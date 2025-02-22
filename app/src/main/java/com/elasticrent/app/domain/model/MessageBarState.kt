package com.elasticrent.app.domain.model

data class MessageBarState(
    val message:String? = null,
    val error: Exception? = null
)