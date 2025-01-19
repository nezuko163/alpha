package com.nezuko.main

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.model.ResultModel
import com.nezuko.domain.repository.BinSearch
import com.nezuko.domain.repository.LocalStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val binSearch: BinSearch,
    private val localStoreRepository: LocalStoreRepository
) : ViewModel() {
    private val TAG = "MainViewModel"
    private val _binDetails = MutableStateFlow<ResultModel<BinDetails>>(ResultModel.none())
    val binDetails = _binDetails.asStateFlow()

    fun searchBin(bin: String, onFailure: (String?) -> Unit) {
        Log.i(TAG, "searchBin: start")
        viewModelScope.launch {
            binSearch.searchCardBIN(bin)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    Log.e(TAG, "searchBin: ошибка в catch", )
                    _binDetails.update { ResultModel.failure(e.message) }
                }
                .collect { value ->
                    _binDetails.update {
                        Log.i(TAG, "searchBin: data - ${value.data}")
                        if (value.status == ResultModel.Status.SUCCESS) {
                            launch(Dispatchers.IO) {
                                localStoreRepository.saveBin(value.data!!)
                            }
                        } else if (value.status == ResultModel.Status.FAILURE) {
                            onFailure(value.message)
                        }
                        value
                    }
                }
        }
    }
}