package com.example.digbin0004.firebase

import com.example.digbin0004.model.Client
import com.google.firebase.firestore.FirebaseFirestore

class ClientFirebaseService {

    private val db = FirebaseFirestore.getInstance()

    fun addClient(
        client: Client,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        db.collection("clients")
            .add(client)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onError(exception)
            }
    }
}
