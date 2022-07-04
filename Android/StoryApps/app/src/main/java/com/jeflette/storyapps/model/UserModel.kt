package com.jeflette.storyapps.model

data class UserModel(
    val name: String,
    val email: String,
    val password: String,
    val token: String,
    val isLogin: Boolean
)
