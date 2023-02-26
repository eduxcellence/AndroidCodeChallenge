package com.example.androidcodingchallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodingchallenge.R
import com.example.androidcodingchallenge.databinding.ItemAcronymBinding
import com.example.androidcodingchallenge.model.acronymresponse.Lfs
/**
 * Created by Akash Kumar on 26/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */

/**
 * Search acronym adapter
 *
 * @property searchAcronymLfsList
 * @constructor Create empty Search acronym adapter
 */
class SearchAcronymAdapter(private val searchAcronymLfsList: List<Lfs>?) :
    RecyclerView.Adapter<SearchAcronymAdapter.LfsViewHolder>() {

    /**
     * Lfs view holder
     *
     * @property itemView
     * @property binding
     * @constructor Create empty Lfs view holder
     */
    inner class LfsViewHolder(private val itemView: View, val binding: ItemAcronymBinding) :
        RecyclerView.ViewHolder(itemView) {}


    /**
     *
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an
     * adapter position.
     * @param viewType The type of the View to be inflated.
     * @return The number of items in the list.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LfsViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_acronym, parent, false
        ) as ItemAcronymBinding
        return LfsViewHolder(binding.root, binding)
    }


    override fun onBindViewHolder(holder: LfsViewHolder, position: Int) {
        if ((searchAcronymLfsList?.size ?: 0) > position)
            holder.binding.searchAcronymLfs = searchAcronymLfsList?.get(position)
        holder.binding.rvAcronymVars.adapter = VarsListAdapter(searchAcronymLfsList?.get(position)?.vars)
        holder.binding.executePendingBindings()
    }


    override fun getItemCount() = searchAcronymLfsList?.size ?: 0
}