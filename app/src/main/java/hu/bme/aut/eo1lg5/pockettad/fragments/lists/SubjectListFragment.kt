package hu.bme.aut.eo1lg5.pockettad.fragments.lists

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
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.SubjectViewModel
import hu.bme.aut.eo1lg5.pockettad.recyclerview.SubjectListAdapter
import kotlinx.android.synthetic.main.fragment_subject_list.*
import kotlinx.android.synthetic.main.fragment_subject_list.view.*

class SubjectListFragment : Fragment() {

    private lateinit var subjectViewModel: SubjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_subject_list,container,false)

        //RecyclerView
        val adapter =
            SubjectListAdapter()
        val recyclerView = view.rvListFragment
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)
        subjectViewModel.readAllData.observe(viewLifecycleOwner, Observer { subject->
            adapter.setSubList(subject)
        })

        view.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_subListFragment_to_subAddFragment)
        }


        view.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.incommingToDo -> findNavController().navigate(R.id.action_subListFragment_to_incomingToDoListFragment)
                R.id.incommingReq -> findNavController().navigate(R.id.action_subListFragment_to_incomingRequirementListFragment)
            }
            true
        }

        return view
    }
}