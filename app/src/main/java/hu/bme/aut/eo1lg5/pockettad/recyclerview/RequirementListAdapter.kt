package hu.bme.aut.eo1lg5.pockettad.recyclerview

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement

class RequirementListAdapter : RecyclerView.Adapter<RequirementListAdapter.ViewHolder>() {
    private var requirementList= emptyList<Requirement>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
        val parentLayout: RelativeLayout = view.findViewById(R.id.baseLayout)
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

        holder.parentLayout.setOnClickListener(View.OnClickListener {
            Log.d(ContentValues.TAG, "Cilck on ${requirementList.get(position).toString()}")
            //TODO move to another activity
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