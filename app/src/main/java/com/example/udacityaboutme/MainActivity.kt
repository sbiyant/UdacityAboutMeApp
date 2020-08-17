package com.example.udacityaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        done_btn.setOnClickListener {
            addNickname()
        }

        nickname_text.setOnClickListener {
            updateNickname()
        }
    }
    private fun addNickname() {
        nickname_text.text = nickname_edt.text
        nickname_edt.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE
        done_btn.visibility = View.GONE

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(done_btn.windowToken, 0)

    }

    private fun updateNickname() {
        nickname_edt.visibility = View.VISIBLE
        nickname_text.visibility = View.GONE
        done_btn.visibility = View.VISIBLE

        nickname_edt.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname_edt, 0)
    }
}