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
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import kotlinx.android.synthetic.main.fragment_requirement_update.*
import kotlinx.android.synthetic.main.fragment_requirement_update.view.*
import kotlinx.android.synthetic.main.fragment_subject_update.view.bUpdate

class RequirementUpdateFragment : Fragment() {

    private lateinit var requirementViewModel: RequirementViewModel
    private val args by navArgs<RequirementUpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_requirement_update, container, false)

        requirementViewModel = ViewModelProvider(this).get(RequirementViewModel::class.java)

        view.updateReqName.setText( args.currentRequirement?.name)
        view.updateReqDesc.setText(args.currentRequirement?.desc)

        view.bUpdate.setOnClickListener{
            updateRequirement()
        }

        view.bDelete.setOnClickListener {
            deleteRequirement()
        }

        return view
    }

    private fun updateRequirement(){
        val name = updateReqName.text.toString()
        val desc = updateReqDesc.text.toString()

        val updatedRequirement = args.currentRequirement?.done?.let {
            Requirement(
                args.currentRequirement!!.id, args.currentRequirement!!.subjectId,name,desc,
                it
            )
        }
        if (updatedRequirement != null) {
            requirementViewModel.updateRequirement(updatedRequirement)
        }
        findNavController().navigateUp()
    }

    private fun deleteRequirement(){
        args.currentRequirement?.let { requirementViewModel.deleteRequirement(it) }
        Toast.makeText(
            requireContext(),
            "${args.currentRequirement?.name} deleted",
            Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }
}