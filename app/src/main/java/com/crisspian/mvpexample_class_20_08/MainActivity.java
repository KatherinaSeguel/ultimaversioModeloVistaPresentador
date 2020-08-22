package com.crisspian.mvpexample_class_20_08;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.crisspian.mvpexample_class_20_08.databinding.ActivityMainBinding;
import com.crisspian.mvpexample_class_20_08.presenter.IPresenter;
import com.crisspian.mvpexample_class_20_08.presenter.IViewPresenter;
import com.crisspian.mvpexample_class_20_08.presenter.VerifierPresenter;

public class MainActivity extends AppCompatActivity  implements IViewPresenter {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding mainBinding;
    private IPresenter mPresenter;//interface del presentador


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        mPresenter = new VerifierPresenter(this);// inicializao el presentador y con el this le paso la interface que ya la implemente

        setContentView(mainBinding.getRoot());//proyecto vista en la actividad
        mainBinding.editText.addTextChangedListener(new TextWatcher() {//se le dice que esté escuchando el ingreso de datos
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {// antes cambio texto

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {//se cambia texto

                Log.d(TAG,"changed" + s.toString());
                mPresenter.evaluatePass(s.toString());


            }

            @Override
            public void afterTextChanged(Editable editable) {//después que se cambie texto

            }
        });
    }
//estos metodos se implementan , es una interface la que implemento
    @Override
    public void showWeak() {
     Log.d(TAG,"weak");
     mainBinding.textView.setText(R.string.weak);//ocupo clase R y llamo a los string que hice
        mainBinding.textView.setBackgroundColor(Color.RED);
        mainBinding.textView.setTextColor(Color.WHITE);//color blanco a l aletra
    }

    @Override
    public void showMedium() {
        Log.d(TAG,"Medium");
        mainBinding.textView.setText(R.string.medium);
        mainBinding.textView.setBackgroundColor(Color.YELLOW);
       // mainBinding.textView.setTextColor(Color.WHITE);//color blanco a l aletra por defecto es negra
    }

    @Override
    public void showStrong() {
        Log.d(TAG,"Strong");
        mainBinding.textView.setText(R.string.strong);
        mainBinding.textView.setBackgroundColor(Color.GREEN);
       // mainBinding.textView.setTextColor(Color.WHITE);//color blanco a l aletra

    }
}