package com.example.digbin0004

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.digbin0004.ui.AddClientScreen
import com.example.digbin0004.ui.theme.DigBin0004Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DigBin0004Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AddClientScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

