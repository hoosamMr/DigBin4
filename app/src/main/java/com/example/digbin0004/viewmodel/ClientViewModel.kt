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

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _clients = MutableStateFlow<List<Client>>(emptyList())
    val clients: StateFlow<List<Client>> = _clients

    init {
        loadClients()
    }

    private fun loadClients() = viewModelScope.launch { _clients.value = repository.getClients() }

    fun setName(value: String) {
        _name.value = value
    }


    fun addClient(name: String) {
        viewModelScope.launch {
            try {
                val client = Client(name = name)
                repository.addClient(client)
                _name.value = "Client saved successfully"
            } catch (e: Exception) {
                _name.value = e.message ?: "Unknown error"
            }
        }
    }

//    suspend fun getClients(): List<Client> {
//        return repository.getClients()
//    }
}
