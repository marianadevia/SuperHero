package com.example.recyclerviewclick

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewclick.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class HeroAdapter(val superheros:List<SuperHero>): RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    inner class HeroHolder(val view: View):RecyclerView.ViewHolder(view){
       val binding = ItemSuperheroBinding.bind(view)
        fun bind(superhero:SuperHero){
            binding.tvRealName.text = superhero.realName
            binding.tvSuperHeroName.text = superhero.superHeroName
            binding.tvPublisher.text = superhero.publisher
            Picasso.get().load(superhero.image).into(binding.ivHero)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
       val layoutInflater= LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero,parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
       val item = superheros[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
       return superheros.size
    }
}