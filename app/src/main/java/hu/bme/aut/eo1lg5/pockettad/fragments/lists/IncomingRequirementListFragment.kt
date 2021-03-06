package hu.bme.aut.eo1lg5.pockettad.fragments.lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.recyclerview.RequirementListAdapter
import kotlinx.android.synthetic.main.fragment_incoming_requirement_list.view.*
import kotlinx.android.synthetic.main.fragment_incoming_to_do_list.view.*


class IncomingRequirementListFragment : Fragment() {

    private lateinit var requirementViewModel: RequirementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_incoming_requirement_list, container, false)

        val adapter = RequirementListAdapter()
        val recyclerView = view.reqListRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        requirementViewModel = ViewModelProvider(this).get(RequirementViewModel::class.java)
        requirementViewModel.readAllData.observe(viewLifecycleOwner, Observer { requirement->
            adapter.setReqList(requirement,requirementViewModel,true)
        })

        return view
    }

}