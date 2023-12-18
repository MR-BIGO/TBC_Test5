package com.example.tbc_test5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tbc_test5.databinding.MainRecyclerLayoutBinding
import com.example.tbc_test5.models.ActiveCourse

class VerticalActiveRecyclerAdapter :
    ListAdapter<ActiveCourse, VerticalActiveRecyclerAdapter.VerticalActiveViewHolder>(
        ItemDiffUtil()
    ) {

    inner class VerticalActiveViewHolder(private val binding: MainRecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val course = currentList[adapterPosition]
            with(binding) {
                tvTitle.text = course.title
                tvBookingTime.text = course.bookingTime
                Glide.with(itemView.context).load(course.image).into(ivIcon)
            }
        }
    }

    class ItemDiffUtil : DiffUtil.ItemCallback<ActiveCourse>() {
        override fun areItemsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalActiveViewHolder {
        return VerticalActiveViewHolder(
            MainRecyclerLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerticalActiveViewHolder, position: Int) {
        holder.bind()
    }
}