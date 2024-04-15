package com.example.core.domain.model

import java.math.BigDecimal

data class Product(
    val id: Long,
    val name: String,
    val image: String,
    val price: Int
)
