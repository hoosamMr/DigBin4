package com.example.digbin0004.repository.machine

import android.util.Log
import com.example.digbin0004.firebase.FirestoreService
import com.example.digbin0004.model.Machine
import javax.inject.Inject

class MachineRepositoryImpl @Inject constructor(
    private val firestore : FirestoreService
) : MachineRepository {
    override suspend fun addMachine(machine: Machine) {
       firestore.add("machines", machine)
           .onSuccess { Log.d("MachineRepositoryImpl", "Machine added successfully")  }
           .onFailure { Log.e("MachineRepositoryImpl", "Error adding machine", it) }




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

/*
data class Machine(
    val id: String,
    val name: String,
    val magazineSize: Int,
    val probeIndex: Int,
    val magazine: List<Tool?>
) {
    init {
        require(probeIndex in 0 until magazineSize) {
            "Probe index must be inside magazine range"
        }
        require(magazine.size == magazineSize) {
            "Magazine list must match magazine size"
        }
    }
}
*/