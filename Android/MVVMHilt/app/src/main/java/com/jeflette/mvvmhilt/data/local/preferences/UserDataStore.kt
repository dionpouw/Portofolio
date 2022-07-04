package com.jeflette.mvvmhilt.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


private const val PREF_NAME = "user_preferences"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = PREF_NAME
)

class UserDataStore(preferences_datastore: DataStore<Preferences>) {
    private val USER_TOKEN = stringPreferencesKey("user_token")
    private val LOGIN_STATUS = stringPreferencesKey("login_status")

    suspend fun login(token: String, context: Context) {
        context.dataStore.edit {
            it[USER_TOKEN] = token
            it[LOGIN_STATUS] = "true"
        }
    }

    suspend fun logout(context: Context) {
        context.dataStore.edit { it.clear() }
    }
}
