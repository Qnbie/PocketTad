package hu.bme.aut.eo1lg5.pockettad.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import kotlinx.android.synthetic.main.fragment_subject_add.view.*
import kotlinx.android.synthetic.main.fragment_to_do_add.*


class RequirementAddFragment : Fragment() {
    private lateinit var requirementViewModel: RequirementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_requirement_add, container, false)

        requirementViewModel = ViewModelProvider(this).get(RequirementViewModel::class.java)

        view.bAdd.setOnClickListener{
            insertRequirementToDatabase()
        }

        return view
    }

    private fun insertRequirementToDatabase() {
        val name = addToDoName.text.toString()
        val desc = addToDoDesc.text.toString()


        val requirement = Requirement(0, 0, name, desc, false)
        requirementViewModel.addRequirement(requirement)
        findNavController().navigate(R.id.action_requirementAddFragment_to_subjectDetailFragment)
    }
}