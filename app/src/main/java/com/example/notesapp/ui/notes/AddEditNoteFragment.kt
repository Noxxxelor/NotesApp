package com.example.notesapp.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesapp.data.model.Note
import com.example.notesapp.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class AddEditNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteViewModel by viewModels()
    private val args: AddEditNoteFragmentArgs by navArgs()
    private var currentNote: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentNote = args.note
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        currentNote?.let { note ->
            binding.editTitle.setText(note.title)
            binding.editContent.setText(note.content)
        }

        binding.btnSave.setOnClickListener {
            val title = binding.editTitle.text.toString().trim()
            val content = binding.editContent.text.toString().trim()

            if (title.isNotEmpty() || content.isNotEmpty()) {
                val noteToSave = currentNote?.copy(
                    title = title,
                    content = content
                ) ?: Note(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    content = content
                )
                viewModel.saveNote(noteToSave)
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
