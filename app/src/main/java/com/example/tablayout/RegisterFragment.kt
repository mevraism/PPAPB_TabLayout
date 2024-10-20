package com.example.tablayout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tablayout.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    private lateinit var binding: FragmentRegisterBinding

    private var _registerBinding: FragmentRegisterBinding? = null
    private val registerBinding get() = _registerBinding!!
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

        _registerBinding = FragmentRegisterBinding.inflate(inflater,container,false)
            registerBinding.btnRegis.setOnClickListener {
                val username = registerBinding.etUserRegis.text.toString()
                val email = registerBinding.etEmailRegis.text.toString()
                val phone = registerBinding.etPhoneRegis.text.toString()
                val password = registerBinding.etPassRegis.text.toString()
                if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                        getActivity(),
                        "Please fill in all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                    val intent = Intent(requireContext(), MainActivity2::class.java).apply {
                        putExtra("Username",username)
                    }
                    startActivity(intent)

            }
        return  registerBinding.root
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _registerBinding = null // Clear the binding reference to avoid memory leaks
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        const val EXTRA_NAME = "extra_name"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}