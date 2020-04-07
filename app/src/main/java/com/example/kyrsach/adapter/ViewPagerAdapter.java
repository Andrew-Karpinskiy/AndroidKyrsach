package com.example.kyrsach.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    //Список в котором будут храниться фрагменты
    private List<Fragment> fragmentList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    //Отображение фрагмента
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    //Количество фрагментов для отображенияя
    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    //Добавляем фрагменты в список
    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }
}
