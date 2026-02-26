package com.example.digbin0004.repository.machine

import android.util.Log
import com.example.digbin0004.firebase.FirestoreService
import com.example.digbin0004.model.Machine
import javax.inject.Inject

class MachineRepositoryImpl @Inject constructor(
    private val firestore: FirestoreService
) : MachineRepository {

    companion object {
        private const val PATH = "machines"
    }

    override suspend fun addMachine(machine: Machine) {
        firestore.add(PATH, machine)
            .onSuccess { Log.d("MachineRepo", "Added: ${machine.id}") }
            .onFailure { throw it }
    }

    override suspend fun updateMachine(machine: Machine) {
        firestore.update(PATH, machine.id, machine)
            .onSuccess { Log.d("MachineRepo", "Updated: ${machine.id}") }
            .onFailure { throw it }
    }

    override suspend fun deleteMachine(machine: Machine) {
        firestore.delete(PATH, machine.id)
            .onSuccess { Log.d("MachineRepo", "Deleted: ${machine.id}") }
            .onFailure { throw it }
    }

    override suspend fun getMachine(id: String): Machine? {
        return firestore.get(PATH, id, Machine::class.java)
            .fold(onSuccess = { it }, onFailure = { throw it })
    }

    override suspend fun getMachines(): List<Machine> {
        return firestore.getAll(PATH, Machine::class.java)
            .fold(onSuccess = { it }, onFailure = { throw it })
    }
}