package net.softglobe.livedatatutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel : CounterViewModel
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(CounterViewModel::class.java)
        val livedataTextView = findViewById<TextView>(R.id.livedata_counter)

        findViewById<Button>(R.id.increment_button).setOnClickListener {
            val activityCounter = findViewById<TextView>(R.id.activity_counter)
            counter++
            activityCounter.text = counter.toString()
            viewmodel.incrementCounter()
        }

        viewmodel.getCounter().observe(this, Observer {
            livedataTextView.text = it.toString()
        })
    }
}