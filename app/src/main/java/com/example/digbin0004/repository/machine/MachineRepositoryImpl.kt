package com.example.digbin0004.repository.machine

import com.example.digbin0004.firebase.FirestoreService
import com.example.digbin0004.model.Machine
import javax.inject.Inject

class MachineRepositoryImpl @Inject constructor(
    private val firestore : FirestoreService
) : MachineRepository {
    override suspend fun addMachine(machine: Machine) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMachine(machine: Machine) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMachine(machine: Machine) {
        TODO("Not yet implemented")
    }

    override suspend fun getMachine(machine: Machine): Machine {
        TODO("Not yet implemented")
    }

    override suspend fun getMachines(): List<Machine> {
        TODO("Not yet implemented")
    }

}