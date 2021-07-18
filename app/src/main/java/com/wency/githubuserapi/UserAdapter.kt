package com.wency.githubuserapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wency.githubuserapi.data.User
import com.wency.githubuserapi.databinding.ItemUser1Binding
import com.wency.githubuserapi.databinding.ItemUser2Binding

class UserAdapter: ListAdapter<User, RecyclerView.ViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            user1 -> user1ViewHolder(ItemUser1Binding.inflate(layoutInflater, parent, false))
            user2 -> user2ViewHolder(ItemUser2Binding.inflate(layoutInflater, parent, false))
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = getItem(position)
        when (holder){
            is user1ViewHolder -> {
                holder.bind(user)
            }
            is user2ViewHolder -> {
                holder.bind(user)
            }
        }
    }

    class user1ViewHolder(val binding: ItemUser1Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.user = user
            binding.executePendingBindings()
        }
    }
    class user2ViewHolder(val binding: ItemUser2Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.user = user
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2){
            0 -> user1
            1 -> user2
            else -> user1
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
        const val user1 = 0x00
        const val user2 = 0x01
    }
}