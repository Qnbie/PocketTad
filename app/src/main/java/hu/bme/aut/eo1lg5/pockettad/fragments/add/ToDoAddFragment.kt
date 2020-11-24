package hu.bme.aut.eo1lg5.pockettad.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import kotlinx.android.synthetic.main.fragment_subject_add.view.*
import kotlinx.android.synthetic.main.fragment_to_do_add.*


class ToDoAddFragment : Fragment() {
    private lateinit var todoViewModel: ToDoViewModel
    private val args by navArgs<ToDoAddFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_to_do_add, container, false)

        todoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)

        view.bAdd.setOnClickListener{
            insertToDoToDatabase()
        }

        return view
    }

    private fun insertToDoToDatabase() {
        val name = addToDoName.text.toString()
        val desc = addToDoDesc.text.toString()
        val date = "${datePicker.year}-${datePicker.month}-${datePicker.dayOfMonth}"

        val todo = ToDo(null, args.requirementId, name, desc, date, false)
        todoViewModel.addToDo(todo)
        //findNavController().navigate(R.id.action_toDoAddFragment_to_requirementDetailFragment)
        findNavController().navigateUp()
    }

}