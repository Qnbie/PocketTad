package hu.bme.aut.eo1lg5.pockettad.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.SubjectViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import kotlinx.android.synthetic.main.fragment_subject_update.*
import kotlinx.android.synthetic.main.fragment_subject_update.view.*

class SubjectUpdateFragment : Fragment() {
    private lateinit var subjectViewModel: SubjectViewModel
    private lateinit var args: Subject

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_subject_update, container, false)

        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        view.updateSubName.setText( args.name)
        view.updateSubDesc.setText(args.description)
        view.updateSubWeb.setText(args.webpage)

        view.bUpdate.setOnClickListener{
            updateSubject()
        }

        return view
    }

    private fun updateSubject(){
        val name = updateSubName.text.toString()
        val desc = updateSubDesc.text.toString()
        val web = updateSubWeb.text.toString()

        val updatedSubject = Subject(args.id,name,desc,web,args.done)
        subjectViewModel.updateSubject(updatedSubject)
        //TODO back to prew view
    }
}