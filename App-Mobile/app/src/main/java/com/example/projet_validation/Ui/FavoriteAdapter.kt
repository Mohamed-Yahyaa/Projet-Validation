package com.example.projet_validation.Ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.R
import com.example.projet_validation.Repo.Repo

import com.example.projet_validation.Ui.placeholder.PlaceholderContent.PlaceholderItem

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FavoriteAdapter(private val Univer: ArrayList<Univer>, navController: NavController)
    : RecyclerView.Adapter<FavoriteAdapter.DataViewHolder>(){


    private val navController = navController
    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val Title: TextView = view.findViewById<Button>(R.id.title)
        val web_page: TextView = view.findViewById<Button>(R.id.web_page)
        //  val cardView: CardView = view.findViewById(R.id.cardView)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)

        fun bind(univer: Univer) {
            Title.text = univer.name
            web_page.text = univer.web_pages
//            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+film.backdrop_path).into(imageFilm)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_item_favorite, parent, false)
        return FavoriteAdapter.DataViewHolder(layout)
    }
    override fun getItemCount(): Int  = Univer.size

    override fun onBindViewHolder(holder: FavoriteAdapter.DataViewHolder, position: Int) {
        val univer = Univer[position]
        holder.bind(univer)

         holder.btnDelete.setOnClickListener {


            CoroutineScope(Dispatchers.Main).launch {

                Repo().delete(univer.name)
                // Success message
                if (position != -1) {

                    Univer.removeAt(position)
                    notifyItemRemoved(position)
                }
                Toast.makeText(holder.itemView.context, " delete  successfully", Toast.LENGTH_SHORT).show()

            }
           }
    }

    fun addData(univer : List<Univer>) {
        this.Univer.apply {
            clear()
            addAll(univer)
        }
    }
}