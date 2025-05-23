package com.techtornado.esggenerator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.techtornado.esggenerator.ui.theme.ERGGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ERGGeneratorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    MainScreen(
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}