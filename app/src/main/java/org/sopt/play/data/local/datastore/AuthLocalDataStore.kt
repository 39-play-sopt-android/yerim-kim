package org.sopt.play.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException
import org.sopt.play.domain.model.UserModel

internal val Context.dataStore by preferencesDataStore(
    name = "auth_preferences"
)

class AuthDataStore(
    context: Context,
) {
    private val appContext = context.applicationContext

    private companion object {
        private val NAME = stringPreferencesKey("name")
        private val EMAIL = stringPreferencesKey("email")
        private val PASSWORD = stringPreferencesKey("password")
        private val IS_LOGGED_IN = booleanPreferencesKey("isLoggedIn")
    }

    val userProfile: Flow<UserModel?> = appContext.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val name = preferences[NAME]
            val email = preferences[EMAIL]

            if (name != null && email != null) {
                UserModel(name = name, email = email)
            } else null
        }

    val password: Flow<String?> = appContext.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { it[PASSWORD] }
    val isLoggedIn = appContext.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences -> preferences[IS_LOGGED_IN] ?: false }

    suspend fun saveUser(name: String, email: String, password: String) {
        appContext.dataStore.edit {
            it[NAME] = name
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
