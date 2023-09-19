package com.example.di_kodein_mvvm_architecture_kotlin.data.model

data class Quote(val text: String, val author: String) {


    override fun toString(): String {
        return "$text - $author"
    }
}