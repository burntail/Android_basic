package com.example.tabtest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentFirst:Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("First_fragment_lifecycle","First fragment_onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("First_fragment_lifecycle","First fragment_onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : XML을 화면에 사용할 준비를 한다
        // container : Fragment에서 사용될 XML의 부모뷰
//        inflater.inflate(R.layout.first_fragment,container, false) // container에 first_fragment를 넣겠다
        //attachToRoot : 루트뷰에 붙일지말지 x
        Log.d("First_fragment_lifecycle","First fragment_onCreateView")
        return inflater.inflate(R.layout.fragmentfirst,container, false) // container에 first_fragment를 넣겠다
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("First_fragment_lifecycle","First fragment_onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("First_fragment_lifecycle","First fragment_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("First_fragment_lifecycle","First fragment_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("First_fragment_lifecycle","First fragment_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("First_fragment_lifecycle","First fragment_onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("First_fragment_lifecycle","First fragment_onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("First_fragment_lifecycle","First fragment_onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("First_fragment_lifecycle","First fragment_onDetach")
    }
}