package com.example.rickandmorty.data.domain.models

data class PaginationInfo(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: Any?
)

data class PaginationInfoDto(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: Any?
)
