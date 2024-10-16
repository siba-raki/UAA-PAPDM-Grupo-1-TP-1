package com.example.trabajopractico.models

data class Product(
    val name: String,
    val description: String,
    val brand: String,
    val price: Double,
    val stock: Int,
    val imageUrl: String
)
