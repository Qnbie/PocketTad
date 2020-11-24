package hu.bme.aut.eo1lg5.pockettad.fragments.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.recyclerview.ToDoListAdapter
import kotlinx.android.synthetic.main.fragment_requirement_detail.view.*


class RequirementDetailFragment : Fragment() {

    private lateinit var toDoViewModel: ToDoViewModel
    private val args by navArgs<RequirementDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_requirement_detail, container, false)

        view.requirementName.text = args.currentRequirement?.name
        view.requirementDesc.text = args.currentRequirement?.desc

        val adapter = ToDoListAdapter()
        val recyclerView = view.todoList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        args.currentRequirement?.id?.let {
            toDoViewModel.getToDoByReqId(it).observe(viewLifecycleOwner, Observer { todo->
                adapter.setToDoList(todo,toDoViewModel)
            })
        }

        view.addToDo.setOnClickListener{
            val action = args.currentRequirement?.id?.let { it1 ->
                RequirementDetailFragmentDirections.actionRequirementDetailFragmentToToDoAddFragment(
                    it1
                )
            }
            if (action != null) {
                findNavController().navigate(action)
            }
        }

        return view
    }
}