package com.example.di_kodein_mvvm_architecture_kotlin

import android.app.Application
import com.example.di_kodein_mvvm_architecture_kotlin.data.db.Database
import com.example.di_kodein_mvvm_architecture_kotlin.data.db.DatabaseFakeImpl
import com.example.di_kodein_mvvm_architecture_kotlin.data.db.QuoteDao
import com.example.di_kodein_mvvm_architecture_kotlin.data.repository.QuoteRepository
import com.example.di_kodein_mvvm_architecture_kotlin.data.repository.QuoteRepositoryImpl
import com.example.di_kodein_mvvm_architecture_kotlin.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance())}
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}