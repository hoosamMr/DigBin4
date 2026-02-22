package com.example.digbin0004.repository.firebase

import com.example.digbin0004.model.Client
import com.example.digbin0004.repository.ClientRepository
import com.google.firebase.firestore.FirebaseFirestore


class FirebaseClientRepository(
    private val firestore: FirebaseFirestore
): ClientRepository {
    override suspend fun addClient(client: Client) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteClient(client: Client) {
        TODO("Not yet implemented")
    }

    override suspend fun getClients(): List<Client> {
        TODO("Not yet implemented")
    }
}