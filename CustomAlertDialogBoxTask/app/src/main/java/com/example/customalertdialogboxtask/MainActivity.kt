package com.example.customalertdialogboxtask

import android.app.AlertDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.util.Calendar
import java.util.Objects

class MainActivity : AppCompatActivity() {
    var btnClick: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val tvName = findViewById<TextView>(R.id.tvName)
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        val showTextName = findViewById<TextView>(R.id.showName)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val showNumber = findViewById<TextView>(R.id.showNumber)
        val btnClick = findViewById<Button>(R.id.btnClick)

        val btnForTime = findViewById<Button>(R.id.btnForTime)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val tvForshowTime = findViewById<TextView>(R.id.TvForshowTime)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val btnForDate = findViewById<Button>(R.id.btnForDate)
        val tvShowDate = findViewById<TextView>(R.id.tvShowDate)
        val btnMain = findViewById<Button>(R.id.btnMain)

        btnClick.setOnClickListener {
            var resultName = edtName.text.toString()
            showTextName.text = resultName

            var resultNumber = edtNumber.text.toString()
            showNumber.text = resultNumber


        }

        btnForTime.setOnClickListener {
            val resulForTime =
                timePicker.hour.toString() + "hours" + " " + timePicker.minute.toString() + "minutes"
            tvForshowTime.text = resulForTime
        }

        btnForDate.setOnClickListener {

            val resultForDate =
                datePicker.year.toString() + (datePicker.month + 1).toString() + datePicker.dayOfMonth.toString()
            tvShowDate.text = resultForDate
        }

        btnMain.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are You Sure")
                .setPositiveButton("Yes") { dialog, id ->
                    finish()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.cancel()
                }

            builder.create().show()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


    }
}