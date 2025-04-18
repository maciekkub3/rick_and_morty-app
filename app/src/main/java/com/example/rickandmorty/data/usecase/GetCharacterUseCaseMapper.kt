package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.domain.models.Info
import com.example.rickandmorty.data.domain.models.Location
import com.example.rickandmorty.data.domain.models.Origin
import com.example.rickandmorty.data.domain.models.Result
import com.example.rickandmorty.data.network.models.CharacterDto
import com.example.rickandmorty.data.network.models.ResultDto

object GetCharacterUseCaseMapper {
    fun CharacterDto.toDomain() : Character = Character(
        info = Info(
            count = info.count,
            next = info.next,
            pages = info.pages,
            prev = info.prev
        ),
        results = results.map {
            it.toDomain()
        }
    )

    fun ResultDto.toDomain() : Result = Result(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        location = Location(
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