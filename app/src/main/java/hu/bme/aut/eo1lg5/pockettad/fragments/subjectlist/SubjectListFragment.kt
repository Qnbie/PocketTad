package hu.bme.aut.eo1lg5.pockettad.fragments.subjectlist

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
import hu.bme.aut.eo1lg5.pockettad.database.DatabaseViewModel
import kotlinx.android.synthetic.main.fragment_subject_list.view.*

class SubjectListFragment : Fragment() {

    private lateinit var databaseViewModel: DatabaseViewModel

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
        databaseViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)
        databaseViewModel.readAllData.observe(viewLifecycleOwner, Observer {subject->
            adapter.setSubList(subject)
        })

        view.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_subListFragment_to_subAddFragment)
        }

        return view
    }
}