package com.example.theatrum.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.theatrum.R
import com.example.theatrum.TicketDetailActivity
import com.example.theatrum.listener.OnItemClickListener
import com.example.theatrum.model.Ticket

class TicketAdapter(val context: Context): RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    private val tickets : MutableList<Ticket> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false))
    }

    override fun onBindViewHolder(holder: TicketAdapter.TicketViewHolder, position: Int) {
        holder.bindModel(tickets[position])
    }

    fun getTicket(): MutableList<Ticket> {
        return tickets
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

    fun setTicket(data: List<Ticket>) {
        tickets.clear()
        tickets.addAll(data)
        notifyDataSetChanged()
    }

    inner class TicketViewHolder(item: View): RecyclerView.ViewHolder(item) {

        val txtTitles: TextView = item.findViewById(R.id.tv_title)
        val txtDescription: TextView = item.findViewById(R.id.tv_description)
        val cardViewTicket: CardView = item.findViewById(R.id.cv_ticket)

        fun bindModel(t: Ticket) {
            txtTitles.text = t.getTitle()
            txtDescription.text = t.getDescription()

//            cardViewTicket.setOnClickListener {
//                var i = Intent(context, TicketDetailActivity::class.java)
//                i.putExtra("title", t.getTitle())
//                i.putExtra("description", t.getDescription())
//                context.startActivity(i)
//            }
        }

        init {
            cardViewTicket.setOnClickListener { onSelectedListener?.onItemClick(it, layoutPosition) }
        }
    }

    fun setOnClickListener(onClickItemListener: OnItemClickListener) {
        this.onSelectedListener = onClickItemListener
    }
}