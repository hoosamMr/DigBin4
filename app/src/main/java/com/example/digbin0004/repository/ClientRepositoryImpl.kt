package com.example.digbin0004.repository

import android.util.Log
import com.example.digbin0004.model.Client
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val firestore : FirebaseFirestore
) : ClientRepository{
    override suspend fun addClient(client: Client) {

        val trimmedName = client.name.trim()

        if (trimmedName.isBlank()) {
            throw IllegalArgumentException("Client name cannot be empty")
        }

//        val existing = firestore.collection("clients")
//            .whereEqualTo("name", trimmedName)
//            .limit(1)
//            .get()
//            .await()

//        if (!existing.isEmpty) {
//            throw IllegalArgumentException("Client name already exists")
//        }
        val existing = getClientByName(trimmedName)
        if(existing != null && existing.id != client.id){
            throw IllegalArgumentException("Client name already exists")
        }
        val documentRef = firestore.collection("clients").document()

        val clientWithId = client.copy(
            id = documentRef.id,
            name = trimmedName
        )

        documentRef.set(clientWithId).await()
        Log.d("ClientRepositoryImpl", "Client added successfully from ${ClientRepositoryImpl::class} save client with id")
    }


    override suspend fun deleteClient(client: Client) {
        firestore
            .collection("clients")
            .document(client.id)
            .delete()
            .await()
    }
    suspend fun getClientByName(name : String) : Client?{
      val snapshot = firestore.collection("clients")
          .whereEqualTo("name",name.trim())
          .limit(1).get().await()
        //return snapshot.toObject(Client::class.java)
        return snapshot.documents.firstOrNull()?.toObject(Client::class.java)


    }
    override suspend fun getClients(): List<Client> {
        val snapshot = firestore
            .collection("clients")
            .get()
            .await()
        return snapshot.toObjects(Client::class.java)
    }

}