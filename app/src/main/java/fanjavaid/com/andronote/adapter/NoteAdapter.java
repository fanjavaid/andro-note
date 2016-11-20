package fanjavaid.com.andronote.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fanjavaid.com.andronote.R;
import fanjavaid.com.andronote.model.Note;

/**
 * Created by fanjavaid on 11/15/16.
 */

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView mNoteTitle = (TextView) convertView.findViewById(R.id.note_title);
        TextView mNotePrefix = (TextView) convertView.findViewById(R.id.note_prefix);
        TextView mNoteContent = (TextView) convertView.findViewById(R.id.note_content);

        mNoteTitle.setText(note.getTitle());
        mNotePrefix.setText(note.getPrefix());
        mNoteContent.setText(note.getContent());

        return convertView;
    }
}
