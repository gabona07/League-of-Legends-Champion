package com.example.leagueoflegends.misc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueoflegends.R
import com.example.leagueoflegends.model.Response
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.champion_main_item.view.*

class MainAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var champions  = emptyArray<Response.Champion>()

    @JvmName("setChampions1")
    fun setChampions(champions : Array<Response.Champion>) {
        this.champions = champions
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.champion_main_item, parent, false)
        return ChampionHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentChampion = champions[position]
        holder.itemView.nameTextView.text = currentChampion.name
        holder.itemView.titleTextView.text = currentChampion.title
        holder.itemView.descriptionTextView.text = currentChampion.blurb
        // Somehow this doesn't work
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/10.21.1/img/champion/${currentChampion.name}.png").into(holder.itemView.avatar)
    }

    override fun getItemCount(): Int {
        return champions.size
    }

    inner class ChampionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.avatar)
        private val name: TextView = itemView.findViewById(R.id.nameTextView)
        private val title: TextView = itemView.findViewById(R.id.titleTextView)
        private val description: TextView = itemView.findViewById(R.id.descriptionTextView)
    }


}