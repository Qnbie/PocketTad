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
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import kotlinx.android.synthetic.main.fragment_requirement_add.*
import kotlinx.android.synthetic.main.fragment_requirement_add.view.*


class RequirementAddFragment : Fragment() {
    private lateinit var requirementViewModel: RequirementViewModel
    private val args by navArgs<RequirementAddFragmentArgs>()

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
        val name = addReqName.text.toString()
        val desc = addReqDesc.text.toString()
        val date = "${datePicker.year}-${datePicker.month}-${datePicker.dayOfMonth}"

        val requirement = Requirement(null, args.subjectId, name, desc, date, false)
        requirementViewModel.addRequirement(requirement)
        findNavController().navigateUp()
    }
}