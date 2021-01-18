package ru.rosystem.diabeticassistant.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import ru.rosystem.diabeticassistant.R
import ru.rosystem.diabeticassistant.databinding.MainSettingFragmentBinding

class MainSettingFragment : Fragment() {
    private var _binding: MainSettingFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainSettingFragmentBinding.inflate(layoutInflater)
        binding.groupXe.setOnCheckedChangeListener { _, i ->
            if(i == R.id.own_xe){
                binding.defaultXe.isChecked=false
                binding.ownXeCard.visibility= View.VISIBLE
            }else{
                binding.ownXeCard.visibility= View.GONE
            }
        }
        return binding.root
    }
}