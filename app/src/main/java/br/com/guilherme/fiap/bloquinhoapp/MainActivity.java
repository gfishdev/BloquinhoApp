package br.com.guilherme.fiap.bloquinhoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.guilherme.fiap.bloquinhoapp.fragment.ListFragment;

public class MainActivity extends AppCompatActivity {
    //implements DatePickerDialog.OnDateSetListener {

//    private EditText etName, etStyle, etDay;
//    private Spinner sMatch;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = ListFragment.newInstance();
//                    mTextMessage.setText(R.string.title_home);
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_about:
                    mTextMessage.setText(R.string.title_about);
                    return true;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        etName = findViewById(R.id.etName);
//        etStyle = findViewById(R.id.etStyle);
//        etDay = findViewById(R.id.etDay);
//        sMatch = findViewById(R.id.sMatch);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.match_types, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sMatch.setAdapter(adapter);
    }

//    public void find(View v) {
//        BloquinhoAPI api = getRetrofit().create(BloquinhoAPI.class);
//
//        api.findBloquinho(etName.getText().toString())
//                .enqueue(new Callback<Bloquinho>() {
//                    @Override
//                    public void onResponse(Call<Bloquinho> call, Response<Bloquinho> response) {
//                        etStyle.setText(response.body().getStyle());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Bloquinho> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Deu erro", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    public void save(View v) {
//        BloquinhoAPI api = getRetrofit().create(BloquinhoAPI.class);
//
//        Bloquinho bloquinho = new Bloquinho();
//        bloquinho.setName(etName.getText().toString());
//        bloquinho.setStyle(etStyle.getText().toString());
//        api.save(bloquinho)
//                .enqueue(new Callback<Void>() {
//                    @Override
//                    public void onResponse(Call<Void> call, Response<Void> response) {
//
//                        Toast.makeText(MainActivity.this, "Gravado com sucesso!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<Void> call, Throwable t) {
//
//                        Toast.makeText(MainActivity.this, "Deu erro", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private Retrofit getRetrofit() {
//        return new Retrofit.Builder()
//                .baseUrl("https://bloquinho-app.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int day) {
//        Calendar cal = new GregorianCalendar(year, month, day);
//        setDate(cal);
//    }
//
//    private void setDate(final Calendar calendar) {
//        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
//        etDay.setText(dateFormat.format(calendar.getTime()));
//    }
//
//    public void datePicker(View view) {
//        DatePickerFragment fragment = new DatePickerFragment();
//        fragment.show(getSupportFragmentManager(), "date");
//    }
}
