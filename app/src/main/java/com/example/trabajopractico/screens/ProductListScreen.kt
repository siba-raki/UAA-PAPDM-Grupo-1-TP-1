package com.example.trabajopractico.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.trabajopractico.models.Product


@Composable
fun ProductListScreen(productList: MutableList<Product>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Productos", style = MaterialTheme.typography.titleSmall)

        if (productList.isEmpty()) {
            Text("No hay productos registrados.")
        } else {
            LazyColumn {
                items(productList) { product ->
                    ProductItem(
                        product = product,
                        onDelete = { productList.remove(product) }
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, onDelete: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary)
            .padding(8.dp)
    ) {
        Text(
            text = product.name,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(product.description)

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(end = 16.dp)) {
                    Text("Marca: ${product.brand}")
                }
            }

            item {
                Column(modifier = Modifier.padding(end = 16.dp)) {
                    Text("Precio: \$${product.price}")
                    Text("Existencia: ${product.stock}")
                }
            }

            item {
                ImageFromUrl(url = product.imageUrl, modifier = Modifier.size(64.dp))
            }
        }

        Button(
            onClick = { onDelete() },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Eliminar", color = MaterialTheme.colorScheme.onError)
        }
    }
}

@Composable
fun ImageFromUrl(url: String, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(model = url)
    val state = painter.state

    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )

        if (state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (state is AsyncImagePainter.State.Error) {
            Text("Error al cargar imagen", color = MaterialTheme.colorScheme.error)
        }
    }
}