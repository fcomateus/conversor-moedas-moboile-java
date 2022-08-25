package com.example.aula01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.value = findViewById(R.id.value);
        this.mViewHolder.resDolar = findViewById(R.id.resDolar);
        this.mViewHolder.resEuro = findViewById(R.id.resEuro);
        this.mViewHolder.calculate = findViewById(R.id.calculate);

        this.mViewHolder.calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.calculate){
            String valor = this.mViewHolder.value.getText().toString();
            if("".equals(valor)){
                //pop up
                Toast.makeText(this, this.getString(R.string.inform_value), Toast.LENGTH_LONG).show();
            } else {
                Double valueInReal = Double.valueOf(valor);
                this.mViewHolder.resDolar.setText(String.format("%.2f",(valueInReal/5)));
                this.mViewHolder.resEuro.setText(String.format("%.2f",(valueInReal/6)));

            }
        }
    }

    private void clearValues() {
        this.mViewHolder.resDolar.setText("");
        this.mViewHolder.resEuro.setText("");
    }

    private static class ViewHolder {
        EditText value;
        TextView resDolar;
        TextView resEuro;
        Button calculate;
    }

}