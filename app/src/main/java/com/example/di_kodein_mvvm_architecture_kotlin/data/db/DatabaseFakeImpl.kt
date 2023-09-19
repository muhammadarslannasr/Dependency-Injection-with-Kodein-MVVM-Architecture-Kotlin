package com.example.di_kodein_mvvm_architecture_kotlin.data.db

class DatabaseFakeImpl : Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}