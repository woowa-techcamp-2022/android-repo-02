package com.woowahan.repositorysearch.ui.result.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.woowahan.repositorysearch.databinding.FragmentProfileBinding
import com.woowahan.repositorysearch.extension.setUnderlineText
import com.woowahan.repositorysearch.ui.result.ResultActivity
import com.woowahan.repositorysearch.ui.result.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val sharedViewModel: ResultViewModel by activityViewModels()
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.setPageName(ResultActivity.PageName.Profile.javaClass.simpleName)

        init()
        initFlow()
    }

    private fun init() {
        viewModel.getUser()
    }

    private fun initFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.user.collect {
                binding.ivUserIcon.load(it.avatar)
                binding.tvLogin.text = it.login
                binding.tvName.text = it.name

                binding.tvType.isVisible = !it.company.isNullOrBlank()
                it.company?.let { company -> binding.tvType.text = company }

                binding.ivLocation.isVisible = !it.location.isNullOrBlank()
                binding.tvLocation.isVisible = !it.location.isNullOrBlank()
                it.location?.let { location -> binding.tvLocation.text = location }

                binding.ivLink.isVisible = !it.blog.isNullOrBlank()
                binding.tvLink.isVisible = !it.blog.isNullOrBlank()
                it.blog?.let { blog -> binding.tvLink.setUnderlineText(blog) }

                binding.ivMail.isVisible = !it.mail.isNullOrBlank()
                binding.tvMail.isVisible = !it.mail.isNullOrBlank()
                it.mail?.let { mail -> binding.tvMail.setUnderlineText(mail) }


                binding.tvFollowers.text = it.followers.toString()
                binding.tvFollowing.text = it.following.toString()
                binding.tvRepositories.text = it.repositories.toString()
                binding.tvStarred.text = it.starredSize.toString()
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect { loading ->
                binding.pbLoading.isVisible = loading
                binding.constraintProfile.isVisible = !loading
            }
        }
    }

    companion object {
        val TAG = "ProfileFragment"
    }
}