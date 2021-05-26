package uca.edu.yourtopmusic.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DiscografiaNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("nombre")
    @Expose
    var nombre: String,

    @SerializedName("descripcion")
    @Expose
    var descripcion: String,

    @SerializedName("origen")
    @Expose
    var origen: String,

    @SerializedName("fechanac")
    @Expose
    var fechanac: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("nombrealbum")
    @Expose
    var nombrealbum: String,

    @SerializedName("urlalbum")
    @Expose
    var urlalbum: String,

    @SerializedName("anio")
    @Expose
    var anio: Int,

    @SerializedName("canciones")
    @Expose
    var canciones: Int,

    @SerializedName("genero")
    @Expose
    var genero: String
)