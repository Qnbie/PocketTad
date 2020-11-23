package hu.bme.aut.eo1lg5.pockettad.recyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import hu.bme.aut.eo1lg5.pockettad.fragments.detail.SubjectDetailFragmentDirections
import hu.bme.aut.eo1lg5.pockettad.fragments.lists.SubjectListFragmentDirections
import kotlinx.android.synthetic.main.sublist_listitem.view.*


class SubjectListAdapter: RecyclerView.Adapter<SubjectListAdapter.ViewHolder>() {
    private var subjectList= emptyList<Subject>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sublist_listitem, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = subjectList[position]
        holder.itemName.text = currentItem.name

        holder.itemView.subListItem.setOnClickListener(View.OnClickListener {
            val action = SubjectListFragmentDirections.actionSubListFragmentToSubjectDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        })

        holder.itemView.settingsButton.setOnClickListener{
            val action = SubjectListFragmentDirections.actionSubListFragmentToSubjectUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    fun setSubList(subject: List<Subject>){
        subjectList = subject
        notifyDataSetChanged()
    }
}