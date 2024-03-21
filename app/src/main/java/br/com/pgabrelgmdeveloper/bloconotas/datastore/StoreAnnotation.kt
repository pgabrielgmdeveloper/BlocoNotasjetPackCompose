package br.com.pgabrelgmdeveloper.bloconotas.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreAnnotation(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("configs")
        val ANNOTATION_KEY = stringPreferencesKey("anotacao")
    }

    val getAnnotation: Flow<String> = context.dataStore.data.map {
        it[ANNOTATION_KEY] ?: ""
    }

    suspend fun saveAnnotations(annotation: String) {
        context.dataStore.edit {
            it[ANNOTATION_KEY] = annotation
        }
    }
}