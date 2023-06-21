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


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ItemAdapter (private val Univer: ArrayList<Univer>, navController: NavController)
    : RecyclerView.Adapter<ItemAdapter.DataViewHolder>(){


    private val navController = navController
    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val Title: TextView = view.findViewById<Button>(R.id.title)
        val web_page: TextView = view.findViewById<Button>(R.id.web_page)
      //  val cardView: CardView = view.findViewById(R.id.cardView)
        val btnSave: Button = view.findViewById(R.id.btnSave)

        fun bind(univer: Univer) {
                    Title.text = univer.name
            web_page.text = univer.web_pages
//            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+film.backdrop_path).into(imageFilm)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ItemAdapter.DataViewHolder(layout)
    }
    override fun getItemCount(): Int  = Univer.size

    override fun onBindViewHolder(holder: ItemAdapter.DataViewHolder, position: Int) {
        val univer = Univer[position]
        holder.bind(univer)
       holder.btnSave.setOnClickListener {

           CoroutineScope(Dispatchers.Main).launch {
                 Repo().store(univer)

                }
                Toast.makeText(holder.itemView.context, "save successfully", Toast.LENGTH_SHORT).show()

            }


//            val action = FilmAvoirFragmentDirections.actionFilmAvoirFragmentToDetailFilmFragment(film.film_id)
//            navController.navigate(action)
      // }
      //  holder.btnDelete.setOnClickListener {


//            CoroutineScope(Dispatchers.Main).launch {
//
//                FilmRepo().delete(film.film_id)
//                // Success message
//                if (position != -1) {
//
//                    films.removeAt(position)
//                    notifyItemRemoved(position)
//                }
//                Toast.makeText(holder.itemView.context, "Film deleted successfully", Toast.LENGTH_SHORT).show()
//
//            }
     //   }
    }

    fun addData(univer : List<Univer>) {
        this.Univer.apply {
            clear()
            addAll(univer)
        }
    }
}