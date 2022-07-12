package com.example.seanote.testView

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.seanote.R

class TestWidgetAdapter(
    private var itemsIsPushed: MutableList<Boolean>,
    private val listener: TestOnClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val colors = mutableListOf<Int>()

    fun setColor(colors: List<Int>) {
        this.colors.addAll(colors)
        notifyDataSetChanged()
    }

    private val itemPushedListener = object : TestPushedOnClickListener {
        override fun onClick(isPushed: Boolean, position: Int) {
            if (isPushed) {
                val size = itemsIsPushed.size
                itemsIsPushed = MutableList(size) { false }
                itemsIsPushed[position] = isPushed
            } else {
                itemsIsPushed[position] = isPushed
                itemsIsPushed[0] = true
            }
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FIRST -> {
                FirstViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_edit_note_view, parent, false),
                    listener,
                    itemPushedListener
                )
            }
            OTHER -> {
                ViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_edit_note_view, parent, false),
                    listener,
                    itemPushedListener
                )
            }
            else -> {
                ViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_edit_note_view, parent, false),
                    listener,
                    itemPushedListener
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FirstViewHolder -> holder.bind(itemsIsPushed[0])
            is ViewHolder -> holder.bind(colors[position], itemsIsPushed[position], position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) FIRST
        else OTHER
    }

    override fun getItemCount(): Int = colors.size

    companion object {
        private const val FIRST = 0
        private const val OTHER = 1
    }
}

class FirstViewHolder(
    view: View,
    private val listener: TestOnClickListener,
    private val pushedListener: TestPushedOnClickListener
) : RecyclerView.ViewHolder(view) {
    private val indicator = itemView.findViewById<View>(R.id.indicator)
    private val item = itemView.findViewById<ImageView>(R.id.item_edit_note)

    fun bind(itemIsPushed: Boolean) {
        with(item) {
            background.setTint(Color.parseColor("#86B6FF"))
            setImageResource(R.drawable.ic_unselected)
            if (itemIsPushed) indicator.visibility = View.VISIBLE
            else indicator.visibility = View.GONE
            setOnClickListener {
                indicator.visibility = View.VISIBLE
                listener.onClick(Color.parseColor("#86B6FF"))
                pushedListener.onClick(true, 0)
            }
        }
    }
}

class ViewHolder(
    view: View,
    private val listener: TestOnClickListener,
    private val pushedListener: TestPushedOnClickListener
) :
    RecyclerView.ViewHolder(view) {
    private val indicator = itemView.findViewById<View>(R.id.indicator)
    private val item = itemView.findViewById<ImageView>(R.id.item_edit_note)
    fun bind(color: Int, itemIsPushed: Boolean, position: Int) {
        with(item) {
            background.setTint(color)
            if (itemIsPushed) {
                indicator.visibility = View.VISIBLE
            } else {
                indicator.visibility = View.GONE
            }
            setOnClickListener {
                if (itemIsPushed) {
                    listener.onClick(Color.parseColor("#86B6FF"))
                    pushedListener.onClick(false, position)
                } else {
                    listener.onClick(color)
                    pushedListener.onClick(true, position)
                }
            }
        }
    }
}
