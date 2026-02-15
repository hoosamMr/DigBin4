package com.example.digbin0004.model

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
