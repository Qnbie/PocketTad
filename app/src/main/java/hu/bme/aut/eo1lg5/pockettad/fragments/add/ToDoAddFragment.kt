package hu.bme.aut.eo1lg5.pockettad.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.SubjectViewModel
import hu.bme.aut.eo1lg5.pockettad.database.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import kotlinx.android.synthetic.main.fragment_subject_add.*
import kotlinx.android.synthetic.main.fragment_subject_add.view.*
import kotlinx.android.synthetic.main.fragment_to_do_add.*
import java.time.Instant
import java.util.*


class ToDoAddFragment : Fragment() {
    private lateinit var todoViewModel: ToDoViewModel

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


        val todo = ToDo(0, 0, name, desc, false)
        todoViewModel.addToDo(todo)
        //findNavController().navigate(R.id.action_toDoAddFragment_to_toDoListFragment)
    }

}