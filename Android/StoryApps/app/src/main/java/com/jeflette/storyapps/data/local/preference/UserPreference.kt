package com.jeflette.storyapps.data.local.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun logout() {
        dataStore.edit { preferences ->
            apply {
                preferences[TOKEN_KEY] = ""
                preferences[STATE_KEY] = false
            }
        }
    }

    suspend fun login(token: String) {
        dataStore.edit { preferences ->
            preferences[STATE_KEY] = true
            preferences[TOKEN_KEY] = token
        }
    }

    fun getToken(): Flow<String?> = dataStore.data.map { it[TOKEN_KEY] }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val TOKEN_KEY = stringPreferencesKey("token")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}