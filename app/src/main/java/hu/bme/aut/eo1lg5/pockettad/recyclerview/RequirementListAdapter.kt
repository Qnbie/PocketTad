package hu.bme.aut.eo1lg5.pockettad.recyclerview

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import hu.bme.aut.eo1lg5.pockettad.fragments.detail.SubjectDetailFragmentDirections
import kotlinx.android.synthetic.main.reqlist_listitem.view.*

class RequirementListAdapter : RecyclerView.Adapter<RequirementListAdapter.ViewHolder>() {
    private var requirementList= emptyList<Requirement>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.reqlist_listitem, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = requirementList[position]
        holder.itemName.text = currentItem.name.toString()

        holder.itemView.reqListItem.setOnClickListener(View.OnClickListener {
            val action = SubjectDetailFragmentDirections.actionSubjectDetailFragmentToRequirementDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        })
    }

    override fun getItemCount(): Int {
        return requirementList.size
    }

    fun setReqList(reuirement: List<Requirement>){
        requirementList = reuirement
        notifyDataSetChanged()
    }
}