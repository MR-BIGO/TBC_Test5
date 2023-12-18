package com.example.tbc_test5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_test5.databinding.NestedRvItemBinding
import com.example.tbc_test5.models.NewCourse

class HorizontalNewRecyclerAdapter :
    ListAdapter<NewCourse, HorizontalNewRecyclerAdapter.HorizontalNewViewHolder>(ItemDiffUtil()) {

    inner class HorizontalNewViewHolder(private val binding: NestedRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val course = currentList[adapterPosition]
            with(binding) {
                tvId.text = course.id.toString()
                tvTitle.text = course.title
                tvDuration.text = course.duration.toString()
                tvQuestion.text = course.question
                tvIconType.text = course.iconType
                tvMainColor.text = course.mainColor
            }
        }
    }

    class ItemDiffUtil : DiffUtil.ItemCallback<NewCourse>() {
        override fun areItemsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalNewViewHolder {
        return HorizontalNewViewHolder(
            NestedRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HorizontalNewViewHolder, position: Int) {
        holder.bind()
    }
}