package com.example.coinpaprika.presentation.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpaprika.domain.models.coin_list.CoinListItem
import com.example.coinpaprika.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchViewModel(
    private val repository: CoinPaprikaRepository
) : ViewModel() {
    var loading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)
    val searchResults = mutableStateListOf<CoinListItem>()
    var searchInputValue by mutableStateOf("")

    init {
        onTriggerEvent(SearchStateEvent.GetAll())
    }

    private fun onTriggerEvent(
        event : SearchStateEvent
    ){
        when(event){
            is SearchStateEvent.GetAll -> getAll()
            is SearchStateEvent.SearchQuery -> searchQuery(event.query)
        }

    }

    private fun searchQuery(query: String) {
        repository.searchCoin(query).onEach {
            loading = it.loading
            errorMessage = it.error
            it.data?.let{data ->
                searchResults.clear()
                searchResults.addAll(data)
            }
        }.launchIn(viewModelScope)


    }

    private fun getAll() {
        repository.getAllCoins().onEach(){
            loading = it.loading
            errorMessage = it.error
            it.data?.let{data ->
                searchResults.clear()
                searchResults.addAll(data)
            }
        }.launchIn(viewModelScope)
    }


    fun onTextValueChanged(str : String) {
        searchInputValue = str
        if (searchInputValue.isEmpty()){
            onTriggerEvent(SearchStateEvent.GetAll())
        }else{
            onTriggerEvent(SearchStateEvent.SearchQuery(searchInputValue))
        }
    }
}