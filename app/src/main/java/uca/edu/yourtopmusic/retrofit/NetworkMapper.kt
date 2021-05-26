package uca.edu.yourtopmusic.retrofit

import uca.edu.yourtopmusic.model.Discografia
import uca.edu.yourtopmusic.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<DiscografiaNetworkEntity, Discografia> {
    override fun mapFromEntity(entity: DiscografiaNetworkEntity): Discografia {
        return Discografia(
            id = entity.id,
            nombre = entity.nombre,
            descripcion = entity.descripcion,
            origen = entity.origen,
            fechanac = entity.fechanac,
            url = entity.url,
            nombrealbum = entity.nombrealbum,
            urlalbum = entity.urlalbum,
            anio = entity.anio,
            canciones = entity.canciones,
            genero = entity.genero
        )
    }

    override fun mapToEntity(domainModel: Discografia): DiscografiaNetworkEntity {
        return DiscografiaNetworkEntity(
            id = domainModel.id,
            nombre = domainModel.nombre,
            descripcion = domainModel.descripcion,
            origen = domainModel.origen,
            fechanac = domainModel.fechanac,
            url = domainModel.url,
            nombrealbum = domainModel.nombrealbum,
            urlalbum = domainModel.urlalbum,
            anio = domainModel.anio,
            canciones = domainModel.canciones,
            genero = domainModel.genero
        )
    }

    fun mapFromEntityList(entities: List<DiscografiaNetworkEntity>): List<Discografia>{
        return entities.map { mapFromEntity(it) }
    }

}