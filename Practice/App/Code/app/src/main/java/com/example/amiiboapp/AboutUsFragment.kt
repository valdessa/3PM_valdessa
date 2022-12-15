package com.example.amiiboapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutUsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */



class AboutUsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goBack2 : Button = view.findViewById(R.id.goBackButton2)
        val sendButton : Button = view.findViewById(R.id.sendButton)
        val valText : TextView = view.findViewById(R.id.SendText)

        goBack2.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
               activity?.onBackPressed()
            }
        })

        sendButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if(valText.length() > 1){
                    valText.text = ""
                    Toast.makeText(activity, HtmlCompat.fromHtml("<font color= '#228B22'> <b>"
                            + "MESSAGE SENDED :D" + "</b></font>", 0),
                        Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(activity, HtmlCompat.fromHtml("<font color= '#FF2400'> <b>"
                            + "ENTER A VALID TEXT!" + "</b></font>", 0),
                        Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutUsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutUsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}