package com.lambdaschool.basilssprint2challengedemonstration.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.basilssprint2challengedemonstration.R
import com.lambdaschool.basilssprint2challengedemonstration.model.Unsplash
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class ListAdapter(val myList: MutableList<Unsplash>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var context: Context? = null

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        context = parent.context
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(viewGroup)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return myList.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.idPic.setImageResource(myList[position].id)
        holder.namePic.text = myList[position].name

        val invitedBool: Boolean = myList[position].isInvited
        holder.cardLayout.tag = invitedBool

        if (invitedBool)
            holder.cardLayout.setCardBackgroundColor(ContextCompat.getColor(context!!, R.color.colorAccent))
        else
            holder.cardLayout.setCardBackgroundColor(ContextCompat.getColor(context!!, R.color.cardview_light_background))

        holder.cardLayout.setOnClickListener {
            myList[position].isInvited = !myList[position].isInvited
            notifyDataSetChanged()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idPic: ImageView = view.image_view
        val namePic: TextView = view.text_view
        val cardLayout: CardView = view.card_view
    }
}