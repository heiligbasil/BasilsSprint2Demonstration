package com.lambdaschool.basilssprint2challengedemonstration.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.basilssprint2challengedemonstration.R
import com.lambdaschool.basilssprint2challengedemonstration.model.Unsplash
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class ListAdapter(val myList: MutableList<Unsplash>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        context = parent.context
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.idPic.setImageResource(myList[position].id)
        holder.namePic.text = myList[position].name

        holder.cardLayout.setOnClickListener {

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idPic: ImageView = view.image_view
        val namePic: TextView = view.text_view
        val cardLayout: CardView = view.card_view
    }
}