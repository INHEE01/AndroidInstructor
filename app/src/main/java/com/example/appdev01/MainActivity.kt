package com.example.appdev01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables
        var timerTask: Timer? = null
        var isRunning = false
        var sec: Int = 0
        val tView: TextView = findViewById(R.id.tv_title)
        val btn1: Button = findViewById(R.id.btn_01)

        // Cilck, Timer Event
        btn1.setOnClickListener {
            isRunning = !isRunning
            if (isRunning == true) {
                timerTask = kotlin.concurrent.timer(period=1000) {
                    sec++
                    runOnUiThread {
                        tView.text = sec.toString()
                    }
                }
            } else {
                timerTask?.cancel()
            }
        }



//        val textView: TextView = findViewById(R.id.android_text) as TextView
//        textView.setOnClickListener {
//            textView.text = getString(R.string.name)
//        }
    }
}