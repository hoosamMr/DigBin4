package com.example.digbin0004.repository

import com.example.digbin0004.model.Client
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val firestore : FirebaseFirestore
) : ClientRepository{
    override suspend fun addClient(client: Client) {
        firestore
            .collection("clients")
            .add(client)
            .await()
    }

    override suspend fun getClients(): List<Client> {
        val snapshot = firestore
            .collection("clients")
            .get()
            .await()
        return snapshot.toObjects(Client::class.java)
    }

}