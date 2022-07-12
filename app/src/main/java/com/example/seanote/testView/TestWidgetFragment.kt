package com.example.seanote.testView

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seanote.R

class TestWidgetFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterWidget: TestWidgetAdapter
    private val listener = object : TestOnClickListener {
        override fun onClick(color: Int) {
            view?.setBackgroundColor(color)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.test_fragment_widget, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(view)
        adapterWidget =
            TestWidgetAdapter(getPushedItemColor(), listener)
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.edit_note_rv)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterWidget
        }
        adapterWidget.setColor(getColors())
    }

    private fun initToolbar(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        with(toolbar) {
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun getColors(): List<Int> {
        val typedArray = requireContext().resources.obtainTypedArray(R.array.background_colors)
        val colors = mutableListOf<Int>()
        for (i in 0..(typedArray.length() - 1)) {
            colors.add(i, typedArray.getColor(i, 0))
        }
        typedArray.recycle()
        return colors.toList()
    }

    private fun getPushedItemColor(): MutableList<Boolean> {
        val typedArray = requireContext().resources.obtainTypedArray(R.array.background_colors)
        val itemColorIsPushed = MutableList(typedArray.length()) { false }
        itemColorIsPushed[0] = true
        typedArray.recycle()
        return itemColorIsPushed
    }

    companion object {
        fun newInstance(): TestWidgetFragment {
            return TestWidgetFragment()
        }
    }
}