package com.example.digbin0004.model

data class JobBinder(
    val id : String,
    var serialNumber : String,
    var name : String,
    var draw : String, // to change it later to PDF/image
    var machine : String, // to change it to choose a machine from the machines list
    var tools : List<Tool> = emptyList()
)