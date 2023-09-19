package com.example.di_kodein_mvvm_architecture_kotlin.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.di_kodein_mvvm_architecture_kotlin.R
import com.example.di_kodein_mvvm_architecture_kotlin.data.model.Quote
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.lang.StringBuilder

class QuoteActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()

    private val viewModelFactory: QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeUi()
    }

    private fun initializeUi() {
        val textViewQuotes = findViewById<TextView>(R.id.textView_quotes)
        val buttonAddQuote = findViewById<Button>(R.id.button_add_quote)
        val editTextQuote = findViewById<EditText>(R.id.editText_quote)
        val editTextAuthor = findViewById<EditText>(R.id.editText_author)
        val viewModel = ViewModelProvider(this, viewModelFactory)[QuoteViewModel::class.java]

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textViewQuotes.text = stringBuilder.toString()
        })

        buttonAddQuote.setOnClickListener {
            val quote = Quote(editTextQuote.text.toString(), editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            editTextQuote.setText("")
            editTextAuthor.setText("")
        }

    }


}

