package com.example.kyrsach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.example.kyrsach.adapter.ViewPagerAdapter;
import com.example.kyrsach.fragment.CurrencyListFragment;
import com.example.kyrsach.fragment.ConverterFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.table);
        //Создаем наш адаптер для ViewPager
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        //Передаем ему фрагменты
        viewPagerAdapter.addFragment(new CurrencyListFragment());
        viewPagerAdapter.addFragment(new ConverterFragment());
        //Устанавливаем адаптер
        viewPager.setAdapter(viewPagerAdapter);
        //Прикрепляем TabLayout и передаем ему индекс фрагмента для отображения названий
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if(position == 0 ) {
                tab.setText(R.string.currencyTab_name);
            } else {
                tab.setText(R.string.converterTab_name);
            }
        }).attach();
    }
}
