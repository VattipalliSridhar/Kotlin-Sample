package com.apps.kotlinexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val users: ArrayList<User>,
                      private val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolders>() {

     inner class ViewHolders(itemView: View) : RecyclerView.ViewHolder(itemView),
         View.OnClickListener {
        private val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
        private val layout: LinearLayout = itemView.findViewById<LinearLayout>(R.id.layout)
        val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
        fun bindItems(user: User)
        {
            textViewName.text = user.name
        }
        init {
            layout.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            Log.e("msg",""+position)
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adpter_layout, parent, false)
        return ViewHolders(v)
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
       holder.bindItems(users[position])



    }

    override fun getItemCount() = users.size


}