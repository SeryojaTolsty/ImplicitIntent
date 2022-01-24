package ru.gb.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class CreateMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText messageView;
    private Button messageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        messageView = findViewById(R.id.write_message);
        messageButton = findViewById(R.id.send_message);

        messageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);  //блокирует выведение чекбокса "Всегда выбирать это приложение" в диалоговом окне
        startActivity(chosenIntent);       //переход к диалоговсому окну с заранее установленной блокировкой чекбокса "Всегда выбирать это приложение"
//        startActivity(intent);       //переход к диалоговсому окну с разрешённым чекбоксом "Всегда выбирать это приложение"
    }
}