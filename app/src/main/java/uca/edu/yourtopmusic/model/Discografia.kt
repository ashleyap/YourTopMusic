package uca.edu.yourtopmusic.model

data class Discografia (
    var id: String,
    var nombre: String,
    var descripcion: String,
    var origen: String,
    var fechanac: String,
    var url: String,
    var nombrealbum: String,
    var urlalbum: String,
    var anio: Int,
    var canciones: Int,
    var genero: String
)