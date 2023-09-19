package com.example.di_kodein_mvvm_architecture_kotlin.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.di_kodein_mvvm_architecture_kotlin.data.repository.QuoteRepository

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepository) as T
    }
}