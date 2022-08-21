package com.example.secondjobapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.secondjobapp.db.Client
import com.github.mikephil.charting.utils.Utils.init
import kotlinx.android.synthetic.main.item_client.view.*

class ClientsAdaptor(
    // var clientsList: List<Client>
) : RecyclerView.Adapter<ClientsAdaptor.ClientsViewholder>() {

    private lateinit var mListener: onItemClickListener
    var clientsList: List<Client> = listOf()

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener

    }

    inner class ClientsViewholder(
        itemView: View, //listener: onItemClickListener
    ) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientsViewholder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_client, parent, false)

        return ClientsViewholder(view)
    }


    override fun onBindViewHolder(holder: ClientsViewholder, position: Int) {
        holder.itemView.apply {
            tv_NameClient.text = clientsList[position].name
            tv_AdressClient.text = clientsList[position].adress
            tv_PhoneClient.text = clientsList[position].phoneNumber
        }

    }

    override fun getItemCount(): Int {
        return clientsList.size
    }

    fun updateList(list: List<Client>) {
        clientsList = list
        notifyDataSetChanged()
    }
}