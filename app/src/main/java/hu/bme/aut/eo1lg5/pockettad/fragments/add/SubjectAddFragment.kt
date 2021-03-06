package hu.bme.aut.eo1lg5.pockettad.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.SubjectViewModel
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import kotlinx.android.synthetic.main.fragment_subject_add.*
import kotlinx.android.synthetic.main.fragment_subject_add.view.*


class SubjectAddFragment : Fragment() {

    private lateinit var subjectViewModel: SubjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_subject_add, container, false)

        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        view.bAdd.setOnClickListener{
            insertSubjectToDatabase()
        }

        return view
    }

    private fun insertSubjectToDatabase() {
        val name = addSubName.text.toString()
        val desc = addSubDesc.text.toString()
        val web = addSubWeb.text.toString()

        val subject = Subject(null, name,desc,web,false)
        subjectViewModel.addSubject(subject)
        findNavController().navigateUp()
    }

}