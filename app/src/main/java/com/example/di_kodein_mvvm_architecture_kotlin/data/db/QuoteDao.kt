package com.example.di_kodein_mvvm_architecture_kotlin.data.db

import androidx.lifecycle.LiveData
import com.example.di_kodein_mvvm_architecture_kotlin.data.model.Quote

interface QuoteDao {

    fun addQuote(quote: Quote)
    fun getQuotes() : LiveData<List<Quote>>
}