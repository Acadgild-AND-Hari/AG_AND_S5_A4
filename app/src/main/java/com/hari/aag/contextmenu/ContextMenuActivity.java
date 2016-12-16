package com.hari.aag.contextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContextMenuActivity extends AppCompatActivity {

    private final String ACTION_MESSAGE = "Action ";
    private final String TOAST_MESSAGE = "You have selected the Action ";

    private final int ACTION_ID_1 = 101;
    private final int ACTION_ID_2 = 102;
    private final int ACTION_ID_3 = 103;

    Button contextMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        contextMenuBtn = (Button) findViewById(R.id.id_context_btn);
        registerForContextMenu(contextMenuBtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(R.string.app_name);
        menu.add(0, ACTION_ID_1, 0, ACTION_MESSAGE + "1");
        menu.add(0, ACTION_ID_2, 0, ACTION_MESSAGE + "2");
        menu.add(0, ACTION_ID_3, 0, ACTION_MESSAGE + "3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String toastMsg = TOAST_MESSAGE;
        switch (item.getItemId()){
            case ACTION_ID_1:   toastMsg += "1";    break;
            case ACTION_ID_2:   toastMsg += "2";    break;
            case ACTION_ID_3:   toastMsg += "3";    break;
            default:    return super.onContextItemSelected(item);
        }
        Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
        return true;
    }
}
