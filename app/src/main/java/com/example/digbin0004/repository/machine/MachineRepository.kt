package com.example.digbin0004.repository.machine

import com.example.digbin0004.model.Machine

interface MachineRepository {
    suspend fun addMachine(machine: Machine)
    suspend fun updateMachine(machine: Machine)
    suspend fun deleteMachine(machine: Machine)
    suspend fun getMachine(machine: Machine): Machine
    suspend fun getMachines(): List<Machine>

}