package com.smarttoolfactory.toolbarsamples.activity

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
import com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.PostActvitiyStateAdapter
import java.util.*


/**
 * Setting scroll flags changes behavior when appbar should expanded size
 * or snap from expanded size to collapsed size only
 *
 */
class Activity3CollapsingToolbarScrollFlags : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3_collapsing_toolbar_scroll_flags)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Hello World"

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = PostActvitiyStateAdapter(this)


        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { v: View? ->
            Snackbar.make(
                v!!,
                "Hello World",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        val params = collapsingToolbar.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = (SCROLL_FLAG_SCROLL or SCROLL_FLAG_SNAP)


        collapsingToolbar.layoutParams = params

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_flags, menu)
        // return true so that the menu pop up is opened
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.menu_item_more -> {

                val collapsingToolbar =
                    findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

                ScrollSelectionDialogFragment(collapsingToolbar).show(supportFragmentManager, null)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class ScrollSelectionDialogFragment(private val collapsingToolbarLayout: CollapsingToolbarLayout) :
        DialogFragment() {

        private fun isFlagSet(value: Int, flag: Int): Boolean {
            return getBit(value, bitPositions(flag).first()) == 1
        }

        private fun getBit(value: Int, position: Int): Int {
            return (value shr position) and 1
        }

        private fun bitPositions(number: Int): List<Int> {

            var number = number
            val positions: MutableList<Int> = ArrayList()
            var position = 0
            while (number != 0) {
                if (number and 1 != 0) {
                    positions.add(position)
                }
                position++
                number = number ushr 1
            }
            return positions
        }

        // 1
        private val SCROLL_FLAG = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL

        // 2
        private val SCROLL_FLAG_EXIT_UNTIL_COLLAPSED =
            AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED

        // 4
        private val SCROLL_FLAG_ENTER_ALWAYS = AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS

        // 8
        private val SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED =
            AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED

        // 16
        private val SCROLL_FLAG_SNAP = AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP


        var isSnapEnabled = false

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val inflater = requireActivity().layoutInflater
            val view: View = inflater.inflate(R.layout.dialog_scroll_flags, null)

            // Get CollapsingToolbar Params
            val params = (collapsingToolbarLayout.layoutParams as AppBarLayout.LayoutParams)
            // Get Scroll flags
            val scrollFlags = params.scrollFlags
            var newFlag = scrollFlags

            println("👻 INIT FLAG: $scrollFlags")
            println("😀 ${isFlagSet(scrollFlags, SCROLL_FLAG_SNAP)}")
            println("Bit positions: ${bitPositions(SCROLL_FLAG_SNAP)}")

            val checkBoxSnap = view.findViewById<CheckBox>(R.id.checkboxSnap)
            checkBoxSnap.isChecked = isFlagSet(scrollFlags, SCROLL_FLAG_SNAP)
            // 10001

            checkBoxSnap.setOnCheckedChangeListener { buttonView, isChecked ->

                newFlag = if (isChecked) {
                    // Add snap flag
                    newFlag or SCROLL_FLAG_SNAP
                } else {
                    // Remove snap flag
                    newFlag xor SCROLL_FLAG_SNAP
                }

                println("😀 ${getBit(newFlag, 4)}")


                params.scrollFlags = newFlag
                collapsingToolbarLayout.layoutParams = params
                collapsingToolbarLayout.requestLayout()

            }


            val radioSelectedIndex = when {
                isFlagSet(scrollFlags, SCROLL_FLAG_EXIT_UNTIL_COLLAPSED) -> {
                    1
                }
                isFlagSet(scrollFlags, SCROLL_FLAG_ENTER_ALWAYS) -> {
                    2
                }
                isFlagSet(scrollFlags, SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED) -> {
                    3
                }
                else -> 0
            }


            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupScroll)

            (radioGroup.getChildAt(radioSelectedIndex) as? RadioButton)?.isChecked = true

            radioGroup.setOnCheckedChangeListener { group, checkedId ->

                when (checkedId) {

                    R.id.radioNone -> {
                        // Remove old scroll flags
                        newFlag = newFlag and (1 shl 1).inv() //  (bit 1 cleared)
                        newFlag = newFlag and (1 shl 2).inv() //  (bit 2 cleared)
                        newFlag = newFlag and (1 shl 3).inv() //  (bit 3 cleared)
                    }


                    R.id.radioExitUntilCollapsed -> {
                        // Remove old scroll flags

                        newFlag = newFlag and (1 shl 1).inv() //  (bit 1 cleared)
                        newFlag = newFlag and (1 shl 2).inv() //  (bit 2 cleared)
                        newFlag = newFlag and (1 shl 3).inv() //  (bit 3 cleared)

                        // Add new flag
                        newFlag = newFlag or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                        println("🎃 EXIT NEW FLAG: $newFlag")


                    }
                    R.id.radioEnterAlways -> {
                        // Remove old scroll flags
                        newFlag = newFlag and (1 shl 1).inv() //  (bit 1 cleared)
                        newFlag = newFlag and (1 shl 2).inv() //  (bit 2 cleared)
                        newFlag = newFlag and (1 shl 3).inv() //  (bit 3 cleared)

                        // Add new flag
                        newFlag = newFlag or SCROLL_FLAG_ENTER_ALWAYS
                        println("🎃 ENTER NEW FLAG: $newFlag")

                    }
                    R.id.radioEnterAlwaysCollapsed -> {
                        // Remove old scroll flags
                        newFlag = newFlag and (1 shl 1).inv() //  (bit 1 cleared)
                        newFlag = newFlag and (1 shl 2).inv() //  (bit 2 cleared)
                        newFlag = newFlag and (1 shl 3).inv() //  (bit 3 cleared)

                        // Add new flag
                        newFlag = newFlag or SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED
                        println("🎃 ENTER_COLLAPSED NEW FLAG: $newFlag")

                    }
                }


                params.scrollFlags = newFlag
                collapsingToolbarLayout.layoutParams = params
                collapsingToolbarLayout.requestLayout()
            }


            val builder = AlertDialog.Builder(requireActivity())

            builder.setTitle("Collapse Toolbar Flags")
                .setView(view)
                .setNegativeButton("CANCEL") { dialog, which ->
                    dismiss()
                }
                .setPositiveButton("SET") { dialog, which ->

                }

            return builder.create()
        }

    }


}