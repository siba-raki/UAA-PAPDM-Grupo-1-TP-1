package com.example.trabajopractico.screens

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.trabajopractico.models.Product

@Composable
fun ProductFormScreen(onProductAdded: (Product) -> Unit, navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var isUrlValid by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Nuevo Producto", style = MaterialTheme.typography.titleMedium)

        TextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") })
        TextField(value = description, onValueChange = { description = it }, label = { Text("Descripción") })
        TextField(value = brand, onValueChange = { brand = it }, label = { Text("Marca") })
        TextField(value = price, onValueChange = { price = it }, label = { Text("Precio") })
        TextField(value = stock, onValueChange = { stock = it }, label = { Text("Existencia") })

        TextField(
            value = imageUrl,
            onValueChange = {
                imageUrl = it
                isUrlValid = isValidUrl(it)
            },
            label = { Text("URL de la Imagen") },
            isError = !isUrlValid
        )

        // Mostrar un mensaje de error si la URL no es válida
        if (!isUrlValid) {
            Text(
                text = "URL inválida, por favor ingrese una URL válida",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val product = Product(
                    name = name,
                    description = description,
                    brand = brand,
                    price = price.toDoubleOrNull() ?: 0.0,
                    stock = stock.toIntOrNull() ?: 0,
                    imageUrl = imageUrl
                )
                onProductAdded(product)
                navController.popBackStack()
            },
            enabled = isUrlValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Producto")
        }
    }
}

fun isValidUrl(url: String): Boolean {
    return Patterns.WEB_URL.matcher(url).matches()
}

