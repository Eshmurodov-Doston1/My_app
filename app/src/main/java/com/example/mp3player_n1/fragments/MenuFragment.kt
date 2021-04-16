package com.example.mp3player_n1.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.mp3player_n1.R
import com.example.mp3player_n1.adapters.ViewPagerAdapter
import com.example.mp3player_n1.databinding.FragmentMenuBinding
import com.example.mp3player_n1.models.Category
import nl.joery.animatedbottombar.AnimatedBottomBar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var fragmentMenuBinding:FragmentMenuBinding
    lateinit var root:View
    lateinit var categoryList:ArrayList<Category>
    lateinit var viewPagerAdapter: ViewPagerAdapter
    private  val TAG = "MenuFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMenuBinding = FragmentMenuBinding.inflate(inflater,container,false)
        root = fragmentMenuBinding.root
        loadCategory()
        setUpView()
        fragmentMenuBinding.viewPager.adapter =viewPagerAdapter
        fragmentMenuBinding.bottomNavigation.onTabSelected={
           when(it.title.toLowerCase()){
               "home".toLowerCase()->{
                   fragmentMenuBinding.viewPager.currentItem = 0
                   fragmentMenuBinding.bottomNavigation.tabColorSelected = Color.parseColor("#FF5722")
                   fragmentMenuBinding.bottomNavigation.indicatorColor = Color.parseColor("#FF5722")
                   fragmentMenuBinding.bottomNavigation.rippleColor = Color.parseColor("#FF5722")
               }
               "settings".toLowerCase()->{
                   fragmentMenuBinding.viewPager.currentItem = 1
                   fragmentMenuBinding.bottomNavigation.tabColorSelected = Color.parseColor("#0707B1")
                   fragmentMenuBinding.bottomNavigation.rippleColor = Color.parseColor("#0707B1")
                   fragmentMenuBinding.bottomNavigation.indicatorColor= Color.BLUE

               }
               "user".toLowerCase()->{
                   fragmentMenuBinding.viewPager.currentItem = 2
                   fragmentMenuBinding.bottomNavigation.tabColorSelected = Color.parseColor("#930234")
                   fragmentMenuBinding.bottomNavigation.indicatorColor = Color.parseColor("#930234")
                   fragmentMenuBinding.bottomNavigation.rippleColor = Color.parseColor("#930234")
               }
           }
        }

        var click = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(fragmentMenuBinding.viewPager.currentItem==0){
                   activity!!.finish()
                }else{
                    fragmentMenuBinding.viewPager.currentItem=0
                }
            }
            }
               requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,click)
        return root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setUpView() {
        viewPagerAdapter = ViewPagerAdapter(categoryList, fragmentManager!!)
        fragmentMenuBinding.viewPager.adapter =viewPagerAdapter
        fragmentMenuBinding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        fragmentMenuBinding.bottomNavigation.selectTabById(R.id.home,true)
                    }
                    1 -> {
                        fragmentMenuBinding.bottomNavigation.selectTabById(R.id.settings,true)
                        Log.d(TAG, "onPageSelected: ${fragmentMenuBinding.bottomNavigation.selectedIndex}")
                    }
                    2 -> {
                        fragmentMenuBinding.bottomNavigation.selectTabById(R.id.user ,true)
                        Log.d(TAG, "onPageSelected: ${fragmentMenuBinding.bottomNavigation.selectedIndex}")
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun loadCategory() {
    categoryList = ArrayList()
    categoryList.add(Category("Home",R.drawable.ic_home,0))
    categoryList.add(Category("Settings",R.drawable.ic_settings,1))
    categoryList.add(Category("User",R.drawable.ic_user__1_,2))
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}