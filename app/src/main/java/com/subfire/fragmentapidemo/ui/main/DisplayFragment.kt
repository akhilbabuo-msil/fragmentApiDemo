package com.subfire.fragmentapidemo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentResultListener
import com.subfire.fragmentapidemo.R

class DisplayFragment : Fragment() {
    companion object{
        const val Result_Key="someKeyToGetValue"
        const val STRING_KEY="stringgvalue"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recivedTextview = view.findViewById<TextView>(R.id.recivedText)
        requireActivity().supportFragmentManager
            .setFragmentResultListener(
                Result_Key,
                viewLifecycleOwner,
                 { requestKey, result ->
                     val stringVal = result.getString(STRING_KEY,"didnt got value")
                     recivedTextview.text = stringVal
                     Log.d("value", "onViewCreated: ")
                 })
    }

}