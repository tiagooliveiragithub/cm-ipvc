package dev.tiagooliveira.lab_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dev.tiagooliveira.lab_2.R
import dev.tiagooliveira.lab_2.data.entities.Note
import dev.tiagooliveira.lab_2.data.vm.NoteViewModel

class AddFragment : Fragment() {
    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        ViewModelProvider(this)[NoteViewModel::class.java].also { this.mNoteViewModel = it }

        val button = view.findViewById<Button>(R.id.save)
        button.setOnClickListener {
            addNote()
        }

        val backButton = view.findViewById<Button>(R.id.backToList)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        return view
    }

    private fun addNote() {
        val noteText = view?.findViewById<EditText>(R.id.addNote)?.text.toString()

        if(noteText.isEmpty()) {
            Toast.makeText(view?.context, "Não pode uma nota vazia!", Toast.LENGTH_LONG).show()
        } else if (noteText.length < 5) {
            Toast.makeText(view?.context, "A nota não pode ter menos de 5 caracteres!", Toast.LENGTH_LONG).show()
        }
        else {
            val note = Note(0, noteText)

            mNoteViewModel.addNote(note)

            Toast.makeText(requireContext(), "Gravado com sucesso!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }
}