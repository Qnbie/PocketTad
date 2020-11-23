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
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.recyclerview.ToDoListAdapter
import kotlinx.android.synthetic.main.fragment_requirement_detail.view.*


class RequirementDetailFragment : Fragment() {

    private lateinit var toDoViewModel: ToDoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_requirement_detail, container, false)

        val adapter = ToDoListAdapter()
        val recyclerView = view.todoList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        toDoViewModel.readAllData.observe(viewLifecycleOwner, Observer { todo->
            adapter.setToDoList(todo)
        })

        view.addToDo.setOnClickListener{
            findNavController().navigate(R.id.action_requirementDetailFragment_to_toDoAddFragment)
        }

        return view
    }
}