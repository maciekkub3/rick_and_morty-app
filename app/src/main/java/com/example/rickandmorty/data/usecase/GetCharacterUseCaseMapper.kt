package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.CharacterResponse
import com.example.rickandmorty.data.domain.models.PaginationInfo
import com.example.rickandmorty.data.domain.models.CharacterLocation
import com.example.rickandmorty.data.domain.models.Origin
import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.network.models.CharacterResponseDto
import com.example.rickandmorty.data.network.models.CharacterDto

object GetCharacterUseCaseMapper {
    fun CharacterResponseDto.toDomain() : CharacterResponse = CharacterResponse(
        info = PaginationInfo(
            count = info.count,
            next = info.next,
            pages = info.pages,
            prev = info.prev
        ),
        results = results.map {
            it.toDomain()
        }
    )

    fun CharacterDto.toDomain() : Character = Character(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        location = CharacterLocation(
            name = location.name,
            url = location.url
        ),
        name = name,
        origin = Origin(
            name = origin.name,
            url = origin.url
        ),
        species = species,
        status = status,
        type = type,
        url = url
    )
}