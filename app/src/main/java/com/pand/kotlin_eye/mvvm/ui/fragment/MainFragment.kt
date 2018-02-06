package com.pand.kotlin_eye.mvvm.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pand.kotlin_eye.R


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }
    
    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        fun newInstance(param1: String, param2: String): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putString(MainFragment.ARG_PARAM1, param1)
            args.putString(MainFragment.ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
