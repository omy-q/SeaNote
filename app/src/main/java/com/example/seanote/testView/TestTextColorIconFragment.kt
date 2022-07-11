package com.example.seanote.testView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.seanote.R

class TestTextColorIconFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.test_fragment_text_color_icon, container, false)
    }

    companion object {
        fun newInstance(): TestTextColorIconFragment{
            return TestTextColorIconFragment()
        }
    }
}