package hu.bme.aut.eo1lg5.pockettad.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.database.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import kotlinx.android.synthetic.main.fragment_requirement_update.*
import kotlinx.android.synthetic.main.fragment_requirement_update.view.*
import kotlinx.android.synthetic.main.fragment_requirement_update.view.bUpdate
import kotlinx.android.synthetic.main.fragment_subject_update.view.*
import kotlinx.android.synthetic.main.fragment_to_do_update.*
import kotlinx.android.synthetic.main.fragment_to_do_update.view.*


class ToDoUpdateFragment : Fragment() {

    private lateinit var toDoViewModel: ToDoViewModel
    private lateinit var args: ToDo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_to_do_update, container, false)

        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)

        view.updateToDoName.setText( args.name)
        view.updateToDoDesc.setText(args.description)

        view.bUpdate.setOnClickListener{
            updateToDo()
        }

        return view
    }

    private fun updateToDo(){
        val name = updateToDoName.text.toString()
        val desc = updateToDoDesc.text.toString()

        val updatedToDo = ToDo(args.id,args.requirementId,name,desc,args.done)
        toDoViewModel.updateToDo(updatedToDo)
        //TODO back to prew view
    }
}