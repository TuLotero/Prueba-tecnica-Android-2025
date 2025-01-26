package com.tulotero.buscadorboletos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tulotero.buscadorboletos.model.DataModel
import com.tulotero.buscadorboletos.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = Repository()
    val data: MutableLiveData<List<DataModel>> = MutableLiveData()
    private val sorteoId = 9052

    fun fetchData(numero: String? = null, cantidad: Int? = 1) {
        viewModelScope.launch {
            val result = repository.getData(
                sorteoId,
                numero ?: "_____",
                cantidad ?: 1
            )
            data.postValue(result)
        }
    }
}