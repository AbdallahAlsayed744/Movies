package com.hyperdesign.moviesapp.features.home.domain.model


data class Interst(
    val description: String,
    val id: String,
    val isSubgenre: Boolean=false,
    val name: String="",
    val primaryImage: PrimaryImage?=null
)
