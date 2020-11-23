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
import hu.bme.aut.eo1lg5.pockettad.database.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.recyclerview.ToDoListAdapter
import kotlinx.android.synthetic.main.fragment_subject_list.view.*

class ToDoListFragment : Fragment() {

    private lateinit var toDoListviewModel: ToDoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_to_do_list, container, false)

        val adapter = ToDoListAdapter()
        val recyclerView = view.rvListFragment
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        toDoListviewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        toDoListviewModel.readAllData.observe(viewLifecycleOwner, Observer { todo->
            adapter.setToDoList(todo)
        })

        return view
    }
}