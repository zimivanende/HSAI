package android.samples.fietsveilig.minigames;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.samples.fietsveilig.R;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MemoryActivity extends AppCompatActivity {

    private TextView m_tvScore, m_tvTurns;
    private ImageView m_iv_11, m_iv_12, m_iv_13, m_iv_14, m_iv_21, m_iv_22,
            m_iv_23, m_iv_24, m_iv_31, m_iv_32, m_iv_33, m_iv_34;

    private int m_im_101, m_im_102, m_im_103, m_im_104, m_im_105, m_im_106,
            m_im_201, m_im_202, m_im_203, m_im_204, m_im_205, m_im_206;

    private Integer[] m_cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    private int m_cardOne, m_cardTwo;
    private int m_clickedFirst, m_clickedSecond;
    private int m_cardNumber = 1;

    private int m_score = 0;
    private int m_turns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        m_tvScore = (TextView) findViewById(R.id.memory_score);
        m_tvTurns = (TextView) findViewById(R.id.memory_turns);

        instantiateBoard();
        setTags();
        setFrontOfCards();
        addClickListeners();
        Collections.shuffle(Arrays.asList(m_cardsArray));
    }

    private void instantiateBoard() {
        m_iv_11 = (ImageView) findViewById(R.id.iv_11);
        m_iv_12 = (ImageView) findViewById(R.id.iv_12);
        m_iv_13 = (ImageView) findViewById(R.id.iv_13);
        m_iv_14 = (ImageView) findViewById(R.id.iv_14);
        m_iv_21 = (ImageView) findViewById(R.id.iv_21);
        m_iv_22 = (ImageView) findViewById(R.id.iv_22);
        m_iv_23 = (ImageView) findViewById(R.id.iv_23);
        m_iv_24 = (ImageView) findViewById(R.id.iv_24);
        m_iv_31 = (ImageView) findViewById(R.id.iv_31);
        m_iv_32 = (ImageView) findViewById(R.id.iv_32);
        m_iv_33 = (ImageView) findViewById(R.id.iv_33);
        m_iv_34 = (ImageView) findViewById(R.id.iv_34);
    }

    private void setTags() {
        m_iv_11.setTag("0");
        m_iv_12.setTag("1");
        m_iv_13.setTag("2");
        m_iv_14.setTag("3");
        m_iv_21.setTag("4");
        m_iv_22.setTag("5");
        m_iv_23.setTag("6");
        m_iv_24.setTag("7");
        m_iv_31.setTag("8");
        m_iv_32.setTag("9");
        m_iv_33.setTag("10");
        m_iv_34.setTag("11");
    }

    private void setFrontOfCards() {
        m_im_101 = R.drawable.borden;
        m_im_102 = R.drawable.borden2;
        m_im_103 = R.drawable.borden3;
        m_im_104 = R.drawable.borden4;
        m_im_105 = R.drawable.borden5;
        m_im_106 = R.drawable.borden6;
        m_im_201 = R.drawable.borden;
        m_im_202 = R.drawable.borden2;
        m_im_203 = R.drawable.borden3;
        m_im_204 = R.drawable.borden4;
        m_im_205 = R.drawable.borden5;
        m_im_206 = R.drawable.borden6;

    }

    private void addClickListeners() {
        m_iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_11, theCard);
            }
        });
        m_iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_12, theCard);
            }
        });
        m_iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_13, theCard);
            }
        });
        m_iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_14, theCard);
            }
        });
        m_iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_21, theCard);
            }
        });
        m_iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_22, theCard);
            }
        });
        m_iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_23, theCard);
            }
        });
        m_iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_24, theCard);
            }
        });
        m_iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_31, theCard);
            }
        });
        m_iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_32, theCard);
            }
        });
        m_iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_33, theCard);
            }
        });
        m_iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doTurn(m_iv_34, theCard);
            }
        });
    }

    private void doTurn(ImageView v, int pickedCard) {
        if (m_cardsArray[pickedCard] == 101)
            v.setImageResource(m_im_101);
        else if (m_cardsArray[pickedCard] == 102)
            v.setImageResource(m_im_102);
        else if (m_cardsArray[pickedCard] == 103)
            v.setImageResource(m_im_103);
        else if (m_cardsArray[pickedCard] == 104)
            v.setImageResource(m_im_104);
        else if (m_cardsArray[pickedCard] == 105)
            v.setImageResource(m_im_105);
        else if (m_cardsArray[pickedCard] == 106)
            v.setImageResource(m_im_106);
        else if (m_cardsArray[pickedCard] == 201)
            v.setImageResource(m_im_201);
        else if (m_cardsArray[pickedCard] == 202)
            v.setImageResource(m_im_202);
        else if (m_cardsArray[pickedCard] == 203)
            v.setImageResource(m_im_203);
        else if (m_cardsArray[pickedCard] == 204)
            v.setImageResource(m_im_204);
        else if (m_cardsArray[pickedCard] == 205)
            v.setImageResource(m_im_205);
        else if (m_cardsArray[pickedCard] == 206)
            v.setImageResource(m_im_206);


        if (m_cardNumber == 1) {
            m_cardOne = m_cardsArray[pickedCard];
            if (m_cardOne > 200)
                m_cardOne = m_cardOne - 100;
            m_cardNumber = 2;
            m_clickedFirst = pickedCard;
            v.setEnabled(false);
        } else if (m_cardNumber == 2) {
            m_cardTwo = m_cardsArray[pickedCard];
            if (m_cardTwo > 200)
                m_cardTwo = m_cardTwo - 100;
            m_cardNumber = 1;
            m_clickedSecond = pickedCard;
            m_iv_11.setEnabled(false);
            m_iv_12.setEnabled(false);
            m_iv_13.setEnabled(false);
            m_iv_14.setEnabled(false);
            m_iv_21.setEnabled(false);
            m_iv_22.setEnabled(false);
            m_iv_23.setEnabled(false);
            m_iv_24.setEnabled(false);
            m_iv_31.setEnabled(false);
            m_iv_32.setEnabled(false);
            m_iv_33.setEnabled(false);
            m_iv_34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }

    }
    private void calculate () {
        if (m_cardOne == m_cardTwo) {
            if (m_clickedFirst == 0) {
                m_iv_11.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 1) {
                m_iv_12.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 2) {
                m_iv_13.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 3) {
                m_iv_14.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 4) {
                m_iv_21.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 5) {
                m_iv_22.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 6) {
                m_iv_23.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 7) {
                m_iv_24.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 8) {
                m_iv_31.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 9) {
                m_iv_32.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 10) {
                m_iv_33.setVisibility(View.INVISIBLE);
            } else if (m_clickedFirst == 11) {
                m_iv_34.setVisibility(View.INVISIBLE);
            }

            if (m_clickedSecond == 0) {
                m_iv_11.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 1) {
                m_iv_12.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 2) {
                m_iv_13.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 3) {
                m_iv_14.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 4) {
                m_iv_21.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 5) {
                m_iv_22.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 6) {
                m_iv_23.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 7) {
                m_iv_24.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 8) {
                m_iv_31.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 9) {
                m_iv_32.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 10) {
                m_iv_33.setVisibility(View.INVISIBLE);
            } else if (m_clickedSecond == 11) {
                m_iv_34.setVisibility(View.INVISIBLE);
            }

            m_score += 10;
            m_tvScore.setText("Score: " + m_score);
        }
        else {
            m_iv_11.setImageResource(R.drawable.questionmark);
            m_iv_12.setImageResource(R.drawable.questionmark);
            m_iv_13.setImageResource(R.drawable.questionmark);
            m_iv_14.setImageResource(R.drawable.questionmark);
            m_iv_21.setImageResource(R.drawable.questionmark);
            m_iv_22.setImageResource(R.drawable.questionmark);
            m_iv_23.setImageResource(R.drawable.questionmark);
            m_iv_24.setImageResource(R.drawable.questionmark);
            m_iv_31.setImageResource(R.drawable.questionmark);
            m_iv_32.setImageResource(R.drawable.questionmark);
            m_iv_33.setImageResource(R.drawable.questionmark);
            m_iv_34.setImageResource(R.drawable.questionmark);
        }
        m_iv_11.setEnabled(true);
        m_iv_12.setEnabled(true);
        m_iv_13.setEnabled(true);
        m_iv_14.setEnabled(true);
        m_iv_21.setEnabled(true);
        m_iv_22.setEnabled(true);
        m_iv_23.setEnabled(true);
        m_iv_24.setEnabled(true);
        m_iv_31.setEnabled(true);
        m_iv_32.setEnabled(true);
        m_iv_33.setEnabled(true);
        m_iv_34.setEnabled(true);
        m_turns += 1;
        m_tvTurns.setText("Beurtnummer: " + m_turns);
        checkEnd();
    }

    private void checkEnd() {
        if (m_iv_11.getVisibility() == View.INVISIBLE &&
                m_iv_12.getVisibility() == View.INVISIBLE &&
                m_iv_13.getVisibility() == View.INVISIBLE &&
                m_iv_14.getVisibility() == View.INVISIBLE &&
                m_iv_21.getVisibility() == View.INVISIBLE &&
                m_iv_22.getVisibility() == View.INVISIBLE &&
                m_iv_23.getVisibility() == View.INVISIBLE &&
                m_iv_24.getVisibility() == View.INVISIBLE &&
                m_iv_31.getVisibility() == View.INVISIBLE &&
                m_iv_32.getVisibility() == View.INVISIBLE &&
                m_iv_33.getVisibility() == View.INVISIBLE &&
                m_iv_34.getVisibility() == View.INVISIBLE) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MemoryActivity.this);
            alertDialogBuilder
                    .setMessage("Proficiat, je hebt het spel uitgespeeld in " + m_turns + " beurten")
                    .setCancelable(false)
                    .setPositiveButton("Opnieuw spelen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            Intent transfer = new Intent(getApplicationContext(), MemoryActivity.class);
                            startActivity(transfer);
                        }
                    })
                    .setNegativeButton("Stoppen met spelen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}
