package com.grntea.ygocard;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.grntea.ygocard.Models.card;

public class DetailActivity extends AppCompatActivity {
    TextView title, type,desc, race, stat, atr;
    ImageView img, imgtype, imgatr, imgspell;
    String atk, def, trap="Trap Card", stat1, type1, atr1, race1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        view();
        card card = getIntent().getParcelableExtra("card");
        String url = getIntent().getStringExtra("image");
        title.setText(card.getName());
        type.setText(card.getType());
        desc.setText(card.getDesc());
        race.setText(card.getRace());
        race1 = race.getText().toString();
        type1 = type.getText().toString();
        if (!"Spell Card".equals(type1)){
            if(!type.getText().toString().equals(trap)) {
                if (!"Skill Card".equals(type1)) {
                    atk = String.valueOf(card.getAtk());
                    def = String.valueOf(card.getDef());
                    stat1 = "Atk " + atk + " / " + "Def " + def;
                    stat.setText(stat1);
                    atr.setText(card.getAttribute());
                    atr1 = atr.getText().toString();
                    Toast.makeText(getApplicationContext(), stat1, Toast.LENGTH_SHORT).show();
                    if ("DARK".equals(atr1)){
                        imgatr.setImageResource(R.drawable.dark);
                    }
                    else if ("DIVINE".equals(atr1)){
                        imgatr.setImageResource(R.drawable.divine);
                    }
                    else if ("EARTH".equals(atr1)){
                        imgatr.setImageResource(R.drawable.earth);
                    }
                    else if ("FIRE".equals(atr1)){
                        imgatr.setImageResource(R.drawable.fire);
                    }
                    else if ("LIGHT".equals(atr1)){
                        imgatr.setImageResource(R.drawable.light);
                    }
                    else if ("WATER".equals(atr1)){
                        imgatr.setImageResource(R.drawable.water);
                    }
                    else if ("WIND".equals(atr1)){
                        imgatr.setImageResource(R.drawable.wind);
                    }

                    switch (race1) {
                        case "Aqua":
                            imgspell.setImageResource(R.drawable.aqua);
                            break;
                        case "Beast":
                            imgspell.setImageResource(R.drawable.beast);
                            break;
                        case "Beast-Warrior":
                            imgspell.setImageResource(R.drawable.beast_warrior);
                            break;
                        case "Dinosaur":
                            imgspell.setImageResource(R.drawable.dinosaur);
                            break;
                        case "Divine-Beast":
                            imgspell.setImageResource(R.drawable.divine_beast);
                            break;
                        case "Dragon":
                            imgspell.setImageResource(R.drawable.dragon);
                            break;
                        case "Fairy":
                            imgspell.setImageResource(R.drawable.fairy);
                            break;
                        case "Fiend":
                            imgspell.setImageResource(R.drawable.fiend);
                            break;
                        case "Fish":
                            imgspell.setImageResource(R.drawable.fish);
                            break;
                        case "Insect":
                            imgspell.setImageResource(R.drawable.insect);
                            break;
                        case "Machine":
                            imgspell.setImageResource(R.drawable.machine);
                            break;
                        case "Plant":
                            imgspell.setImageResource(R.drawable.plant);
                            break;
                        case "Psychic":
                            imgspell.setImageResource(R.drawable.psychic);
                            break;
                        case "Pyro":
                            imgspell.setImageResource(R.drawable.pyro);
                            break;
                        case "Reptile":
                            imgspell.setImageResource(R.drawable.reptile);
                            break;
                        case "Rock":
                            imgspell.setImageResource(R.drawable.rock);
                            break;
                        case "Sea Serpent":
                            imgspell.setImageResource(R.drawable.sea_serpent);
                            break;
                        case "Spellcaster":
                            imgspell.setImageResource(R.drawable.spellcaster);
                            break;
                        case "Thunder":
                            imgspell.setImageResource(R.drawable.thunder);
                            break;
                        case "Warrior":
                            imgspell.setImageResource(R.drawable.warrior);
                            break;
                        case "Winged Beast":
                            imgspell.setImageResource(R.drawable.winged_beast);
                            break;
                        case "Wyrm":
                            imgspell.setImageResource(R.drawable.wyrm);
                            break;
                        case "Zombie":
                            imgspell.setImageResource(R.drawable.zombie);
                            break;
                    }
                }
            }
        }

        if("Spell Card".equals(type1)){
            imgtype.setImageResource(R.drawable.spell_card);
            switch (race1) {
                case "Continuous":
                    imgspell.setImageResource(R.drawable.continuous);
                    break;
                case "Equip":
                    imgspell.setImageResource(R.drawable.equip);
                    break;
                case "Field":
                    imgspell.setImageResource(R.drawable.field);
                    break;
                case "Normal":
                    imgspell.setImageResource(R.drawable.normal);
                    break;
                case "Quick-Play":
                    imgspell.setImageResource(R.drawable.quick_play);
                    break;
                case "Ritual":
                    imgspell.setImageResource(R.drawable.ritual);
                    break;
            }
        }
        else if("Skill Card".equals(type1)){
            imgtype.setImageResource(R.drawable.skill_card);
        }
        else if("Trap Card".equals(type1)){
            imgtype.setImageResource(R.drawable.trap_card);
            switch (race1) {
                case "Continuous":
                    imgspell.setImageResource(R.drawable.continuous);
                    break;
                case "Normal":
                    imgspell.setImageResource(R.drawable.normal);
                    break;
                case "Counter":
                    imgspell.setImageResource(R.drawable.counter);
                    break;
            }
        }
        else if("Effect Monster".equals(type1)||"Flip Effect Monster".equals(type1)||"Gemini Monster".equals(type1)||
                "Spirit Monster".equals(type1)||"Toon Monster".equals(type1)||"Tuner Monster".equals(type1)||"Union Effect Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.effect_monster);
        }
        else if("Fusion Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.fusion_monster);
        }
        else if("Link Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.link_monster);
        }
        else if("Normal Monster".equals(type1)||"Normal Tuner Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.normal_monster);
        }
        else if("Pendulum Effect Fusion Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.pendulum_effect_fusion_monster);
        }
        else if("Pendulum Effect Monster".equals(type1)||"Pendulum Flip Effect Monster".equals(type1)||"Pendulum Tuner Effect Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.pendulum_effect_monster);
        }
        else if("Pendulum Normal Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.pendulum_normal_monster);
        }
        else if("Ritual Effect Monster".equals(type1)||"Ritual Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.ritual_monster);
        }
        else if("Synchro Monster".equals(type1)||"Synchro Tuner Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.synchro_monster);
        }
        else if("Token".equals(type1)){
            imgtype.setImageResource(R.drawable.token);
        }
        else if("XYZ Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.xyz_monster);
        }
        else if("XYZ Pendulum Effect Monster".equals(type1)){
            imgtype.setImageResource(R.drawable.xyz_pendulum_effect_monster);
        }
        else{
            imgtype.setImageResource(R.drawable.card_back);
        }


        Glide.with(getApplicationContext())
                .load(url)
                .placeholder(R.drawable.card_back).into(img);

    }

    public void view(){
        title = findViewById(R.id.Title_detail);
        type = findViewById(R.id.type_detail);
        race = findViewById(R.id.race_detail);
        desc = findViewById(R.id.desc_detail);
        img = findViewById(R.id.image_detail);
        imgtype = findViewById(R.id.image_type);
        imgatr = findViewById(R.id.image_atr);
        imgspell = findViewById(R.id.image_spell);
        stat = findViewById(R.id.stat);
        atr = findViewById(R.id.atr_detail);
    }
}