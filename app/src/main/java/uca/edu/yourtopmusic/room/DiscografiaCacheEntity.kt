package uca.edu.yourtopmusic.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist")
class DiscografiaCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "nombre")
    var nombre: String,
    @ColumnInfo(name = "descripcion")
    var descripcion: String,
    @ColumnInfo(name = "origen")
    var origen: String,
    @ColumnInfo(name = "fechanac")
    var fechanac: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "nombrealbum")
    var nombrealbum: String,
    @ColumnInfo(name = "urlalbum")
    var urlalbum: String,
    @ColumnInfo(name = "anio")
    var anio: Int,
    @ColumnInfo(name = "canciones")
    var canciones: Int,
    @ColumnInfo(name = "genero")
    var genero: String
)