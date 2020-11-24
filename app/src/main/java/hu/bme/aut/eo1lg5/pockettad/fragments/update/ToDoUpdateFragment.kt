package hu.bme.aut.eo1lg5.pockettad.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import kotlinx.android.synthetic.main.fragment_to_do_update.*
import kotlinx.android.synthetic.main.fragment_to_do_update.view.*


class ToDoUpdateFragment : Fragment() {

    private lateinit var toDoViewModel: ToDoViewModel
    private val args by navArgs<ToDoUpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_to_do_update, container, false)

        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)

        view.updateToDoName.setText( args.currentToDo?.name)
        view.updateToDoDesc.setText(args.currentToDo?.description)

        view.bUpdate.setOnClickListener{
            updateToDo()
        }

        view.bDelete.setOnClickListener{
            deleteToDo()
        }

        return view
    }

    private fun updateToDo(){
        val name = updateToDoName.text.toString()
        val desc = updateToDoDesc.text.toString()
        val date = "${datePicker.year}-${datePicker.month}-${datePicker.dayOfMonth}"

        val updatedToDo = ToDo(args.currentToDo!!.id, args.currentToDo!!.requirementId,name,desc,date, args.currentToDo!!.done)
        toDoViewModel.updateToDo(updatedToDo)
        findNavController().navigateUp()
    }

    private fun deleteToDo(){
        args.currentToDo?.let { toDoViewModel.deleteToDo(it) }
        Toast.makeText(
            requireContext(),
            "${args.currentToDo?.name} deleted",
            Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }
}