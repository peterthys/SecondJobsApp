package com.example.secondjobapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.fragments.ClientsFragment
import com.example.secondjobapp.ui.fragments.ClientsFragmentDirections
//import hilt_aggregated_deps._com_example_secondjobapp_ui_fragments_ClientsFragment_GeneratedInjector
import kotlinx.android.synthetic.main.item_client.view.*

class ClientsAdapter(
   private val listener: OnItemClickListener

) : RecyclerView.Adapter<ClientsAdapter.ClientsViewholder>() {

//    private lateinit var mListener: onItemClickListener
    var clientsList: List<Client> = listOf()

//    interface onItemClickListener {
//        fun onItemClick(position: Int)
//    }

//    fun setOnItemClickListener(listener: onItemClickListener) {
//
//        mListener = listener
//
//    }

    inner class ClientsViewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {


        init {
            itemView.setOnClickListener(this)


        }



        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientsAdapter.ClientsViewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_client,
            parent, false)

        return ClientsViewholder(view)
    }

    override fun onBindViewHolder(holder: ClientsViewholder, position: Int) {
        val currentClient = clientsList[position]
        holder.itemView.apply {
            tv_NameClient.text = clientsList[position].name
            tv_AdressClient.text = clientsList[position].adress
            tv_PhoneClient.text = clientsList[position].phoneNumber
            itemClient.setOnClickListener{
                val action = ClientsFragmentDirections.actionClientsFragmentToUpdateFragment(currentClient)
                findNavController().navigate(action)
            }

        }


    }

    override fun getItemCount(): Int {
        return clientsList.size
    }

    fun updateList(list: List<Client>) {
        clientsList = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}