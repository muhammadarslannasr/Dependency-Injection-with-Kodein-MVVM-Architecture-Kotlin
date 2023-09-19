package com.example.di_kodein_mvvm_architecture_kotlin.data.repository

import androidx.lifecycle.LiveData
import com.example.di_kodein_mvvm_architecture_kotlin.data.model.Quote

interface QuoteRepository {

    fun addQuotes(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}