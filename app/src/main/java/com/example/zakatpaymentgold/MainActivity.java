package com.example.zakatpaymentgold;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etGoldValue;
    private RadioGroup rgGoldType;
    private Button btnCalculate, btnReset, btnToAbout;
    private TextView tvTotalValue, tvPayableValue, tvTotalZakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Fixed the missing R. typo here

        // Add these two lines right here:
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle("  Gold Zakat Estimator");


            getSupportActionBar().setIcon(R.drawable.ic_zakat_gold);


            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        etWeight = findViewById(R.id.etWeight);
        etGoldValue = findViewById(R.id.etGoldValue);
        rgGoldType = findViewById(R.id.rgGoldType);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        btnToAbout = findViewById(R.id.btnToAbout);

        tvTotalValue = findViewById(R.id.tvTotalValue);
        tvPayableValue = findViewById(R.id.tvPayableValue);
        tvTotalZakat = findViewById(R.id.tvTotalZakat);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateZakat();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        btnToAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateZakat() {
        String weightStr = etWeight.getText().toString().trim();
        String valueStr = etGoldValue.getText().toString().trim();

        if (weightStr.isEmpty()) {
            etWeight.setError("Please enter the gold weight");
            return;
        }
        if (valueStr.isEmpty()) {
            etGoldValue.setError("Please enter the current gold value");
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double goldValue = Double.parseDouble(valueStr);

        double xGrams = 0;
        int selectedId = rgGoldType.getCheckedRadioButtonId();

        if (selectedId == R.id.rbKeep) {
            xGrams = 85;
        } else if (selectedId == R.id.rbWear) {
            xGrams = 200;
        } else {
            Toast.makeText(this, "Please select the type of gold", Toast.LENGTH_SHORT).show();
            return;
        }

        double totalValue = weight * goldValue;
        double payableWeight = weight - xGrams;

        if (payableWeight < 0) {
            payableWeight = 0;
        }

        double zakatPayableValue = payableWeight * goldValue;
        double totalZakat = zakatPayableValue * 0.025;

        tvTotalValue.setText(String.format("Total Gold Value: RM %.2f", totalValue));
        tvPayableValue.setText(String.format("Zakat Payable Value: RM %.2f", zakatPayableValue));
        tvTotalZakat.setText(String.format("Total Zakat: RM %.2f", totalZakat));
    }

    private void clearFields() {
        etWeight.setText("");
        etGoldValue.setText("");
        rgGoldType.clearCheck();
        tvTotalValue.setText("Total Gold Value: RM 0.00");
        tvPayableValue.setText("Zakat Payable Value: RM 0.00");
        tvTotalZakat.setText("Total Zakat: RM 0.00");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the user clicked the Share item from the Action Bar
        if (item.getItemId() == R.id.action_share) {

            // 1. Define the message you want to share (Your assignment requires your GitHub URL)
            String shareMessage = "Hey! Check out this Gold Zakat Estimator app. " +
                    "You can view the source code and documentation here: " +
                    "https://github.com/yourusername/your-repository"; // <-- Replace with your real link!

            // 2. Create an implicit SEND intent
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Gold Zakat Estimator App");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

            // 3. Launch the native Android Share Sheet chooser
            startActivity(Intent.createChooser(shareIntent, "Share app via"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}