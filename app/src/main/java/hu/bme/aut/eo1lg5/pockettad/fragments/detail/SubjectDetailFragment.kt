package hu.bme.aut.eo1lg5.pockettad.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.recyclerview.RequirementListAdapter
import kotlinx.android.synthetic.main.fragment_subject_detail.view.*


class SubjectDetailFragment : Fragment() {

    private lateinit var requirementViewModel: RequirementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_subject_detail, container, false)

        val adapter =
            RequirementListAdapter()
        val recyclerView = view.requiementList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        requirementViewModel = ViewModelProvider(this).get(RequirementViewModel::class.java)
        requirementViewModel.readAllData.observe(viewLifecycleOwner, Observer { requirement->
            adapter.setReqList(requirement)
        })

        view.addRequirement.setOnClickListener{
            findNavController().navigate(R.id.action_subjectDetailFragment_to_requirementAddFragment)
        }

        return view
    }
}