package com.example.digbin0004.ui.client

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.digbin0004.ui.theme.DigBin0004Theme
import com.example.digbin0004.viewmodel.ClientViewModel

@Composable
fun AddClientScreen(
    modifier: Modifier = Modifier,
    viewModel: ClientViewModel = hiltViewModel()
) {

    var name by remember { mutableStateOf("") }

    val message by viewModel.message.collectAsState()

    AddClientScreenContent(
        modifier = modifier,
        name = name,
        onNameChange = { name = it },
        message = message,
        onSaveClick = {
            if (name.isBlank()) {
                viewModel.setName("Client name cannot be empty")
                return@AddClientScreenContent
            }

            viewModel.addClient(name)
            name = ""
        }
    )
}

@Composable
fun AddClientScreenContent(
    modifier: Modifier = Modifier,
    name: String,
    onNameChange: (String) -> Unit,
    message: String,
    onSaveClick: () -> Unit
) {
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
            onValueChange = onNameChange,
            label = { Text("Client name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSaveClick
        ) {
            Text("Save Client")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (message.isNotEmpty()) {
            Text(text = message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddClientScreenPreview() {
    DigBin0004Theme {
        AddClientScreenContent(
            name = "John Doe",
            onNameChange = {},
            message = "Client added successfully",
            onSaveClick = {}
        )
    }
}
