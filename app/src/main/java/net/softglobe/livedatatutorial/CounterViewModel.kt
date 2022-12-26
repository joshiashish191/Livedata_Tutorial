package net.softglobe.livedatatutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>()
    var count = 0

    fun getCounter() : LiveData<Int> {
        return _counter
    }

    fun incrementCounter() {
        count++
        _counter.value = count
    }
}