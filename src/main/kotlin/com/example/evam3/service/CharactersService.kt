package com.example.evam3.service

import com.example.evam3.model.Characters
import com.example.evam3.model.Scene
import com.example.evam3.repository.CharactersRepository
import com.example.evam3.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.math.BigDecimal


@Service
class CharactersService {

    @Autowired
    lateinit var charactersRepository: CharactersRepository
    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list ():List<Characters>{
        return charactersRepository.findAll()
    }


    fun save(characters: Characters): Characters {
        try {
            charactersRepository.findById(characters.sceneid)
                    ?: throw Exception("Id del cliente no encontrada")
            return charactersRepository.save(characters)
        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    /*fun save(characters: Characters): Characters{
        try{
            val scene = sceneRepository.findById(characters.sceneid)
            val listCharacter = charactersRepository.findBySceneId(characters.sceneid)
            var sum = BigDecimal(0.0)

            listCharacter.map {
                sum += sum * it.cost!!
            }

            if (scene?.budget!! <= sum + characters.cost!!) {
                throw IllegalArgumentException("El costo total de los personajes supera el presupuesto de la escena")
            }

            return charactersRepository.save(characters)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }*/

    fun update(characters: Characters): Characters{
        try {
            charactersRepository.findById(characters.id)
                    ?: throw Exception("ID no existe")

            return charactersRepository.save(characters)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(characters: Characters): Characters{
        try{
            val response = charactersRepository.findById(characters.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                description=characters.description //un atributo del model
            }
            return charactersRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Characters?{
        return charactersRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = charactersRepository.findById(id)
                    ?: throw Exception("ID no existe")
            charactersRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}