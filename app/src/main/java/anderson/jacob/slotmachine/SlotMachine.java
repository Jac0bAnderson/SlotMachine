package anderson.jacob.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class SlotMachine extends AppCompatActivity {
    //widgets
    private Button slotStart;
    private ImageView slot1;
    private ImageView slot2;
    private ImageView slot3;
    private TextView  totalCoins;
    private TextView  latestWinning;
    private TextView  prevJCoins;

    //primitives
    private int slot1Value;
    private int slot2Value;
    private int slot3Value;
    private int slot1Number;
    private int slot2Number;
    private int slot3Number;
    private int lastWin;
    private int prev;
    private long playerCoins;
    private long prevCoins;
    private long spinCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_machine);

        slotStart = (Button) findViewById(R.id.slotStart);
        slot1 = (ImageView) findViewById(R.id.slot1);
        slot2 = (ImageView) findViewById(R.id.slot2);
        slot3 = (ImageView) findViewById(R.id.slot3);
        totalCoins =(TextView) findViewById(R.id.totalCoins);
        latestWinning =(TextView) findViewById(R.id.latestWinning);
        prevJCoins = (TextView) findViewById(R.id.prevJCoins);

        spinCount = 0;
        playerCoins =25;
        prev = 0;
        slot1Number = 3;
        slot2Number = 3;
        slot3Number = 3;
        slot1Value = 0;
        slot2Value = 0;
        slot3Value = 0;

        setupListenrs();
        setupPayOut();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slot_machine, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void setupListenrs()
    {
        slotStart.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                spinCount = spinCount+1;
                prevCoins = playerCoins;
                //if(playerCoins<=0)
                //{
                   //setupLoser();
                //}
                playerCoins = playerCoins - 2;
                prev = prev+1;
                totalCoins.setText("Coins: "+playerCoins);
                slot1Number = (int) (Math.random()*129);
                slot2Number = (int) (Math.random()*129);
                slot3Number = (int) (Math.random()*129);
                if(prev ==2)
                {

                    prevJCoins.setText(""+prevCoins);
                    prev= prev -1;
                }




                setupSlotOne();
                setupSlotTwo();
                setupSlotThree();


            }


        });
    }

    private void setupSlotOne()
    {
        //lemon
        if(slot1Number == 1 || slot1Number == 2 || slot1Number == 42 || slot1Number == 43 || slot1Number == 63)
        {
            slot1Value =1;
            ImageView slot1 = (ImageView) findViewById(R.id.slot1);
            slot1.setImageResource(R.drawable.lemon);


        }
        //bar
        else if(slot1Number ==  8 || slot1Number == 9  || slot1Number == 10 || slot1Number == 11 ||
                slot1Number ==12 || slot1Number == 31 || slot1Number == 32 || slot1Number == 33 ||
                slot1Number == 34 || slot1Number == 35|| slot1Number == 82 || slot1Number == 83 ||
                slot1Number == 84 || slot1Number == 85|| slot1Number == 86 || slot1Number == 87   )
        {
            slot1Value =2;
            ImageView slot1 = (ImageView) findViewById(R.id.slot1);
            slot1.setImageResource(R.drawable.bar);


        }
        //bar2
        else if(slot1Number == 50 || slot1Number == 51 || slot1Number == 52 || slot1Number == 53 ||
                slot1Number == 54 || slot1Number == 55 || slot1Number == 56 || slot1Number == 70 ||
                slot1Number == 71 || slot1Number == 72 || slot1Number == 73 || slot1Number == 74 ||
                slot1Number == 75)
        {
            slot1Value=3;
            ImageView slot1 = (ImageView) findViewById(R.id.slot1);
            slot1.setImageResource(R.drawable.bar2);

        }
        //bar3
        else if(slot1Number ==94 || slot1Number==95 || slot1Number == 96 || slot1Number == 97 || slot1Number == 98
                || slot1Number == 99 || slot1Number == 100 || slot1Number == 101 || slot1Number == 102 ||
                slot1Number == 103 || slot1Number == 104)
        {
            slot1Value=4;
            ImageView slot1 = (ImageView) findViewById(R.id.slot1);
            slot1.setImageResource(R.drawable.bar3);

        }
        //7
        else if(slot1Number == 18 || slot1Number == 19|slot1Number ==20||slot1Number ==21||slot1Number ==22
                ||slot1Number ==23||slot1Number ==24||slot1Number ==25)
        {
            slot1Value = 5;
            ImageView slot1 = (ImageView) findViewById(R.id.slot1);
            slot1.setImageResource(R.drawable.seven);

        }
        //jackpot
        else if(slot1Number == 116||slot1Number==117)
        {
            slot1Value=6;
            ImageView slot1 = (ImageView) findViewById(R.id.slot1);
            slot1.setImageResource(R.drawable.jackpot);

        }
        //blank spaces
        else
        {
            slot1Value = 7;
            slot1.setVisibility(View.INVISIBLE);

        }
        setupPayOut();

    }

    private void setupSlotTwo()
    {
        //lemon
        if(slot2Number == 1 || slot2Number == 2 || slot2Number == 42 || slot2Number == 43 || slot2Number == 63)
        {
            slot2Value=1;
            ImageView slot2 = (ImageView) findViewById(R.id.slot2);
            slot2.setImageResource(R.drawable.lemon);

        }
        //bar
        else if(slot2Number ==  8 || slot2Number == 9  || slot2Number == 10 || slot2Number == 11 ||
                slot2Number ==12 || slot2Number == 31 || slot2Number == 32 || slot2Number == 33 ||
                slot2Number == 34 || slot2Number == 35|| slot2Number == 82 || slot2Number == 83 ||
                slot2Number == 84 || slot2Number == 85|| slot2Number == 86 || slot2Number == 87   )
        {
            slot2Value=2;
            ImageView slot2 = (ImageView) findViewById(R.id.slot2);
            slot2.setImageResource(R.drawable.bar);


        }
        //bar2
        else if(slot2Number == 50 || slot2Number == 51 || slot2Number == 52 || slot2Number == 53 ||
                slot2Number == 54 || slot2Number == 55 || slot2Number == 56 || slot2Number == 70 ||
                slot2Number == 71 || slot2Number == 72 || slot2Number == 73 || slot2Number == 74 ||
                slot2Number == 75)
        {
            slot2Value=3;
            ImageView slot2 = (ImageView) findViewById(R.id.slot2);
            slot2.setImageResource(R.drawable.bar2);

        }
        //bar3
        else if(slot2Number ==94 || slot2Number==95 || slot2Number == 96 || slot2Number == 97 || slot2Number == 98
                || slot2Number == 99 || slot2Number == 100 || slot2Number == 101 || slot2Number == 102 ||
                slot2Number == 103 || slot2Number == 104)
        {
            slot2Value=4;
            ImageView slot2 = (ImageView) findViewById(R.id.slot2);
            slot2.setImageResource(R.drawable.bar3);

        }
        //7
        else if(slot2Number == 18 || slot2Number == 19|slot2Number ==20||slot2Number ==21||slot2Number ==22
                ||slot2Number ==23||slot2Number ==24||slot2Number ==25)
        {
            slot2Value=5;
            ImageView slot2 = (ImageView) findViewById(R.id.slot2);
            slot2.setImageResource(R.drawable.seven);

        }
        //jackpot
        else if(slot2Number == 116||slot2Number==117)
        {
            slot2Value=6;
            ImageView slot2 = (ImageView) findViewById(R.id.slot2);
            slot2.setImageResource(R.drawable.jackpot);

        }
        //blank spaces
        else
        {
            slot2Value=7;
            slot2.setVisibility(View.INVISIBLE);

        }
        setupPayOut();

    }

    private void setupSlotThree()
    {
        //lemon
        if(slot3Number == 1 || slot3Number == 2 || slot3Number == 42 || slot3Number == 43 || slot3Number == 63)
        {
            slot3Value=1;
            ImageView slot3 = (ImageView) findViewById(R.id.slot3);
            slot3.setImageResource(R.drawable.jackpot);

        }
        //bar
        else if(slot3Number ==  8 || slot3Number == 9  || slot3Number == 10 || slot3Number == 11 ||
                slot3Number ==12 || slot3Number == 31 || slot3Number == 32 || slot3Number == 33 ||
                slot3Number == 34 || slot3Number == 35|| slot3Number == 82 || slot3Number == 83 ||
                slot3Number == 84 || slot3Number == 85|| slot3Number == 86 || slot3Number == 87   )
        {
            slot3Value=2;
            ImageView slot3 = (ImageView) findViewById(R.id.slot3);
            slot3.setImageResource(R.drawable.bar);


        }
        //bar2
        else if(slot3Number == 50 || slot3Number == 51 || slot3Number == 52 || slot3Number == 53 ||
                slot3Number == 54 || slot3Number == 55 || slot3Number == 56 || slot3Number == 70 ||
                slot3Number == 71 || slot3Number == 72 || slot3Number == 73 || slot3Number == 74 ||
                slot3Number == 75)
        {
            slot3Value=3;
            ImageView slot3 = (ImageView) findViewById(R.id.slot3);
            slot3.setImageResource(R.drawable.bar2);

        }
        //bar3
        else if(slot3Number ==94 || slot3Number==95 || slot3Number == 96 || slot3Number == 97 || slot3Number == 98
                || slot3Number == 99 || slot3Number == 100 || slot3Number == 101 || slot3Number == 102 ||
                slot3Number == 103 || slot3Number == 104)
        {
            slot3Value=4;
            ImageView slot3 = (ImageView) findViewById(R.id.slot3);
            slot3.setImageResource(R.drawable.bar3);

        }
        //7
        else if(slot3Number == 18 || slot3Number == 19|slot3Number ==20||slot3Number ==21||slot3Number ==22
                ||slot3Number ==23||slot3Number ==24||slot3Number ==25)
        {
            slot3Value=5;
            ImageView slot3 = (ImageView) findViewById(R.id.slot3);
            slot3.setImageResource(R.drawable.seven);

        }
        //jackpot
        else if(slot3Number == 116||slot3Number==117)
        {
            slot3Value=6;
            ImageView slot3 = (ImageView) findViewById(R.id.slot3);
            slot3.setImageResource(R.drawable.jackpot);

        }
        //blank spaces
        else
        {
            slot3Value=7;
            slot3.setVisibility(View.INVISIBLE);

        }
        setupPayOut();

    }

    private void setupPayOut()
    {
        //single lemon pay outs
        if(slot1Value == 1 && slot2Value !=1 && slot3Value !=1)
        {
            playerCoins = playerCoins +3;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 3;
            latestWinning.setText(""+lastWin);

        }
        else if(slot1Value != 1 && slot2Value ==1 && slot3Value !=1)
        {
            playerCoins = playerCoins +3;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 3;
            latestWinning.setText(""+lastWin);

        }
        else if(slot1Value != 1 && slot2Value !=1 && slot3Value ==1)
        {
            playerCoins = playerCoins +3;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 3;
            latestWinning.setText(""+lastWin);

        }
        //double lemon pay out
        else if(slot1Value == 1 && slot2Value == 1 && slot3Value !=1)
        {
            playerCoins = playerCoins + 6;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 6;
            latestWinning.setText(""+lastWin);
        }

        else if(slot1Value == 1 && slot2Value != 1 && slot3Value ==1)
        {
            playerCoins = playerCoins + 6;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 6;
            latestWinning.setText(""+lastWin);


        }
        else if(slot1Value !=1 && slot2Value ==1 && slot3Value == 1)
        {
            playerCoins = playerCoins + 6;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 6;
            latestWinning.setText(""+lastWin);


        }
        //3 lemons
        else if (slot1Value == 1 && slot2Value == 1 && slot3Value == 1)
        {
            playerCoins = playerCoins + 12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);

        }
        //any 3 bar
        else if(slot1Value ==2 && slot2Value ==2 && slot3Value== 3)
        {
            playerCoins = playerCoins + 12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 2 && slot2Value == 2 && slot3Value ==4)
        {
            playerCoins = playerCoins + 12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value==2 && slot2Value == 3 && slot3Value ==2 )
        {
            playerCoins = playerCoins + 12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if (slot1Value == 2 && slot2Value == 4 && slot3Value == 2)
        {
            playerCoins = playerCoins +12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if (slot1Value == 2 && slot2Value ==3 && slot3Value == 3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value ==2 && slot2Value ==4 && slot3Value == 4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 2 && slot2Value == 4 && slot3Value == 3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 2 && slot2Value == 3 && slot3Value == 4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value== 3 && slot2Value == 2 && slot3Value ==3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value==3 && slot2Value ==2 && slot3Value ==4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 3 && slot2Value == 3 && slot3Value==2)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 3 && slot2Value == 4 && slot3Value == 2)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value==3 && slot2Value == 4 && slot3Value==4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value==3 && slot2Value==4 && slot3Value==3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value==3 && slot2Value ==3 &slot3Value==4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 3 && slot2Value ==2 && slot3Value == 2)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value ==4 && slot2Value== 2 && slot3Value ==3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value ==4 && slot2Value== 2 && slot3Value == 4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 4 && slot2Value == 3 && slot3Value==2)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value ==4 && slot2Value== 4 && slot3Value==2)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value==4 && slot2Value==3 && slot3Value==3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 4 && slot2Value ==4 &&slot3Value == 3)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value == 4 && slot2Value ==3 && slot3Value ==4)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        else if(slot1Value ==4 && slot2Value == 2 && slot3Value ==2)
        {
            playerCoins=playerCoins+12;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 12;
            latestWinning.setText(""+lastWin);
        }
        //3  bars
        else if(slot1Value ==2 && slot2Value ==2 && slot3Value==2)
        {
            playerCoins=playerCoins+25;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 25;
            latestWinning.setText(""+lastWin);
        }
        //3 2Bars
        else if(slot1Value==3 && slot2Value == 3 && slot3Value ==3)
        {
            playerCoins=playerCoins+50;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 50;
            latestWinning.setText(""+lastWin);
        }
        //3 3bars
        else if(slot1Value == 4 && slot2Value == 4 && slot3Value== 4)
        {
            playerCoins=playerCoins+100;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 100;
            latestWinning.setText(""+lastWin);
        }
        //3 sevens
        else if(slot1Value == 5 && slot2Value == 5 && slot3Value==5)
        {
            playerCoins=playerCoins+300;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 300;
            latestWinning.setText(""+lastWin);
        }
        //Jackpot
        else if(slot1Value == 6 && slot2Value == 6 && slot3Value == 6)
        {
            playerCoins=playerCoins+1666;
            totalCoins.setText("Coins: "+playerCoins);
            lastWin= 1666;
            latestWinning.setText(""+lastWin);
        }

    }



}
