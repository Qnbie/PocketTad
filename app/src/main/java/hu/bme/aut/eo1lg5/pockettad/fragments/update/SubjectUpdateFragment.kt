package hu.bme.aut.eo1lg5.pockettad.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.SubjectViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import kotlinx.android.synthetic.main.fragment_subject_update.*
import kotlinx.android.synthetic.main.fragment_subject_update.view.*

class SubjectUpdateFragment : Fragment() {
    private lateinit var subjectViewModel: SubjectViewModel
    private val args by navArgs<SubjectUpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_subject_update, container, false)

        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        view.updateSubName.setText( args.currentSubject.name)
        view.updateSubDesc.setText(args.currentSubject.description)
        view.updateSubWeb.setText(args.currentSubject.webpage)

        view.bUpdate.setOnClickListener{
            updateSubject()
        }

        return view
    }

    private fun updateSubject(){
        val name = updateSubName.text.toString()
        val desc = updateSubDesc.text.toString()
        val web = updateSubWeb.text.toString()

        val updatedSubject = Subject(args.currentSubject.id,name,desc,web,args.currentSubject.done)
        subjectViewModel.updateSubject(updatedSubject)
        findNavController().navigate(R.id.action_subjectUpdateFragment_to_subjectDetailFragment)
    }
}