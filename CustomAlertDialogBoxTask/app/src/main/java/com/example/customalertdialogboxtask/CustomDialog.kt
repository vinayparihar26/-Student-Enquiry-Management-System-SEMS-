package com.example.customalertdialogboxtask

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CustomDialog(
    context: Context,
    var name: String,
    var number: String,
    var date: String,
    var time: String


) : Dialog(context) {

    var tvName1: EditText? = null
    var tvNumber1: EditText? = null
    var tvDate1: EditText? = null
    var tvTime1: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
        setContentView(view)

        var tvName1 = findViewById<TextView>(R.id.tvName1)
        var tvNumber1 = findViewById<TextView>(R.id.tvNumber1)
        var tvDate1 = findViewById<TextView>(R.id.tvDate1)
        var tvTime1 = findViewById<TextView>(R.id.tvTime1)
        var btnDone = findViewById<Button>(R.id.btnMain)
        tvName1.text = name
        tvNumber1.text = number
        tvDate1.text = date
        tvTime1.text = time


        btnDone.setOnClickListener {
            var name = tvName1.text.toString()

            dismiss()
        }


    }  }

