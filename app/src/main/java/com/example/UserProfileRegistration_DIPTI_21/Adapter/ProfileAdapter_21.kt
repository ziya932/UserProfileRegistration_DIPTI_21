package com.example.UserProfileRegistration_DIPTI_21.Adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21
import com.example.UserProfileRegistration_DIPTI_21.R

class ProfileAdapter():ListAdapter<UserProfile_21, ProfileAdapter.ProfileViewHolder>(DiffCallback()) {
    private lateinit var  OnItemClickListener:((UserProfile_21)->Unit)
    private lateinit var  OnDeleteClickListener:((UserProfile_21)->Unit)
    private lateinit var  OnUpdateClickListener:((UserProfile_21)->Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_layout, parent, false)
        return ProfileViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    fun setOnItemClickListener(listener: (UserProfile_21) -> Unit) {

        OnItemClickListener = listener
    }
    fun setOnDeleteClickListener(listener: (UserProfile_21) -> Unit) {
        OnDeleteClickListener = listener
    }
    fun setOnUpdateClickListener(listener: (UserProfile_21) -> Unit) {
        OnUpdateClickListener = listener
    }

    inner class ProfileViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        private val profileName: TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDob: TextView = itemView.findViewById(R.id.DobTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.DistrictTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.MobileTxt)
        private val updateBtn: ImageButton = itemView.findViewById(R.id.updateBtn)
        private val deleteBtn: ImageButton = itemView.findViewById(R.id.deleteBtn)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    OnItemClickListener?.invoke(profile)
                }
            }
            deleteBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    OnDeleteClickListener?.invoke(profile)
                }
            }
            updateBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    OnUpdateClickListener?.invoke(profile)
                }
            }

        }

        fun bind(userProfile21: UserProfile_21) {
            profileName.text = userProfile21.name
            profileEmail.text = userProfile21.email
            profileDob.text = userProfile21.dob
            profileDistrict.text = userProfile21.district
            profileMobile.text = userProfile21.mobile

        }

    }
}
class  DiffCallback :DiffUtil.ItemCallback<UserProfile_21>(){
    override fun areItemsTheSame(oldItem: UserProfile_21, newItem: UserProfile_21): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserProfile_21, newItem: UserProfile_21): Boolean {
        return  oldItem == newItem

    }

}


