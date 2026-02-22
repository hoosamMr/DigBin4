package com.example.digbin0004.repository

import com.example.digbin0004.model.Client

interface ClientRepository {
    suspend fun addClient(client: Client)
    suspend fun deleteClient(client: Client)
     suspend fun getClients(): List<Client>

}