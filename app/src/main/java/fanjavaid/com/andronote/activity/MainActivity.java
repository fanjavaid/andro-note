package fanjavaid.com.andronote.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fanjavaid.com.andronote.R;
import fanjavaid.com.andronote.adapter.NoteAdapter;
import fanjavaid.com.andronote.model.Note;

public class MainActivity extends AppCompatActivity {

    private ListView mListNote;
    private FloatingActionButton mCreateButton;

    private SearchView mSearchView;
    private MenuItem mSearchMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListNote = (ListView) findViewById(R.id.list_notes);
        mCreateButton = (FloatingActionButton) findViewById(R.id.create_button);

        NoteAdapter mNoteAdapter = new NoteAdapter(this, dummyList());
        mListNote.setAdapter(mNoteAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_search, menu);

        SearchManager mSearchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView = (SearchView) menu.findItem(R.id.search).getActionView();
        mSearchView.setSearchableInfo(mSearchManager.getSearchableInfo(getComponentName()));
        mSearchView.setIconified(false);
        mSearchView.clearFocus();

        return true;
    }

    public void createNote(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    private List<Note> dummyList() {
        List<Note> notes = new ArrayList<>();

        Note n1 = new Note();
        n1.setId(1);
        n1.setTitle("Add currency in textfield");
        n1.setPrefix(n1.getTitle().substring(0,1));
        n1.setContent("Color in material design is inspired by bold hues...");
        notes.add(n1);

        Note n2 = new Note();
        n2.setId(2);
        n2.setTitle("Create background image activity");
        n2.setPrefix(n2.getTitle().substring(0,1));
        n2.setContent("Lorem ipsum dolor sit amet cons...");
        notes.add(n2);

        return notes;
    }
}
