package com.example.digbin0004.firebase

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreService @Inject constructor(
    private val db: FirebaseFirestore  // ← Hilt provides this, not getInstance()
) {

    // CREATE
    suspend fun <T : Any> add(collectionPath: String, item: T): Result<Unit> {
        return try {
            db.collection(collectionPath).add(item).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // READ ALL
    suspend fun <T : Any> getAll(collectionPath: String, clazz: Class<T>): Result<List<T>> {
        return try {
            val snapshot = db.collection(collectionPath).get().await()
            val items = snapshot.documents.mapNotNull { it.toObject(clazz) }
            Result.success(items)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    //read one
    suspend fun <T : Any> get(collectionPath: String, id: String, clazz: Class<T>): Result<T?> {
        return try {
            val snapshot = db.collection(collectionPath).document(id).get().await()
           val item = snapshot.toObject(clazz)
            Result.success(item)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    // UPDATE
    suspend fun <T : Any> update(collectionPath: String, id: String, item: T): Result<Unit> {
        return try {
            db.collection(collectionPath).document(id).set(item).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // DELETE
    suspend fun delete(collectionPath: String, id: String): Result<Unit> {
        return try {
            db.collection(collectionPath).document(id).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}