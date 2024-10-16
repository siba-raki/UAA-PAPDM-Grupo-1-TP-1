package com.example.trabajopractico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.trabajopractico.ui.theme.AppTheme
import com.example.trabajopractico.navigation.NavigationComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                NavigationComponent()
            }
        }
    }
}
