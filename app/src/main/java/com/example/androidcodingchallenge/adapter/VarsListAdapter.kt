package com.example.androidcodingchallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodingchallenge.R
import com.example.androidcodingchallenge.databinding.ItemVarsListBinding
import com.example.androidcodingchallenge.model.acronymresponse.Vars

/**
 * Created by Akash Kumar on 26/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/**
 * Vars list adapter
 *
 * @property varsList
 * @constructor Create empty Vars list adapter
 */
class VarsListAdapter(private val varsList: List<Vars>?) :
    RecyclerView.Adapter<VarsListAdapter.VarsViewHolder>() {

    /**
     * Vars view holder
     *
     * @property itemView
     * @property binding
     * @constructor Create empty Vars view holder
     */
    inner class VarsViewHolder(private val itemView: View, val binding: ItemVarsListBinding) :
        RecyclerView.ViewHolder(itemView)

    /**
     * It inflates the layout and binds the data to the view.
     *
     * @param parent ViewGroup - The ViewGroup into which the new View will be added after it is bound
     * to an adapter position.
     * @param viewType This is the type of the view. It's used when you have multiple view types in
     * your RecyclerView.
     * @return A list of VarsViewHolder objects.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VarsViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_vars_list, parent, false
        ) as ItemVarsListBinding
        return VarsViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: VarsViewHolder, position: Int) {
        if ((varsList?.size ?: 0) > position)
            holder.binding.varsItem = varsList?.get(position)

        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = varsList?.size ?: 0
}