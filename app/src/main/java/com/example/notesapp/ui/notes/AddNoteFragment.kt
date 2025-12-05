package com.example.notesapp.ui.addedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.notesapp.databinding.FragmentAddEditNoteBinding
import com.example.notesapp.ui.notes.NoteViewModel
import com.example.notesapp.data.model.Note
import java.util.UUID

class AddEditNoteFragment : Fragment() {

    private var _binding: FragmentAddEditNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEditNoteBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {
            val title = binding.editTitle.text.toString().trim()
            val content = binding.editContent.text.toString().trim()

            if (title.isNotEmpty() || content.isNotEmpty()) {
                val note = Note(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    content = content
                )
                viewModel.addNote(note)
                findNavController().navigateUp()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}