package com.example.livedata

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var fruitTextView: TextView
    private lateinit var changeFruitButton: Button
    private lateinit var enterFruitNameEditText: EditText
    private lateinit var displayButton: Button
    private lateinit var selectButton: Button
    private lateinit var displayEditTextContentTextView: TextView
    private var enteredFruitName:String = ""
    private val fruits = listOf("Apple", "Banana", "Orange", "Mango", "Strawberry")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fruitTextView = findViewById(R.id.Fruit)
        changeFruitButton = findViewById(R.id.change_fruit_btn)
        enterFruitNameEditText = findViewById(R.id.enter_fruit_name_tf)
        displayButton = findViewById(R.id.display_btn)
        selectButton = findViewById(R.id.select_btn)
        displayEditTextContentTextView = findViewById(R.id.display_edittext_content_tv)

        changeFruitButton.setOnClickListener {
            val randomFruit = fruits.random()
            fruitTextView.text = randomFruit
        }

        displayButton.setOnClickListener {
            val randomFruit = fruits.random()
            displayEditTextContentTextView.text = enteredFruitName
        }

        selectButton.setOnClickListener {
            val randomFruit = fruits.random()
            enterFruitNameEditText.setText(randomFruit)
        }

        enterFruitNameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                enteredFruitName = s.toString()
                showToast(enteredFruitName)
            }
        })
    }

    private fun showToast(fruitName: String) {
        Toast.makeText(this, fruitName, Toast.LENGTH_SHORT).show()
    }
}