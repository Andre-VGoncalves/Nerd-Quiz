package com.example.andre.questquiz.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import com.example.andre.questquiz.R;
import com.example.andre.questquiz.ui.activity.fragment.HomeFragment;
import com.example.andre.questquiz.ui.activity.fragment.MenuFragment;
import com.example.andre.questquiz.ui.activity.fragment.StatsFragment;
import com.example.andre.questquiz.ui.activity.fragment.ViewPageAdapter;

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

    public void showPopup_por(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_portugues);
        popup.show();
    }
    public void showPopup_mat(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_matematica);
        popup.show();
    }
    public void showPopup_his(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_historia);
        popup.show();
    }
    public void showPopup_geo(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_geografia);
        popup.show();
    }
    public void showPopup_cie(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_ciencia);
        popup.show();
    }
    public void showPopup_tec(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_tecnologia);
        popup.show();
    }
    public void showPopup_fil(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_filosofia);
        popup.show();
    }
    public void showPopup_soc(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_sociologia);
        popup.show();
    }
    public void showPopup_fis(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_fisica);
        popup.show();
    }
    public void showPopup_qui(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_quimica);
        popup.show();
    }
    public void showPopup_art(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_artes);
        popup.show();
    }
    public void showPopup_idi(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_idiomas);
        popup.show();
    }
    public void showPopup_ger(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_conhecimentos_gerais);
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
    public void openCadastroPerguntas(View view){
        //Implentar aqui comando para abrir tela de cadastro para as perguntas
        setContentView(R.layout.activity_cadastro_question);
    }

}
