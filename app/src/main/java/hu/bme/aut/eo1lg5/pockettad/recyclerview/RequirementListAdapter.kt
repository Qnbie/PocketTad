package hu.bme.aut.eo1lg5.pockettad.recyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.RequirementViewModel
import hu.bme.aut.eo1lg5.pockettad.fragments.detail.SubjectDetailFragmentDirections
import hu.bme.aut.eo1lg5.pockettad.fragments.lists.IncomingRequirementListFragmentDirections
import kotlinx.android.synthetic.main.reqlist_listitem.view.*
import kotlinx.android.synthetic.main.reqlist_listitem.view.settingsButton

class RequirementListAdapter : RecyclerView.Adapter<RequirementListAdapter.ViewHolder>() {
    private var requirementList= emptyList<Requirement>()
    private lateinit var requirementViewModel: RequirementViewModel
    private var incoming = false

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
        val switchDone: Switch = view.findViewById(R.id.switchDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.reqlist_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = requirementList[position]
        holder.itemName.text = currentItem.name.toString()
        holder.switchDone.setChecked(currentItem.done)

        holder.itemView.reqListItem.setOnClickListener(View.OnClickListener {
            val action:NavDirections
            if(incoming) action = IncomingRequirementListFragmentDirections.actionIncomingRequirementListFragmentToRequirementDetailFragment(currentItem)
            else action = SubjectDetailFragmentDirections.actionSubjectDetailFragmentToRequirementDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        })

        holder.itemView.settingsButton.setOnClickListener{
            val action:NavDirections
            if(incoming) action = IncomingRequirementListFragmentDirections.actionIncomingRequirementListFragmentToRequirementDetailFragment(currentItem)
            else action = SubjectDetailFragmentDirections.actionSubjectDetailFragmentToRequirementUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

        holder.switchDone.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            val updatedItem = currentItem
            updatedItem.done = b
            requirementViewModel.updateRequirement(updatedItem)
        }
    }

    override fun getItemCount(): Int {
        return requirementList.size
    }

    fun setReqList(reuirement: List<Requirement>, requirementViewModel: RequirementViewModel,incoming:Boolean){
        this.requirementViewModel = requirementViewModel
        this.incoming = incoming
        requirementList = reuirement
        notifyDataSetChanged()
    }
}