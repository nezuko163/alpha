package com.nezuko.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.repository.LocalStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val localStoreRepository: LocalStoreRepository
) : ViewModel() {
    private val _bins = localStoreRepository.getBins()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val bins = _bins

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            localStoreRepository.deleteAll()
        }
    }
}