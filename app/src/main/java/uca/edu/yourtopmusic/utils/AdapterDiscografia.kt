package uca.edu.yourtopmusic.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_discografia.view.*
import uca.edu.yourtopmusic.model.Discografia
import uca.edu.yourtopmusic.R

class AdapterDiscografia (): RecyclerView.Adapter<AdapterDiscografia.ViewHolder>(){
    lateinit var items: ArrayList<Discografia>

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }

    fun setDiscografia(items: List<Discografia>){
        this.items = items as ArrayList<Discografia>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_discografia, parent, false))

    override fun onBindViewHolder(holder: AdapterDiscografia.ViewHolder, position: Int) {
        val model = items[position]
        val sb = StringBuilder()
        var url = sb.append(model.url).append(".jpg")
        Picasso.get().load(url.toString()).into(holder.ivArtist)
        sb.clear()
        url = sb.append(model.urlalbum).append(".jpg")
        Picasso.get().load(url.toString()).into(holder.ivAlbum)
        holder.tvArtistName.text = model.nombre
        holder.tvAlbumName.text = model.nombrealbum
        holder.tvDate.text = model.fechanac
        holder.tvDescription.text = model.descripcion
        holder.tvOrigin.text = model.origen
        holder.tvYear.text = model.anio.toString()
        holder.tvGenre.text = model.genero
        sb.clear()
        holder.tvNumberSongs.text = sb.append(model.canciones).append(" canciones")
    }

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val ivArtist: ImageView = view.iv_artist
        val tvArtistName: TextView = view.tv_name_artist
        val tvDescription: TextView = view.tv_about
        val tvDate: TextView = view.tv_date
        val tvOrigin: TextView = view.tv_origin
        val ivAlbum: ImageView = view.iv_album
        val tvAlbumName: TextView = view.tv_name_album
        val tvGenre: TextView = view.tv_genre
        val tvYear: TextView = view.tv_year_album
        val tvNumberSongs = view.tv_songs
    }
}