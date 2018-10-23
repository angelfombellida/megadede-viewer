package angel.megadede;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    private ListView listView;
    private FloatingActionButton fabAdd;
    private ArrayList<Program> programs;
    private ArrayAdapter<Program> programAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        fabAdd = findViewById(R.id.fabAdd);
        programs = new ArrayList<>();
        programAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item, programs);
        listView.setAdapter(programAdapter);
        listView.setOnItemClickListener(this);
        fabAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlertDialogAddProgram();
        Toast.makeText(this, "1  " + programs.size() + "", Toast.LENGTH_SHORT).show();
        programAdapter.notifyDataSetChanged();
       // Toast.makeText(this, "2 " + programs.size() + "", Toast.LENGTH_SHORT).show();
    }


    private void AlertDialogAddProgram() {
        AlertDialog.Builder b = new AlertDialog.Builder(this)
                .setMessage("Add TV program");
        View inflatedView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.alert_dialog_add, null);
        b.setView(inflatedView);
        final EditText inputTitle = inflatedView.findViewById(R.id.inputTitle);
        b.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Program p = new Program(inputTitle.getText().toString());
                programs.add(p);
            }
        });
        b.create().show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent webView = new Intent(Intent.ACTION_VIEW, programs.get(i).getLink());
        startActivity(webView);
    }
}
