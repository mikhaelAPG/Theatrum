package com.example.theatrum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theatrum.adapter.TicketAdapter
import com.example.theatrum.listener.OnItemClickListener
import com.example.theatrum.model.Ticket
import kotlinx.android.synthetic.main.fragment_ticket.*

class TicketFragment : Fragment() {

    lateinit var ticketAdapter: TicketAdapter
    val lm = LinearLayoutManager(activity)
    val addTicketList: MutableList<Ticket> = ArrayList()
    var isLoading = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        action()
    }

    fun initView() {
        rv_ticket.layoutManager = lm
        ticketAdapter = TicketAdapter(requireActivity())
        rv_ticket.adapter = ticketAdapter

        addTicketList.add(Ticket("Ticket A", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addTicketList.add(Ticket("Ticket B", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addTicketList.add(Ticket("Ticket C", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addTicketList.add(Ticket("Ticket D", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addTicketList.add(Ticket("Ticket E", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addTicketList.add(Ticket("Ticket F", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addTicketList.add(Ticket("Ticket G", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))

        ticketAdapter.setTicket(addTicketList)
    }

    fun action() {
        ticketAdapter.setOnClickListener(object : OnItemClickListener{
            override fun onItemClick(item: View, position: Int) {
                var i = Intent(context, TicketDetailActivity::class.java)
                i.putExtra("title", ticketAdapter.getTicket().get(position).getTitle())
                i.putExtra("description", ticketAdapter.getTicket().get(position).getDescription())
                startActivity(i)
            }

        })

        rv_ticket.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if(dy > 0) {
                    var vItem = lm.childCount
                    var lItem = lm.findFirstCompletelyVisibleItemPosition()
                    var count = ticketAdapter.itemCount

                    if (!isLoading) {
                        if (vItem + lItem >= count) {
                            addMoreData()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun addMoreData() {
        isLoading = true
        pg_bar.visibility = View.VISIBLE
        for (i in 0..6) {
            addTicketList.add(Ticket("Ticket ke-" + i + "", "Lorem Ipsum Sing Amet Wedus Lara Aporto ."))
        }

        Handler().postDelayed({
            isLoading = false
            pg_bar.visibility = View.GONE
            ticketAdapter.setTicket(addTicketList)
        }, 5000)

    }
}