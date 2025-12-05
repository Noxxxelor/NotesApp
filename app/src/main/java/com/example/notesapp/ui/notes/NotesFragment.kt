package com.example.notesapp.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notesapp.databinding.FragmentNotesBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.notesapp.R


@AndroidEntryPoint
class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteViewModel by viewModels()

    private val adapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotesBinding.inflate(inflater, container, false)

        binding.recyclerViewNotes.adapter = adapter

        viewModel.notesLiveData.observe(viewLifecycleOwner) { notes ->
            adapter.submitList(notes)
        }

        binding.fabAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addEditNoteFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}