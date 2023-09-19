package com.example.di_kodein_mvvm_architecture_kotlin.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.di_kodein_mvvm_architecture_kotlin.data.model.Quote
import com.example.di_kodein_mvvm_architecture_kotlin.data.repository.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun addQuote(quote: Quote) = quoteRepository.addQuotes(quote)
    fun getQuotes() = quoteRepository.getQuotes()
}