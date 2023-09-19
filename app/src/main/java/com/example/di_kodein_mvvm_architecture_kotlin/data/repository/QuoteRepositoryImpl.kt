package com.example.di_kodein_mvvm_architecture_kotlin.data.repository

import androidx.lifecycle.LiveData
import com.example.di_kodein_mvvm_architecture_kotlin.data.db.QuoteDao
import com.example.di_kodein_mvvm_architecture_kotlin.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {
    override fun addQuotes(quote: Quote) {
       quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()
}