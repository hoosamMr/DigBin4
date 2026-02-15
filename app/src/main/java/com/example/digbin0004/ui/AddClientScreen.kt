package com.example.digbin0004.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.digbin0004.firebase.ClientFirebaseService
import com.example.digbin0004.model.Client

@Composable
fun AddClientScreen(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val clientService = remember { ClientFirebaseService() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Add Client",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Client name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (name.isBlank()) {
                    message = "Client name cannot be empty"
                    return@Button
                }

                val client = Client(name = name)

                clientService.addClient(
                    client = client,
                    onSuccess = {
                        message = "Client saved successfully"
                        name = ""
                    },
                    onError = {
                        message = it.message ?: "Unknown error"
                    }
                )
            }
        ) {
            Text("Save Client")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (message.isNotEmpty()) {
            Text(text = message)
        }
    }
}
