package com.example.trabajopractico.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trabajopractico.models.Product
import com.example.trabajopractico.screens.ProductFormScreen
import com.example.trabajopractico.screens.ProductListScreen
import com.example.trabajopractico.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    val productList = remember { mutableStateListOf<Product>() }

    var isDarkTheme by remember { mutableStateOf(false) }

    AppTheme(darkTheme = isDarkTheme) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Gestión de Productos") },
                    actions = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = if (isDarkTheme) "Oscuro " else "Claro ")
                            Switch(
                                checked = isDarkTheme,
                                onCheckedChange = { isDarkTheme = it }
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                NavHost(navController = navController, startDestination = "menu") {
                    composable("menu") { MenuScreen(navController) }
                    composable("form") {
                        ProductFormScreen(onProductAdded = { product: Product ->
                            productList.add(product)
                        }, navController = navController)
                    }
                    composable("list") {
                        ProductListScreen(productList = productList)
                    }
                }
            }
        }
    }
}

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("form") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Crear producto")
        }

        Button(
            onClick = { navController.navigate("list") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Productos")
        }
    }
}
