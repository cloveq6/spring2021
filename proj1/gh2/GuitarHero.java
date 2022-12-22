package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class GuitarHero {

    public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static final double CONCERT = 440.0;


    public static void main(String[] args) {
        List<GuitarString> guitarStrings = new ArrayList<>();
        for (int i=0; i<keyboard.length(); ++i){
            guitarStrings.add(new GuitarString(CONCERT * Math.pow(2, (i-24)/12.0)));
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                System.out.println(index);
                if (index >=0){
                    guitarStrings.get(index).pluck();
                }
            }

            double sample = .0;
            for (GuitarString gS : guitarStrings){
                sample += gS.sample();
            }
            StdAudio.play(sample);

            for (GuitarString gS : guitarStrings){
                gS.tic();
            }
        }
    }
}
