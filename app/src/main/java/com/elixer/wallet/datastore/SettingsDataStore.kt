package com.elixer.wallet.datastore

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import com.elixer.wallet.presentation.BaseApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsDataStore
@Inject
constructor(app: BaseApplication) {

    private val datastore: DataStore<Preferences> = app.createDataStore(name = "settings")

    private val scope = CoroutineScope(Main)

    init {
        observeDataStore()
    }

    val nameState = mutableStateOf("")

    fun setName(name: String) {
        scope.launch {
            datastore.edit { preferences ->
                preferences[NAME_KEY] = name
            }
        }
    }

    private fun observeDataStore() {
        datastore.data.onEach { preferences ->
            preferences[NAME_KEY]?.let { name ->
                nameState.value = name
            }
        }.launchIn(scope)
    }

    companion object {
        private val NAME_KEY = stringPreferencesKey("name_key")
    }
}