package org.sopt.play.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal val Context.dataStore by preferencesDataStore(
    name = "auth_preferences"
)

class AuthDataStore(
    context: Context,
) {
    private val appContext = context.applicationContext

    private companion object {
        private val EMAIL = stringPreferencesKey("email")
        private val PASSWORD = stringPreferencesKey("password")
        private val IS_LOGGED_IN = booleanPreferencesKey("isLoggedIn")
    }

    val email: Flow<String?> = appContext.dataStore.data.map { it[EMAIL] }
    val password: Flow<String?> = appContext.dataStore.data.map { it[PASSWORD] }
    val isLoggedIn = appContext.dataStore.data
        .map { preferences -> preferences[IS_LOGGED_IN] ?: false }

    suspend fun saveUser(email: String, password: String) {
        appContext.dataStore.edit {
            it[EMAIL] = email
            it[PASSWORD] = password
        }
    }

    suspend fun setLoggedIn(value: Boolean) {
        appContext.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = value
        }
    }
}
