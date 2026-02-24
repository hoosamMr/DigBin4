package com.example.digbin0004.di


import com.example.digbin0004.repository.client.ClientRepository
import com.example.digbin0004.repository.client.ClientRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFireStoreInstance() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideClientRepository(
        firestore : FirebaseFirestore
    ) : ClientRepository = ClientRepositoryImpl(firestore)

//    @Provides
//    @Singleton
//    fun provideFireStoreService(firebaseFirestore : FirebaseFirestore) : FirestoreService = FirestoreService(firebaseFirestore)


//    @Provides
//    @Singleton
//    fun provideFirestore(): FirebaseFirestore {
//        return FirebaseFirestore.getInstance()
    }



}