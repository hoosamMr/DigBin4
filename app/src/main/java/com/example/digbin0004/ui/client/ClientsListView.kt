package com.example.digbin0004.ui.client

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.digbin0004.viewmodel.ClientViewModel

@Composable
 fun ClientsListView(
    modifier : Modifier = Modifier,
    viewModel: ClientViewModel = hiltViewModel(),
    /*clients: List<Client>,
    onClientSelected: (Client) -> Unit,
    onClientDeleted: (Client) -> Unit */
){
     val clients by viewModel.clients.collectAsState()
    Column(
        modifier = modifier.fillMaxSize()

    ) {
        LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(2.dp)

        ) {
            items(clients){
                client -> Text(text= client.name,
                modifier = Modifier.padding(8.dp)
                )

            }

        }
    }
}
