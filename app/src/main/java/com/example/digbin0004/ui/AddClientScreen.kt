package com.example.digbin0004.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.digbin0004.viewmodel.ClientViewModel

@Composable
fun AddClientScreen(
    modifier: Modifier = Modifier,
    viewModel: ClientViewModel = hiltViewModel()
) {

    var name by remember { mutableStateOf("") }

    val message by viewModel.message.collectAsState()

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
                    viewModel.setMessage("Client name cannot be empty")
                    return@Button
                }

                viewModel.addClient(name)
                name = ""
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
