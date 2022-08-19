package com.example.coinpaprika.presentation.ui.search

sealed class SearchStateEvent(){
    data class GetAll(val nothing : Any? = null) : SearchStateEvent()
    data class SearchQuery(val query : String) : SearchStateEvent()
}