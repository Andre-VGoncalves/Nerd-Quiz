package com.example.andre.questquiz.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.andre.questquiz.R;
import com.example.andre.questquiz.ui.activity.fragment.HomeFragment;
import com.example.andre.questquiz.ui.activity.fragment.MenuFragment;
import com.example.andre.questquiz.ui.activity.fragment.StatsFragment;
import com.example.andre.questquiz.ui.activity.fragment.ViewPageAdapter;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    int [] img_tab = {R.drawable.home_icon,R.drawable.conquista_icon,R.drawable.perfil_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpage_id);

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        /* Adicionando Fragments */
        adapter.AddFragment(new HomeFragment(),"");
        adapter.AddFragment(new StatsFragment(),"");
        adapter.AddFragment(new MenuFragment(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for(int i =0; i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(img_tab[i]);
        }
    }

    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        //Implentar aqui metodo para indentificar qual botão chamou
        switch (item.getItemId()){
            case R.id.item1:
               return true;
            case R.id.item2:
                return true;
            case R.id.item3:
                return true;
            case R.id.item4:
                return true;
                default:
                    return false;
        }
    }
    public void openCadastroPerguntas(){
        //Implentar aqui comando para abrir tela de cadastro para as perguntas
        
    }

}
