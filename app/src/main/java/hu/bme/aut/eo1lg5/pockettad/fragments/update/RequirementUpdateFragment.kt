package hu.bme.aut.eo1lg5.pockettad.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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

        view.updateReqName.setText( args.currentRequirement.name)
        view.updateReqDesc.setText(args.currentRequirement.desc)

        view.bUpdate.setOnClickListener{
            updateRequirement()
        }

        return view
    }

    private fun updateRequirement(){
        val name = updateReqName.text.toString()
        val desc = updateReqDesc.text.toString()

        val updatedRequirement = Requirement(args.currentRequirement.id,args.currentRequirement.subjectId,name,desc,args.currentRequirement.done)
        requirementViewModel.updateRequirement(updatedRequirement)
        //TODO back to prew view
    }
}