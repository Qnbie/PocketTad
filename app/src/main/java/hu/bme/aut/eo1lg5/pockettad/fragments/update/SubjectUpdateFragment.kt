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

        view.updateSubName.setText( args.currentSubject?.name)
        view.updateSubDesc.setText(args.currentSubject?.description)
        view.updateSubWeb.setText(args.currentSubject?.webpage)

        view.bUpdate.setOnClickListener{
            updateSubject()
        }

        view.bDelete.setOnClickListener{
            deleteSubject()
        }

        return view
    }

    private fun updateSubject(){
        val name = updateSubName.text.toString()
        val desc = updateSubDesc.text.toString()
        val web = updateSubWeb.text.toString()

        val updatedSubject =
            args.currentSubject?.done?.let {
                Subject(
                    args.currentSubject!!.id,name,desc,web,
                    it
                )
            }
        if (updatedSubject != null) {
            subjectViewModel.updateSubject(updatedSubject)
        }
        findNavController().navigateUp()
    }

    private fun deleteSubject(){
        args.currentSubject?.let { subjectViewModel.deleteSubject(it) }
        Toast.makeText(
            requireContext(),
            "${args.currentSubject?.name} deleted",
            Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }
}