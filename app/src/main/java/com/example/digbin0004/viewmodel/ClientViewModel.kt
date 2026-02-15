package com.example.digbin0004.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digbin0004.model.Client
import com.example.digbin0004.repository.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientViewModel @Inject constructor(
    private val repository: ClientRepository
) : ViewModel() {

    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message

    fun setMessage(value: String) {
        _message.value = value
    }

    fun addClient(name: String) {
        viewModelScope.launch {
            try {
                val client = Client(name = name)
                repository.addClient(client)
                _message.value = "Client saved successfully"
            } catch (e: Exception) {
                _message.value = e.message ?: "Unknown error"
            }
        }
    }
}
