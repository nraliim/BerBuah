package com.bangkit.berbuah.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.berbuah.database.Favorite
import com.bangkit.berbuah.model.UserPreferences
import com.bangkit.berbuah.ui.repository.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application, private val pref : UserPreferences) : ViewModel() {
    private val mFavoriteRepository: FavoriteRepository = FavoriteRepository(application)

    fun getAllFavorites(): LiveData<List<Favorite>> = mFavoriteRepository.getAllFavorites()

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }
}